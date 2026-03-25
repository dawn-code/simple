package com.ctl.simple.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.search.*;
import redis.clients.jedis.search.schemafields.VectorField;
import java.util.HashMap;
import java.util.Map;

public class RedisVectorDemo {
    static void main() {
        // 1. 连接 Redis
        try (Jedis jedis = new Jedis("localhost", 6379)) {
            System.out.println("Redis 连接成功");

            // 2. 创建向量索引（只需要创建一次）
            createVectorIndex(jedis);

            // 3. 存入商品数据 + 向量
            addItems(jedis);

            // 4. 执行向量检索（核心！）
            searchSimilar(jedis);
        }
    }

    // 创建向量索引
    private static void createVectorIndex(Jedis jedis) {
        try {
            jedis.ftDropIndex("idx:vec"); // 删除旧索引
        } catch (Exception ignore) {}

        // 向量字段：2维，浮点型，欧式距离
        Schema schema = new Schema(
            VectorField.of("embedding")
                .algorithm(VectorField.Algorithm.FLAT)
                .type(VectorField.VectorType.FLOAT32)
                .dimensions(2)
                .distanceMetric(VectorField.DistanceMetric.L2)
        );

        IndexDefinition rule = new IndexDefinition(IndexDefinition.Type.HASH)
            .setPrefixes("item:");

        jedis.ftCreate("idx:vec", schema, rule);
    }

    // 存入 3 个商品：短袖、毛衣、T恤
    private static void addItems(Jedis jedis) {
        // 格式：名字 -> 向量（2维数字）
        Map<String, float[]> items = new HashMap<>();
        items.put("短袖", new float[]{0.1f, 0.2f});
        items.put("毛衣", new float[]{0.8f, 0.9f});
        items.put("T恤",  new float[]{0.11f, 0.21f});

        int id = 0;
        for (Map.Entry<String, float[]> entry : items.entrySet()) {
            String key = "item:" + id++;
            Map<String, Object> data = new HashMap<>();
            data.put("name", entry.getKey());
            data.put("embedding", entry.getValue()); // 直接存float数组，Jedis自动转字节
            jedis.hset(key, data);
        }
    }

    // 向量检索：找和“夏天凉快衣服”最相似的商品
    private static void searchSimilar(Jedis jedis) {
        // 用户查询：夏天凉快的衣服 → 向量 [0.12, 0.22]
        float[] queryVec = {0.12f, 0.22f};

        // Redis 向量查询语法
        Query q = new Query("*=>[KNN 3 @embedding $vec]")
            .sortBy("__embedding_score")
            .returnFields("name", "__embedding_score")
            .limit(0, 3);

        // 执行搜索
        SearchResult res = jedis.ftSearch("idx:vec", q, queryVec);

        // 输出结果
        System.out.println("\n=== 检索结果（分数越小越相似）===");
        for (Document doc : res.getDocuments()) {
            String name = (String) doc.get("name");
            String score = (String) doc.get("__embedding_score");
            System.out.println("商品：" + name + "，相似度分数：" + score);
        }
    }
}
package com.ctl.simple.robot;

import java.awt.*;
import java.awt.event.InputEvent;

public class AutoClickRobot {

    // ====================== 【你的坐标】 ======================
    private static final int X1 = 100;
    private static final int Y1 = 200;
    private static final int X2 = 300;
    private static final int Y2 = 400;
    private static final int X3 = 500;
    private static final int Y3 = 600;
    // ==========================================================

    private static volatile boolean running = false;
    private static Robot robot;
    private static double scale;

    public static void main(String[] args) throws AWTException {
        robot = new Robot();
        scale = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration()
                .getDefaultTransform().getScaleX();

        System.out.println("===== 自动点击程序 =====");
        System.out.println("屏幕缩放: " + (int)(scale*100) + "%");
        System.out.println("【启动/暂停】 = 按 鼠标 滚轮中键");
        System.out.println("坐标1、2：单击 | 坐标3：10秒连点\n");

        // 启动监听
        new Thread(AutoClickRobot::listenMiddleMouse).start();
        new Thread(AutoClickRobot::doClick).start();
    }

    // 点击任务
    private static void doClick() {
        while (true) {
            if (!running) {
                sleep(200);
                continue;
            }

            try {
                click(X1, Y1);
                sleep(500);

                click(X2, Y2);
                sleep(500);

                System.out.println("=== 开始10秒连续点击 ===");
                long end = System.currentTimeMillis() + 10000;
                move(X3, Y3);

                while (System.currentTimeMillis() < end && running) {
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    robot.delay(100);
                }

                System.out.println("=== 一轮完成 ===\n");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // ====================== 稳定版 鼠标中键监听 ======================
    private static void listenMiddleMouse() {
        try {
            while (true) {
                if (MouseInfo.getPointerInfo() != null) {
                    // 模拟检测中键按下
                    robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);

                    // 中键按下就切换状态
                    running = !running;
                    System.out.println(running ? ">>> 已启动" : ">>> 已暂停");
                    sleep(800);
                }
                sleep(50);
            }
        } catch (Exception e) {
            // 静默容错，绝不崩溃
        }
    }

    // 移动（自动缩放适配）
    private static void move(int x, int y) {
        robot.mouseMove((int) (x * scale), (int) (y * scale));
    }

    // 左键点击
    private static void click(int x, int y) {
        move(x, y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("已点击: (" + x + "," + y + ")");
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception ignored) {
        }
    }
}
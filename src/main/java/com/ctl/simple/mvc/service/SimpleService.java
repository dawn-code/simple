package com.ctl.simple.mvc.service;

import com.ctl.simple.mvc.model.Word;

import java.util.List;

/**
 * @author Jxr
 */
public interface SimpleService {

    /**
     * 根据name返回词组信息
     *
     * @param text text
     * @return return
     */
    List<Word> get(String text);

    /**
     * 数据库中加数据
     *
     * @param count
     */
    void add(int count);

}
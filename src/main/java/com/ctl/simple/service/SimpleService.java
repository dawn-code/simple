package com.ctl.simple.service;

import com.ctl.simple.model.Word;

import java.util.List;

/**
 * @author ctl
 */
public interface SimpleService {

    /**
     * 根据name返回词组信息
     *
     * @param text text
     * @return return
     */
    List<Word> get(String text);

    void add(int count);

}
package com.ctl.simple.mvc.model;

import lombok.Data;

/**
 * @author Jxr
 */
@Data
public class Word {
    private Integer id;
    private String text;
    private String description;
    private String type;
    private String groupBy;
    private String author;
}
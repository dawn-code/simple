package com.ctl.simple.model;

import lombok.Data;

/**
 * @author ctl
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
package com.project.medium.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BlogResponse {

    private String title;
    private Date postTime;
    private int amountComment;
    private String avatarUrl;
    private Long accountId;
    private Long id;
    private String nameCategory;
    public int likes;

}

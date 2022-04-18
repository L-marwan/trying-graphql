package com.marouane;

import lombok.Data;

@Data
public class Book {
    private String id;
    private String name;
    private String pageCount;
    private String authorId;
}

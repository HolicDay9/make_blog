package com.sparta.memo.domain;


import lombok.Getter;

@Getter
public class CommentRequestDto {

    private String description;
    private Long memoId;
}

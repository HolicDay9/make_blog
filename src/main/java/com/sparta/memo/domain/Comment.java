package com.sparta.memo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Setter
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Long memoId;

    public Comment(String description, Long memoId) {
        this.description = description;
        this.memoId = memoId;
    }

    public Comment(CommentRequestDto requestDto) {
        this.description = requestDto.getDescription();
        this.memoId = requestDto.getMemoId();
    }

    public void update(CommentRequestDto requestDto) {
        this.description = requestDto.getDescription();
        this.memoId = requestDto.getMemoId();
    }

}

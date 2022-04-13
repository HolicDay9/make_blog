package com.sparta.memo.controller;

import com.sparta.memo.domain.*;
import com.sparta.memo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @PostMapping("/api/comments")
    public Comment createComments(@RequestBody CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }

    @GetMapping("/api/comments")
    public List<Comment> getComments() {
        return commentRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/comments/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto){
        commentService.update(id, requestDto);
        return id;
    }
}
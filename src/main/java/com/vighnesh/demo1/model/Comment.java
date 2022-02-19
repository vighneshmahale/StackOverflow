package com.vighnesh.demo1.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;


@Getter
public class Comment {
    private String id;
    private String userId;
    private String questionId;
    private String commentString;

    List<Vote> commentVotes;
    List<Comment> childComments;


    public Comment(String userId, String questionId, String commentString) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.questionId = questionId;
        this.commentString = commentString;
    }
}

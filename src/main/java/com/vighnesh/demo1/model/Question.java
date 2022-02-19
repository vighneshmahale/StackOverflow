package com.vighnesh.demo1.model;


import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Getter
public class Question {
    private String id;
    private String title;
    private String description;
    private String authorId;
    private Integer upVoteCount = 0;
    private Integer downVoteCount = 0;

    private HashMap<String, Vote> votes;
    private List<Comment> comments;


    public Question(String authorId, String description) {
        id = UUID.randomUUID().toString();
        this.authorId = authorId;
        this.description = description;
        votes = new HashMap<>();
        comments = new ArrayList<>();
    }

    public void  vote(String userId, VoteType voteType) {
        Vote vote;

        if(votes.get(userId) == null) {
            vote = new Vote(userId, voteType);
            updateVoteCount(null, voteType);
        } else {
            vote = votes.get(userId);
            updateVoteCount(vote.getVoteType(), voteType);
            vote.setVoteType(voteType);
        }

        votes.put(userId, vote);
    }

    private void updateVoteCount(VoteType previousVoteType, VoteType currentVoteType) {
        if(previousVoteType == null) {
            if(currentVoteType.equals(VoteType.UP)) upVoteCount++;
            else downVoteCount++;
        } else {
            if(previousVoteType.equals(currentVoteType)) return;
            if(previousVoteType.equals(VoteType.UP)) {
                upVoteCount--;
                downVoteCount++;
            } else {
                downVoteCount--;
                upVoteCount++;
            }
        }
    }

    public void addComment(String userId, String comment) {
        Comment userComment = new Comment(userId, id, comment);
        comments.add(userComment);
    }

    public void print() {
        System.out.println("Question Id = " + id + " posted by " + authorId +  "  Details = " + description + " Upvotes " +
                upVoteCount + " Downvote "+ downVoteCount + " comments size " + comments.size());
    }
}

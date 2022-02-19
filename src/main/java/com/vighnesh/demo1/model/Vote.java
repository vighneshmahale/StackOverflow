package com.vighnesh.demo1.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Vote {
    String userId;
    VoteType voteType;

    public Vote(String userId, VoteType voteType) {
        this.userId = userId;
        this.voteType = voteType;
    }

    public static VoteType getVoteTypeFromString(String voteType) {
        if(voteType.equalsIgnoreCase("upvote")) return VoteType.UP;
        else return VoteType.DOWN;
    }
}

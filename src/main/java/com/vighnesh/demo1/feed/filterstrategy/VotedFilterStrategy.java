package com.vighnesh.demo1.feed.filterstrategy;

import com.vighnesh.demo1.model.Question;

import java.util.ArrayList;
import java.util.List;

public class VotedFilterStrategy extends AbstractFilterStrategy{
    @Override
    public List<Question> filter(List<Question> question, String userId) {
        List<Question> answers = new ArrayList<>();

        for(Question q: question) {
            if(q.getVotes().get(userId) == null) continue;
            answers.add(q);
        }
        return answers;
    }
}

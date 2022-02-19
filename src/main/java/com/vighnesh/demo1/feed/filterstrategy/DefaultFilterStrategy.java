package com.vighnesh.demo1.feed.filterstrategy;

import com.vighnesh.demo1.model.Question;

import java.util.List;

public class DefaultFilterStrategy extends AbstractFilterStrategy {
    @Override
    public List<Question> filter(List<Question> question, String userId) {
        return question;
    }
}

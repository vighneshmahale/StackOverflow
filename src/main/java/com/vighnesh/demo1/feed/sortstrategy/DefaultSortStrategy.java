package com.vighnesh.demo1.feed.sortstrategy;

import com.vighnesh.demo1.model.Question;

import java.util.List;

public class DefaultSortStrategy extends AbstractSortStrategy {
    @Override
    public List<Question> sort(List<Question> questions) {
        return questions;
    }
}

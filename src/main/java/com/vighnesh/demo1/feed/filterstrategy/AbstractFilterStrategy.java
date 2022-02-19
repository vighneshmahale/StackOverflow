package com.vighnesh.demo1.feed.filterstrategy;

import com.vighnesh.demo1.model.Question;

import java.util.List;

public abstract class AbstractFilterStrategy {

    public abstract List<Question> filter(List<Question> question, String userId);
}

package com.vighnesh.demo1.feed.sortstrategy;

import com.vighnesh.demo1.model.Question;

import java.util.List;

public abstract class AbstractSortStrategy {

    public abstract List<Question> sort(List<Question> questions);


}

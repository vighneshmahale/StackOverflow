package com.vighnesh.demo1.feed.filterstrategy;

import com.vighnesh.demo1.model.Question;

import java.util.ArrayList;
import java.util.List;

public class PosterFilterStrategy extends AbstractFilterStrategy {


    @Override
    public List<Question> filter(List<Question> questions, String userId) {

        List<Question> filteredList = new ArrayList<>();
        for(Question q : questions) {
            if(q.getAuthorId().equalsIgnoreCase(userId)) {
                filteredList.add(q);
            }
        }
        return filteredList;
    }
}

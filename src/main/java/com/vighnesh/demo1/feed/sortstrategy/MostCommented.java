package com.vighnesh.demo1.feed.sortstrategy;

import com.vighnesh.demo1.model.Question;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MostCommented extends AbstractSortStrategy {

    @Override
    public List<Question> sort(List<Question> questions) {
        Collections.sort(questions, new CommentComparator(questions));
        return questions;
    }


    class CommentComparator implements Comparator<Question> {

        private List<Question> sortOrder;

        public CommentComparator(List<Question> questions) {
            sortOrder = questions;
        }

        @Override
        public int compare(Question o1, Question o2) {
            return o2.getComments().size() - o1.getComments().size();
        }
    }
}

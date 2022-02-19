package com.vighnesh.demo1.feed.sortstrategy;

import com.vighnesh.demo1.model.Question;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MostUpVotedStrategy extends AbstractSortStrategy {
    @Override
    public List<Question> sort(List<Question> questions) {
        Collections.sort(questions, new UpVoteComparator(questions));
        return questions;
    }


    class UpVoteComparator implements Comparator<Question> {

        private List<Question> sortOrder;

        public UpVoteComparator(List<Question> questions) {
            sortOrder = questions;
        }

        @Override
        public int compare(Question o1, Question o2) {
            return o2.getUpVoteCount() - o1.getUpVoteCount();
        }
    }
}

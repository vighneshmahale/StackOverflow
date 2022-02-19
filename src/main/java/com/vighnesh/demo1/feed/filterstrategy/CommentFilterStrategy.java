package com.vighnesh.demo1.feed.filterstrategy;

import com.vighnesh.demo1.model.Comment;
import com.vighnesh.demo1.model.Question;

import java.util.ArrayList;
import java.util.List;

public class CommentFilterStrategy extends AbstractFilterStrategy {
    @Override
    public List<Question> filter(List<Question> question, String userId) {
        List<Question> answer = new ArrayList<>();

        for (Question q: question) {
            List<Comment> comments =  q.getComments();

            for(Comment c: comments) {
                if(c.getUserId().equalsIgnoreCase(userId)) {
                    answer.add(q);
                    break;
                }
            }
        }

        return answer;
    }
}

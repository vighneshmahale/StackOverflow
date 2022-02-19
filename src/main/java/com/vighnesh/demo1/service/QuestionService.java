package com.vighnesh.demo1.service;

import com.vighnesh.demo1.feed.filterstrategy.AbstractFilterStrategy;
import com.vighnesh.demo1.feed.filterstrategy.FilterStrategyProvider;
import com.vighnesh.demo1.feed.sortstrategy.AbstractSortStrategy;
import com.vighnesh.demo1.feed.sortstrategy.SortStrategyProvider;
import com.vighnesh.demo1.model.Question;
import com.vighnesh.demo1.model.Vote;

import java.util.ArrayList;
import java.util.List;

public class QuestionService {

    private List<Question> questions;

    public QuestionService() {
        questions = new ArrayList<>();
    }

    public Question createQuestion(String userId, String questionString) {
        Question question = new Question(userId, questionString);
        questions.add(question);
        System.out.println("New question created with Id = " + question.getId());
        return question;
    }

    public void vote(String voteString, String userId, String questionId) {
        Question q = findQuestion(questionId);

        if(q == null) {
            System.out.println("No such question found");
        }

        q.vote(userId, Vote.getVoteTypeFromString(voteString));
    }

    public void comment(String userId, String questionId, String commentString) {
        Question q = findQuestion(questionId);
        // scope of exception handling
        if(q == null) {
            System.out.println("No such question found");
        }
        q.addComment(userId, commentString);
    }


    // returning void but printing conetests as per problem statement
    public void getFeed(String userId, String sortCriteria, String filterCriteria) {

        System.out.println(" ------------------------ ");
        System.out.println("Generate Feed for user "+ userId);

        /*for(Question q: questions){
            q.print();
        }*/

        AbstractFilterStrategy filter =  FilterStrategyProvider.getStrategy(filterCriteria);

        List<Question> filteredList = filter.filter(questions, userId);

        AbstractSortStrategy sortStrategy = SortStrategyProvider.getSortStrategy(sortCriteria);

        List<Question> sortedList = sortStrategy.sort(filteredList);

        for(Question q: sortedList) {
            q.print();
        }

        System.out.println(" ------------------------ ");

    }

    private Question findQuestion(String questionId) {
        for(Question q: questions) {
            if(q.getId().equalsIgnoreCase(questionId)) return q;
        }
        return null;
    }

}

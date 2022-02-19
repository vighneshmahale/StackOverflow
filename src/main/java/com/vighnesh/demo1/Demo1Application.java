package com.vighnesh.demo1;

import com.vighnesh.demo1.io.ConsoleIO;
import com.vighnesh.demo1.model.Question;
import com.vighnesh.demo1.service.QuestionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


public class Demo1Application {

    public static void main(String[] args) {
        //SpringApplication.run(Demo1Application.class, args);

        QuestionService service = new QuestionService();
        ConsoleIO consoleIO = new ConsoleIO();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to stack overflow");

        while(true) {
            String[] input = consoleIO.scanLineToken();

            if(input[0].equalsIgnoreCase("post")) {
                service.createQuestion(input[1], input[2]);
            }

            if(input[0].equalsIgnoreCase("upvote") || input[0].equalsIgnoreCase("downvote")) {
                service.vote(input[0], input[1], input[2]);
            }

            if(input[0].equalsIgnoreCase("comment")) {
                service.comment(input[1], input[2], input[3]);
            }

            if(input[0].equalsIgnoreCase("view")) {
                service.getFeed(input[1], input[2], input[3]);
            }

        }

    }

}

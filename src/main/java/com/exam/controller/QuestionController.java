package com.exam.controller;

import com.exam.models.exam.Question;
import com.exam.models.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {


    @Autowired
    private QuestionService service;

    @Autowired
    private QuizService quizService;

    //add question
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question) {
        return ResponseEntity.ok(this.service.addQuestion(question));
    }

    //update the question
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question) {
        return ResponseEntity.ok(this.service.updateQuestion(question));
    }

    //get all question pf any quiz
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid) {


        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        List lisgt = new ArrayList(questions);
        if (lisgt.size() > Integer.parseInt(quiz.getNumOfQuestion())) {
            lisgt = lisgt.subList(0, Integer.parseInt(quiz.getNumOfQuestion() + 1));

        }
        Collections.shuffle(lisgt);
        return ResponseEntity.ok(lisgt);
    }

    //get all questions
    //get all question pf any quiz
    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionOfQuizAdmin(@PathVariable("qid") Long qid) {
            Quiz quiz = new Quiz();
            quiz.setqID(qid);
            Set<Question> questionsOfQuiz = this.service.getQuestionOfQuiz(quiz);
            return  ResponseEntity.ok(questionsOfQuiz);
      //  return ResponseEntity.ok(lisgt);
    }

    // get Single Question
    @GetMapping("/{quesID}")
    public Question get(@PathVariable("quesID") Long quesId) {
        return this.service.getQuestion(quesId);
    }

    //delete question
    @DeleteMapping("/{quesID}")
    public void delete(@PathVariable("quesID") Long quesID){
        this.service.deleteQuestion(quesID);
    }


}

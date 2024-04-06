package com.tushar.quizservice.service;

import com.tushar.quizservice.model.Question;
import com.tushar.quizservice.model.Quiz;
import com.tushar.quizservice.repo.QuizRepo;
import com.tushar.quizservice.restclients.QuestionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionClient questionClient;


    public ResponseEntity<List<Question>> getAllQuestionsForQuiz() {
        // call the question-service method (getAllQuestions)
        List<Question> list =  questionClient.getAllQuestion().getBody();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getQuizQuestionsByCategory(String category) {
        // call the question-service method (getQuestionByCategory)
        List<Question> list = questionClient.getQuestionByCategory(category).getBody();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<Question> getQuizQuestionsById(Integer id) {
        // call the question-service method (getQuestionById)
        Question list = questionClient.getQuestionById(id).getBody();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<List<Quiz>> getAllCategories() {
        List<Quiz> list = quizRepo.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<String> addNewCategory(Quiz quiz) {
        if (quiz == null){
            return new ResponseEntity<>("Request body is empty", HttpStatus.BAD_REQUEST);
        } else {
            quizRepo.save(quiz);
        }
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}

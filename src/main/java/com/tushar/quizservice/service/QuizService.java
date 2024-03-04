package com.tushar.quizservice.service;

import com.tushar.quizservice.model.Question;
import com.tushar.quizservice.model.Quiz;
import com.tushar.quizservice.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;


    /*public ResponseEntity<List<Question>> getAllQuestionsForQuiz() {
        // call the question-service method (getAllQuestions)
    }

    public ResponseEntity<List<Question>> getQuizQuestionsByCategory(String category) {
        // call the question-service method (getQuestionByCategory)
    }

    public ResponseEntity<List<Question>> getQuizQuestionsById(Integer id) {
        // call the question-service method (getQuestionById)
    }
*/
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

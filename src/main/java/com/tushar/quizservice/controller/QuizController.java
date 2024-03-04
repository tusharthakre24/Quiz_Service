package com.tushar.quizservice.controller;

import com.tushar.quizservice.model.Question;
import com.tushar.quizservice.model.Quiz;
import com.tushar.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    /*@GetMapping("getAllQuestionsForQuiz")
    public ResponseEntity<List<Question>> getAllQuestionsForQuiz(){
        return quizService.getAllQuestionsForQuiz();
    }

    @GetMapping("getQuizQuestionsByCategory/{category}")
    public ResponseEntity<List<Question>> getQuizQuestionsByCategory(@PathVariable String category){
        return quizService.getQuizQuestionsByCategory(category);
    }

    @GetMapping("getQuizQuestionsById/{id}")
    public ResponseEntity<List<Question>> getQuizQuestionsById(@PathVariable Integer id){
        return quizService.getQuizQuestionsById(id);
    }
*/
    @GetMapping("getAllCategories")
    public ResponseEntity<List<Quiz>> getAllCategories(){
        return quizService.getAllCategories();
    }

    @PostMapping("addNewCategory")
    public ResponseEntity<String> addNewCategory(@RequestBody Quiz quiz){
        return quizService.addNewCategory(quiz);
    }
}

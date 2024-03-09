package com.tushar.quizservice.restclients;

import com.tushar.quizservice.model.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(name = "question-service", url = "localhost:8082/questions")
public interface QuestionClient {

    @GetMapping("/getAllQuestions")
    ResponseEntity<List<Question>> getAllQuestion();
}


package com.example.usinadrosinadback.business.user.feedback;

import com.example.usinadrosinadback.domain.feedback.FeedbackContactViewDto;
import com.example.usinadrosinadback.domain.feedback.FeedbackDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedbacksController {

    @Resource
    private FeedbacksService feedbacksService;

    @GetMapping("/feedback")
    @Operation(summary = "Tagastab kõik kasutajale antud tagasisided receiver userId järgi")
    public List<FeedbackDto> findUserFeedbacks(@RequestParam Integer userId) {
        List<FeedbackDto> userFeedbacks = feedbacksService.findUserFeedbacks(userId);
        return userFeedbacks;
    }

    @PostMapping("/feedback")
    @Operation(summary="Kasutajale uue tagasiside lisamine. Tagastab tagasiside ID.")
    public Integer addFeedback(@RequestBody FeedbackContactViewDto request) {
        return feedbacksService.addFeedback(request);
    }
 }

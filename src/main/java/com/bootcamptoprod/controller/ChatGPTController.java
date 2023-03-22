package com.bootcamptoprod.controller;

import com.bootcamptoprod.model.request.ChatBotInputRequest;
import com.bootcamptoprod.model.response.ChatGPTResponse;
import com.bootcamptoprod.service.ChatGPTService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatGPTController {

    private ChatGPTService chatGPTService;

    public ChatGPTController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }

    @PostMapping("/chat")
    public ResponseEntity<ChatGPTResponse> processInputRequest(@RequestBody ChatBotInputRequest chatbotInputRequest) {
        ChatGPTResponse chatCPTResponse = chatGPTService.getChatCPTResponse(chatbotInputRequest.getMessage());
        return new ResponseEntity<>(chatCPTResponse, HttpStatus.OK);
    }
}

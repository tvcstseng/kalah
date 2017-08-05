package com.ttstudios.kalah.web;

import com.ttstudios.kalah.persistence.model.Message;
import com.ttstudios.kalah.persistence.model.OutputMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/")
public class ChatController {

    @RequestMapping(method = RequestMethod.GET)
    public String viewApplication() {
        return "home";
    }

    @MessageMapping("/chat/")
    @SendTo("/topic/message")
    public OutputMessage sendMessage(Message message) {
        return new OutputMessage(message, new Date());
    }

    @RequestMapping("/socket.io")
    public ResponseEntity<String> handle() {
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<String>("I'm Alive", responseHeaders, HttpStatus.OK);
    }
}

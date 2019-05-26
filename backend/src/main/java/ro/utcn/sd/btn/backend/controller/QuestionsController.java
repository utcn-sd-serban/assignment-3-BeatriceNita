package ro.utcn.sd.btn.backend.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.sd.btn.backend.dto.QuestionDTO;
//import ro.utcn.sd.btn.assig1.event.BaseEvent;
import ro.utcn.sd.btn.backend.event.BaseEvent;
import ro.utcn.sd.btn.backend.service.QuestionService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QuestionsController {
    private final QuestionService questionService;
    private final SimpMessagingTemplate messagingTemplate;

    @GetMapping("/questions")
    public List<QuestionDTO> readAll() {

        return questionService.listAll();
        //throw new NullPointerException();
    }

    @PostMapping("/questions")
    public QuestionDTO create(@RequestBody QuestionDTO dto) {
        return questionService.insert(dto);
    }

    @EventListener(BaseEvent.class)
    public void handleQuestionCreated(BaseEvent event){
        log.info("Got an event: {}.", event);
        messagingTemplate.convertAndSend("/topic/events",event);
    }

}

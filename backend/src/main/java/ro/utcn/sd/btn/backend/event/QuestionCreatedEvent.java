package ro.utcn.sd.btn.backend.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ro.utcn.sd.btn.backend.dto.QuestionDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionCreatedEvent extends BaseEvent {

    private final QuestionDTO question;

    public QuestionCreatedEvent(QuestionDTO question){
        super(EventType.QUESTION_CREATED);
        this.question = question;
    }
}

package ro.utcn.sd.btn.backend.command;

import ro.utcn.sd.btn.backend.dto.QuestionDTO;

public interface Command {

    QuestionDTO execute(QuestionDTO questionDTO);
}

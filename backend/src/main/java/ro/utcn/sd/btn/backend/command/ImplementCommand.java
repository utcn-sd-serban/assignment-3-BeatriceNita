package ro.utcn.sd.btn.backend.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.utcn.sd.btn.backend.persistence.api.QuestionRepository;
import ro.utcn.sd.btn.backend.persistence.api.RepositoryFactory;

@Component
@RequiredArgsConstructor
public class ImplementCommand implements CommandFactory{

    private final RepositoryFactory repositoryFactory;

    @Override
    public Command askCommand(){
        QuestionRepository questionRepo =  repositoryFactory.createQuestionRepository();
        return new AskCommand(questionRepo);
    }
}

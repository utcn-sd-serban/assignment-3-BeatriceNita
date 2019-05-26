package ro.utcn.sd.btn.backend.command;

import lombok.RequiredArgsConstructor;
import ro.utcn.sd.btn.backend.dto.QuestionDTO;
import ro.utcn.sd.btn.backend.model.Question;
import ro.utcn.sd.btn.backend.persistence.api.QuestionRepository;
import ro.utcn.sd.btn.backend.persistence.api.RepositoryFactory;

@RequiredArgsConstructor
public class AskCommand implements Command{

    private RepositoryFactory repositoryFactory;
    private QuestionRepository questionRepo;

    public AskCommand(QuestionRepository questionRepo){
        this.questionRepo = questionRepo;
    }

    @Override
    public QuestionDTO execute(QuestionDTO questionDTO){
        Question question = new Question();
        question.setAuthor(repositoryFactory.createUserRepository().findByName(questionDTO.getAuthor()));
        question.setTitle(questionDTO.getTitle());
        question.setTag(questionDTO.getTag());
        question.setTag(repositoryFactory.createTagRepository().save(question.getTag()));
        //question.setTag(repositoryFactory.createTagRepository().findByName(questionDTO.getTag()));
        question.setText(questionDTO.getText());
        question.setCreationDate(questionDTO.getCreationDate());
        QuestionDTO output = QuestionDTO.ofEntity(repositoryFactory.createQuestionRepository().save(question));
        return output;
    }

}

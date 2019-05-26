package ro.utcn.sd.btn.backend.service;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.btn.backend.command.AskCommand;
import ro.utcn.sd.btn.backend.command.Command;
import ro.utcn.sd.btn.backend.command.CommandFactory;
import ro.utcn.sd.btn.backend.dto.QuestionDTO;
import ro.utcn.sd.btn.backend.event.QuestionCreatedEvent;
import ro.utcn.sd.btn.backend.exception.QuestionNotFoundException;
import ro.utcn.sd.btn.backend.model.Question;
import ro.utcn.sd.btn.backend.persistence.api.QuestionRepository;
import ro.utcn.sd.btn.backend.persistence.api.RepositoryFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final RepositoryFactory repositoryFactory;
    private final CommandFactory command;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public List<QuestionDTO> listAll() {
        return repositoryFactory.createQuestionRepository().findAll().stream()
                .map(this::updateUserOfQuestion)
                .map(QuestionDTO::ofEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public Question updateUserOfQuestion(Question question){
        question.setAuthor(repositoryFactory.createUserRepository().findById(question.getAuthor().getId()).get());
        return question;
    }

    @Transactional
    public QuestionDTO create(QuestionDTO dto) {
        Question question = new Question();
        question.setId(dto.getId());
        question.setAuthor(repositoryFactory.createUserRepository().findByName(dto.getAuthor()));
        question.setTitle(dto.getTitle());
        question.setTag(dto.getTag());
        question.setTag(repositoryFactory.createTagRepository().save(question.getTag()));
        //question.setTag(repositoryFactory.createTagRepository().findByName(dto.getTag()));
        question.setText(dto.getText());
        question.setCreationDate(dto.getCreationDate());
        QuestionDTO output = QuestionDTO.ofEntity(repositoryFactory.createQuestionRepository().save(question));
        eventPublisher.publishEvent(new QuestionCreatedEvent(output));
        return output;
    }

    @Transactional
    public QuestionDTO insert(QuestionDTO dto) {
        QuestionDTO output = command.askCommand().execute(dto);
        eventPublisher.publishEvent(new QuestionCreatedEvent(output));
        return output;
    }

    @Transactional
    public Question findById(int id) {
        return repositoryFactory.createQuestionRepository().findById(id).orElseThrow(QuestionNotFoundException::new);
    }

    @Transactional
    public List<Question> listQuestionByTitle(String title) {
        return repositoryFactory.createQuestionRepository().findByTitle(title);
    }

    @Transactional
    public List<Question> listQuestionByDate() {
        return repositoryFactory.createQuestionRepository().listByDate();
    }

    @Transactional
    public void removeQuestion(int id) {
        QuestionRepository repository = repositoryFactory.createQuestionRepository();
        Question question = repository.findById(id).orElseThrow(QuestionNotFoundException::new);
        repository.remove(question);

    }


}
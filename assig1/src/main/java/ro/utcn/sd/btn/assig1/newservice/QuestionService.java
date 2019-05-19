package ro.utcn.sd.btn.assig1.newservice;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.btn.assig1.dto.QuestionDTO;
import ro.utcn.sd.btn.assig1.model.Question;
import ro.utcn.sd.btn.assig1.persistence.api.QuestionRepository;
import ro.utcn.sd.btn.assig1.persistence.api.RepositoryFactory;
//import ro.utcn.sd.btn.assig1.event.QuestionCreatedEvent;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final RepositoryFactory repositoryFactory;
    //private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public List<QuestionDTO> listAll() {
        return repositoryFactory.createQuestionRepository().findAll().stream()
                .map(QuestionDTO::ofEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public QuestionDTO create(QuestionDTO dto) {
        Question question = new Question();
        question.setId(dto.getId());
        question.setAuthor(dto.getAuthor());
        question.setTitle(dto.getTitle());
        question.setTag(dto.getTag());
        question.setText(dto.getText());
        question.setCreationDate(dto.getCreationDate());
        QuestionDTO output = QuestionDTO.ofEntity(repositoryFactory.createQuestionRepository().save(question));
        //eventPublisher.publishEvent(new QuestionCreatedEvent(output));
        return output;
    }

}
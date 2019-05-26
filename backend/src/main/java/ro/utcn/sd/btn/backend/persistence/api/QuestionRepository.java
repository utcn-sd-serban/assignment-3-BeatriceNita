package ro.utcn.sd.btn.backend.persistence.api;

import ro.utcn.sd.btn.backend.model.Question;
import ro.utcn.sd.btn.backend.model.Tag;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository {

    Question save(Question q);

    Optional<Question> findById(int id);

    List<Question> findByTag(Tag tag);

    List<Question> findByTitle(String title);

    void remove(Question question);

    List<Question> findAll();

    List<Question> listByDate();
}

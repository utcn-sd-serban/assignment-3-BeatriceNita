package ro.utcn.sd.btn.backend.persistence.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ro.utcn.sd.btn.backend.model.Question;
import ro.utcn.sd.btn.backend.model.Tag;
import ro.utcn.sd.btn.backend.model.User;
import ro.utcn.sd.btn.backend.persistence.api.QuestionRepository;

import java.util.*;

@RequiredArgsConstructor
public class JdbcQuestionRepository implements QuestionRepository {

    private final JdbcTemplate template;

    @Override
    public Question save(Question question) {
        if (question.getId() == null) {
            question.setId(insert(question));
            insertTag(question);
        } else {
            update(question);
        }
        return question;
    }

    @Override
    public void remove(Question question) {
        template.update("DELETE FROM question WHERE id = ?", question.getId());
    }

    private int insert(Question question){
        SimpleJdbcInsert ins = new SimpleJdbcInsert(template);
        ins.setTableName("question");
        ins.setGeneratedKeyName("id");

        Map<String, Object> data = new HashMap<>();
        data.put("author_id", question.getAuthor().getId());
        data.put("title", question.getTitle());
        data.put("text", question.getText());
        data.put("create_date", question.getCreationDate());
        return ins.executeAndReturnKey(data).intValue();
    }

    private void update(Question question){
        template.update("UPDATE question SET  title = ? , text = ? WHERE id = ?",
                question.getTitle(), question.getText(), question.getId());
    }

    @Override
    public List<Question> findAll() {
        return template.query("SELECT * FROM question  JOIN tag_question ON question.id=tag_question.id_q JOIN tag ON tag.id=tag_question.id_t", (resultSet, i) ->
                new Question(resultSet.getInt("question.id"), new User(resultSet.getInt("author_id")), resultSet.getString("title"), resultSet.getString("text"),
                        new Tag(resultSet.getString("tag_name")),resultSet.getTimestamp("create_date")));
    }

    @Override
    public List<Question> listByDate() {
        return template.query("SELECT * FROM question ORDER BY create_date DESC", new QuestionMapper());
    }

    @Override
    public Optional<Question> findById(int id) {
        List<Question> questions = template.query("SELECT * FROM question WHERE id = ?", new QuestionMapper(), id);
        return questions.isEmpty() ? Optional.empty() : Optional.of(questions.get(0));
    }

    @Override
    public List<Question> findByTag(Tag tag){
        List<Question> questions = template.query("SELECT * FROM question WHERE tag = ?", new QuestionMapper(), tag.getId());
        return questions.isEmpty() ? null : questions;
    }

    @Override
    public List<Question> findByTitle(String title){
        List<Question> questions = template.query("SELECT * FROM question WHERE title = ?", new QuestionMapper(), title);
        return questions.isEmpty() ? null : questions;
    }

    private void insertTag(Question question) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
        insert.setTableName("tag_question");
        Map<String, Object> map = new HashMap<>();
        map.put("id_q", question.getId());
        map.put("id_t",question.getTag().getId());
        insert.execute(map);
    }
}

package ro.utcn.sd.btn.backend.persistence.jdbc;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import ro.utcn.sd.btn.backend.model.Question;
import ro.utcn.sd.btn.backend.model.User;
import ro.utcn.sd.btn.backend.persistence.api.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@ConditionalOnProperty(name = "backend.repository-type", havingValue = "JDBC")
public class JdbcUserRepository implements UserRepository {

    private final JdbcTemplate template;

    public JdbcUserRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<User> findAll() {
        return template.query("SELECT * FROM appuser", new UserMapper());
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(insert(user));
        } else {
            update(user);
        }
        return user;
    }

    @Override
    public void remove(User user) {
        template.update("DELETE FROM appuser WHERE id = ?", user.getId());
    }

    @Override
    public Optional<User> findById(int id) {
        List<User> users = template.query("SELECT * FROM appuser WHERE id = ?", new UserMapper(), id);
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }

    @Override
    public User findByName(String userName) {
        List<User> users = template.query("SELECT * FROM appuser WHERE username = ? ", new UserMapper(), userName);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public Optional<User> findUserInfo(String userName, String password) {
        List<User> users = template.query("SELECT * FROM appuser WHERE username = ? AND password = ?", new UserMapper(), userName, password);
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }

    private int insert(User user){
        SimpleJdbcInsert ins = new SimpleJdbcInsert(template);
        ins.setTableName("appuser");
        ins.setGeneratedKeyName("id");

        Map<String, Object> data = new HashMap<>();
        data.put("username", user.getUserName());
        data.put("password", user.getPassword());

        return ins.executeAndReturnKey(data).intValue();
    }

    private void update(User user){
        template.update("UPDATE appuser SET username = ? , password = ? WHERE id = ?",
                user.getUserName(), user.getPassword(), user.getId());
    }

}


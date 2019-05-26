package ro.utcn.sd.btn.backend.persistence.api;

import ro.utcn.sd.btn.backend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    User save(User user);

    void remove(User user);

    Optional<User> findById(int id);

    User findByName(String userName);

    Optional<User> findUserInfo(String userName, String password);

}

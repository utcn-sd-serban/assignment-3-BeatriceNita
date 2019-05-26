package ro.utcn.sd.btn.backend.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.btn.backend.model.Question;
import ro.utcn.sd.btn.backend.model.User;
import ro.utcn.sd.btn.backend.persistence.api.QuestionRepository;
import ro.utcn.sd.btn.backend.persistence.api.RepositoryFactory;
import ro.utcn.sd.btn.backend.persistence.api.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationSeed implements CommandLineRunner {
    private final RepositoryFactory repositoryFactory;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception{
        UserRepository userRepo= repositoryFactory.createUserRepository();
        User user = new User(1,"otto", passwordEncoder.encode("food"));
        userRepo.save(user);

        System.out.println(user.getPassword());
    }

    @Transactional
    public void clear() {

    }
}
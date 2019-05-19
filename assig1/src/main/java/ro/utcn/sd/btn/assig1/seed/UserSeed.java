package ro.utcn.sd.btn.assig1.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.btn.assig1.model.Question;
import ro.utcn.sd.btn.assig1.model.User;
import ro.utcn.sd.btn.assig1.persistence.api.QuestionRepository;
import ro.utcn.sd.btn.assig1.persistence.api.RepositoryFactory;
import ro.utcn.sd.btn.assig1.persistence.api.UserRepository;

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
public class UserSeed implements CommandLineRunner {
    private final RepositoryFactory repositoryFactory;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception{
        UserRepository userRepo= repositoryFactory.createUserRepository();
        User user = new User(0,"otto", passwordEncoder.encode("food"));
        userRepo.save(user);

        System.out.println(user.getPassword());
        /*Student john = new Student(0, "John", "Doe", new LinkedList<>());
        studentRepository.save(john);
        Student jack = new Student(0, "Jack", "Black", new LinkedList<>());
        studentRepository.save(jack);
        Student jane = new Student(0, "Jane", "White", new LinkedList<>());
        studentRepository.save(jane);

        List<Grade> grades = Arrays.asList(
                new Grade(0, 5, LocalDate.now(), serban),
                new Grade(0, 6, LocalDate.now(), serban),
                new Grade(0, 7, LocalDate.now(), serban)
        );
        gradeRepository.saveAll(grades);

        john.setGrades(grades);*/
    }

    /*@Transactional
    public void clear() {
        userRepository.deleteAll();
    }*/
}
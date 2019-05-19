package ro.utcn.sd.btn.assig1.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.btn.assig1.model.Tag;
import ro.utcn.sd.btn.assig1.model.User;
import ro.utcn.sd.btn.assig1.persistence.api.RepositoryFactory;
import ro.utcn.sd.btn.assig1.persistence.api.TagRepository;
import ro.utcn.sd.btn.assig1.persistence.api.UserRepository;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TagSeed implements CommandLineRunner {
    private final RepositoryFactory factory;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        TagRepository repository = factory.createTagRepository();
        if (repository.findAll().isEmpty()) {
            repository.save(new Tag("java"));
            repository.save(new Tag("python"));
            repository.save(new Tag("spring"));
        }
    }
}
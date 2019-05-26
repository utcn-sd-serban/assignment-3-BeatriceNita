package ro.utcn.sd.btn.backend.persistence.api;

public interface RepositoryFactory {

    QuestionRepository createQuestionRepository();
    UserRepository createUserRepository();
    TagRepository createTagRepository();
}

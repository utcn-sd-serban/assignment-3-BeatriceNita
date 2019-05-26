package ro.utcn.sd.btn.backend.persistence.api;

import ro.utcn.sd.btn.backend.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagRepository {

    Tag save(Tag t);

    Optional<Tag> findById(int id);

    Tag findByName(String name);

    void remove(Tag tag);

    List<Tag> findAll();
}


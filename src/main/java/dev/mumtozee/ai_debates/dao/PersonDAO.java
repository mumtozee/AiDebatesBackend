package dev.mumtozee.ai_debates.dao;

import dev.mumtozee.ai_debates.model.Person;
import dev.mumtozee.ai_debates.model.Topic;

import java.util.List;
import java.util.Optional;

public interface PersonDAO {
  void create(Person person);

  Optional<Person> get(int id);

  void update(Person person, int id);

  void delete(int id);

  List<Topic> getProposedTopics(int id);
}

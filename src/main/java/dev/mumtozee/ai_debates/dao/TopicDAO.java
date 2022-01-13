package dev.mumtozee.ai_debates.dao;

import dev.mumtozee.ai_debates.model.Argument;
import dev.mumtozee.ai_debates.model.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicDAO {
  List<Topic> list();

  void create(Topic topic);

  Optional<Topic> get(int id);

  void delete(int id);

  List<Argument> getForArguments(int id);

  List<Argument> getAgainstArguments(int id);
}

package dev.mumtozee.ai_debates.dao;

import dev.mumtozee.ai_debates.model.Argument;

public interface ArgumentDAO {
  void create(Argument arg);

  void delete(int id);
}

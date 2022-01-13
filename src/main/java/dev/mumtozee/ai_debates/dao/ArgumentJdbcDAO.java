package dev.mumtozee.ai_debates.dao;

import dev.mumtozee.ai_debates.model.Argument;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@RequiredArgsConstructor
public class ArgumentJdbcDAO implements ArgumentDAO {
  private final JdbcTemplate jdbcTemplate;

  @Override
  public void create(Argument arg) {
    String sql = "insert into ARGUMENT (is_for, author_id, topic_id, text, published_date) " +
            "values (?, ?, ?, ?, ?);";
    jdbcTemplate.update(sql, arg.isFor(), arg.getAuthorId(), arg.getTopicId(),
            arg.getContent(), arg.getPublishedDate());
  }

  @Override
  public void delete(int id) {
    String sql = "delete from ARGUMENT where id = ?";
    jdbcTemplate.update(sql, id);
  }
}

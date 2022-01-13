package dev.mumtozee.ai_debates.dao;

import dev.mumtozee.ai_debates.model.Argument;
import dev.mumtozee.ai_debates.model.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Component
@Service
@RequiredArgsConstructor
public class TopicJdbcDAO implements TopicDAO {
  private final JdbcTemplate jdbcTemplate;

  RowMapper<Topic> rowMapper = (rs, rowNum) -> {
    Topic topic = new Topic();
    topic.setId(rs.getInt("id"));
    topic.setAuthorId(rs.getInt("author_id"));
    topic.setText(rs.getString("text"));
    topic.setPublishedDate(rs.getDate("published_date").toLocalDate());
    return topic;
  };

  @Override
  public List<Topic> list() {
    String sql = "select * from TOPIC;";
    return jdbcTemplate.query(sql, rowMapper);
  }

  @Override
  public void create(Topic topic) {
    String sql = "insert into TOPIC (author_id, text, published_date) values (?, ?, ?);";
    jdbcTemplate.update(sql, topic.getAuthorId(), topic.getText(), topic.getPublishedDate());
  }

  @Override
  public Optional<Topic> get(int id) {
    String sql = "SELECT * FROM TOPIC WHERE id = ?;";
    Topic topic = null;
    try {
      topic = jdbcTemplate.queryForObject(sql, new Object[]{id}, new int[]{Types.INTEGER}, rowMapper);
    } catch (DataAccessException ignored) {
    }

    return Optional.ofNullable(topic);
  }

  @Override
  public void delete(int id) {
    String sql = "delete from ARGUMENT where topic_id = ?;" +
            "delete from TOPIC where id = ?;";
    jdbcTemplate.update(sql, id, id);
  }

  RowMapper<Argument> argRowMapper = (rs, rowNum) -> {
    Argument arg = new Argument();
    arg.setId(rs.getInt("id"));
    arg.setFor(rs.getBoolean("is_for"));
    arg.setAuthorId(rs.getInt("author_id"));
    arg.setTopicId(rs.getInt("topic_id"));
    arg.setContent(rs.getString("text"));
    arg.setPublishedDate(rs.getDate("published_date").toLocalDate());
    return arg;
  };

  @Override
  public List<Argument> getForArguments(int id) {
    String sql = "select * from ARGUMENT where topic_id = ? and is_for = TRUE;";
    return jdbcTemplate.query(sql, new Object[]{id}, new int[]{Types.INTEGER}, argRowMapper);
  }

  @Override
  public List<Argument> getAgainstArguments(int id) {
    String sql = "select * from ARGUMENT where topic_id = ? and is_for = FALSE;";
    return jdbcTemplate.query(sql, new Object[]{id}, new int[]{Types.INTEGER}, argRowMapper);
  }
}

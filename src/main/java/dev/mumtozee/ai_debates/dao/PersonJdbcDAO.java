package dev.mumtozee.ai_debates.dao;

import dev.mumtozee.ai_debates.model.Person;
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
public class PersonJdbcDAO implements PersonDAO {
  private final JdbcTemplate jdbcTemplate;

  RowMapper<Person> rowMapper = (rs, rowNum) -> {
    Person person = new Person();
    person.setId(rs.getInt("id"));
    person.setUsername(rs.getString("username"));
    person.setEmail(rs.getString("email"));
    person.setPassword(rs.getString("password"));
    person.setRegisteredDate(rs.getDate("registered_date").toLocalDate());
    return person;
  };

  @Override
  public void create(Person person) {
    String sql = "insert into PERSON (username, email, password, registered_date) values (?,?,?,?);";
    jdbcTemplate.update(sql, person.getUsername(),
            person.getEmail(), person.getPassword(), person.getRegisteredDate());
  }

  @Override
  public Optional<Person> get(int id) {
    String sql = "SELECT * FROM PERSON WHERE id = ?;";
    Person person = null;
    try {
      person = jdbcTemplate.queryForObject(sql, new Object[]{id}, new int[]{Types.INTEGER}, rowMapper);
    } catch (DataAccessException ignored) {
    }

    return Optional.ofNullable(person);
  }

  @Override
  public void update(Person person, int id) {
    String sql = "update PERSON set username = ?, email = ?, " +
            "password = ?, registered_date = ? where id = ?";
    jdbcTemplate.update(sql, person.getUsername(), person.getEmail(),
            person.getPassword(), person.getRegisteredDate(), id);
  }

  @Override
  public void delete(int id) {
    String sql = "delete from PERSON where id = ?";
    jdbcTemplate.update(sql, id);
  }

  @Override
  public List<Topic> getProposedTopics(int id) {
    String sql = "select * from TOPIC where author_id = ?;";
    return jdbcTemplate.query(sql, new Object[]{id}, new int[]{Types.INTEGER}, (rs, rowNum) -> {
      Topic topic = new Topic();
      topic.setId(rs.getInt("id"));
      topic.setAuthorId(rs.getInt("author_id"));
      topic.setText(rs.getString("text"));
      topic.setPublishedDate(rs.getDate("published_date").toLocalDate());
      return topic;
    });
  }
}

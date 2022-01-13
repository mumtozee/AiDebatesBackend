package dev.mumtozee.ai_debates.controller;

import dev.mumtozee.ai_debates.dao.ArgumentDAO;
import dev.mumtozee.ai_debates.dao.PersonDAO;
import dev.mumtozee.ai_debates.dao.TopicDAO;

import dev.mumtozee.ai_debates.model.Argument;
import dev.mumtozee.ai_debates.model.Person;
import dev.mumtozee.ai_debates.model.Topic;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3002"})
@RestController
public class DebatesController {
  private final PersonDAO personDAO;
  private final ArgumentDAO argumentDAO;
  private final TopicDAO topicDAO;

  public DebatesController(PersonDAO personDAO, ArgumentDAO argumentDAO, TopicDAO topicDAO) {
    this.personDAO = personDAO;
    this.argumentDAO = argumentDAO;
    this.topicDAO = topicDAO;
  }

  @GetMapping("/all_topics")
  public List<Topic> getAllTopics() {
    return topicDAO.list();
  }

  @PostMapping("/add_topic")
  public ResponseEntity<Void> createTopic(@RequestBody Topic topic) {
    topicDAO.create(topic);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @DeleteMapping("/delete_topic/{id}")
  public ResponseEntity<Void> deleteTopic(@PathVariable int id) {
    topicDAO.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<Person> getPerson(@PathVariable int id) {
    Optional<Person> author = personDAO.get(id);
    return author.map(person -> new ResponseEntity<>(person, HttpStatus.OK)).
            orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/topics/{id}")
  public ResponseEntity<Topic> getTopic(@PathVariable int id) {
    Optional<Topic> topic = topicDAO.get(id);
    return topic.map(subject -> new ResponseEntity<>(subject, HttpStatus.OK)).
            orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/for_args/{id}")
  public List<Argument> getForArguments(@PathVariable int id) {
    return topicDAO.getForArguments(id);
  }

  @GetMapping("/against_args/{id}")
  public List<Argument> getAgainstArguments(@PathVariable int id) {
    return topicDAO.getAgainstArguments(id);
  }

  @PostMapping("/add_argument")
  public ResponseEntity<Void> createArgument(@RequestBody Argument argument) {
    argumentDAO.create(argument);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/user_topics/{user_id}")
  public List<Topic> getUserTopics(@PathVariable int user_id) {
    return personDAO.getProposedTopics(user_id);
  }
}

package dev.mumtozee.ai_debates;

import dev.mumtozee.ai_debates.dao.ArgumentDAO;
import dev.mumtozee.ai_debates.dao.PersonDAO;
import dev.mumtozee.ai_debates.dao.TopicDAO;
import dev.mumtozee.ai_debates.model.Person;
import dev.mumtozee.ai_debates.model.Topic;
import dev.mumtozee.ai_debates.model.Argument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AiDebatesApplication {

  private static PersonDAO personDAO;
  private static TopicDAO topicDAO;
  private static ArgumentDAO argumentDAO;

  public AiDebatesApplication(PersonDAO p, TopicDAO t, ArgumentDAO a) {
    personDAO = p;
    topicDAO = t;
    argumentDAO = a;
  }

  public static void main(String[] args) {
    SpringApplication.run(AiDebatesApplication.class, args);

//    System.out.println("~~~~~~~Arguments~~~~~~~~~~~");
//    List<Argument> forArgs = topicDAO.getForArguments(1);
//    forArgs.forEach(System.out::println);
  }

}

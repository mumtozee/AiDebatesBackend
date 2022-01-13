package dev.mumtozee.ai_debates.model;

import java.time.LocalDate;

public class Argument {
  private int id;
  private boolean isFor;
  private int authorId;
  private int topicId;
  private String content;
  private LocalDate publishedDate;

  public Argument() {
  }

  public Argument(boolean isFor, int authorId, int topicId, String content, LocalDate publishedDate) {
    this.isFor = isFor;
    this.authorId = authorId;
    this.topicId = topicId;
    this.content = content;
    this.publishedDate = publishedDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isFor() {
    return isFor;
  }

  public void setFor(boolean aFor) {
    isFor = aFor;
  }

  public int getAuthorId() {
    return authorId;
  }

  public void setAuthorId(int authorId) {
    this.authorId = authorId;
  }

  public int getTopicId() {
    return topicId;
  }

  public void setTopicId(int topicId) {
    this.topicId = topicId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public LocalDate getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(LocalDate publishedDate) {
    this.publishedDate = publishedDate;
  }

  @Override
  public String toString() {
    return "Argument{" +
            "id=" + id +
            ", isFor=" + isFor +
            ", authorId=" + authorId +
            ", topicId=" + topicId +
            ", content='" + content + '\'' +
            ", publishedDate=" + publishedDate +
            '}';
  }
}

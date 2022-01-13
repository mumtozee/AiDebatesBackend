package dev.mumtozee.ai_debates.model;

import java.time.LocalDate;

public class Topic {
  private int id;
  private int authorId;
  private String title;
  private LocalDate publishedDate;

  public Topic() {
  }

  public Topic(int authorId, String text, LocalDate publishedDate) {
    this.authorId = authorId;
    this.title = text;
    this.publishedDate = publishedDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAuthorId() {
    return authorId;
  }

  public void setAuthorId(int authorId) {
    this.authorId = authorId;
  }

  public String getText() {
    return title;
  }

  public void setText(String text) {
    this.title = text;
  }

  public LocalDate getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(LocalDate publishedDate) {
    this.publishedDate = publishedDate;
  }

  @Override
  public String toString() {
    return "Topic{" +
            "id=" + id +
            ", author_id=" + authorId +
            ", text='" + title + '\'' +
            ", publishedDate=" + publishedDate +
            '}';
  }
}

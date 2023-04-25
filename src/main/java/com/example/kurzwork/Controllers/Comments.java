package com.example.kurzwork.Controllers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long catalogId;
    private String username;
    private String commentText;
    private LocalDateTime dateTime;
    private String dateTimeFormatted;

    protected Comments() {}

    public Comments(Long catalogId, String username, String commentText) {
        this.catalogId = catalogId;
        this.username = username;
        this.commentText = commentText;

    }

    @Override
    public String toString() {
        return String.format(
                "Comments[id=%d, catalogId=%d, username='%s', commentText='%s']",
                id, catalogId, username, commentText);
    }

    public Long getId() {
        return id;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public String getDateTimeFormatted() {
        return dateTimeFormatted;
    }

    public void setDateTimeFormatted(String dateTimeFormatted) {
        this.dateTimeFormatted = dateTimeFormatted;
    }
}
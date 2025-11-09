package com.applydigital.domain.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@Document(collection = "news_blacklist")
public class DeletedNewsEntity {
    @Id
    private String objectId;
    private LocalDateTime createdAt;
}
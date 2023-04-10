package com.devtiro.book.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="entities")
public class Notification {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="notifications_id_seq")
    private Long id;

    private String message;

    private LocalDateTime timestamp;

    private String service;
}

package com.devtiro.book.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devtiro.book.domain.Notification;

public interface NotificationsService {

    Notification save(Notification book);

    Page<Notification> listNotifications(Pageable pageable);
}

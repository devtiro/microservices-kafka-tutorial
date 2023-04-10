package com.devtiro.book.services;

import com.devtiro.book.domain.Notification;

public interface NotificationService {
    void publishNotification(Notification notification);
}

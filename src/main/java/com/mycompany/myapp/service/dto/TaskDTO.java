package com.mycompany.myapp.service.dto;

import com.mycompany.myapp.domain.User;

public record TaskDTO (Long id,
                       String title,
                       String description,
                       String status,
                       int priority,
                       User author,
                       User executor
                       ) {}

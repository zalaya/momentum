package dev.zalaya.events.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class Event<T> {

    private final String type;
    private final T data;
    private final LocalDateTime timestamp = LocalDateTime.now();

}

package dev.zalaya.events.infrastructure.event.definition;

import dev.zalaya.events.infrastructure.event.EventDispatcher;
import dev.zalaya.events.infrastructure.event.enumerator.EventDispatcherType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Component
@RequiredArgsConstructor
public class EventDispatcherStrategyDefinition {

    private final List<EventDispatcher> dispatchers;
    private final EventDispatcherType type;

}

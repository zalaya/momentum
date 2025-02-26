package dev.zalaya.events.infrastructure.event.definition;

import dev.zalaya.events.infrastructure.event.EventDispatcher;
import dev.zalaya.events.infrastructure.event.enumerator.EventDispatcherType;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventDispatcherStrategyDefinition {

    private final List<EventDispatcher> dispatchers;
    private final EventDispatcherType type;

    public EventDispatcher getDispatcher() {
        for (EventDispatcher dispatcher : dispatchers) {
            if (dispatcher.supports(type.name())) {
                return dispatcher;
            }
        }

        throw new IllegalStateException("No event dispatcher found");
    }

}

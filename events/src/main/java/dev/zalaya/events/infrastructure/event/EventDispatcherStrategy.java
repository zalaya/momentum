package dev.zalaya.events.infrastructure.event;

import dev.zalaya.events.domain.model.Event;
import dev.zalaya.events.infrastructure.event.definition.EventDispatcherStrategyDefinition;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventDispatcherStrategy {

    private final EventDispatcherStrategyDefinition definition;

    public <T> void dispatch(Event<T> event) {
        getDispatcher().dispatch(event);
    }

    private EventDispatcher getDispatcher() {
        for (EventDispatcher dispatcher : definition.getDispatchers()) {
            if (dispatcher.supports(definition.getType().name())) {
                return dispatcher;
            }
        }

        throw new IllegalStateException("No event dispatcher found");
    }

}

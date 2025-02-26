package dev.zalaya.events.infrastructure.event;

import dev.zalaya.events.domain.model.Event;
import dev.zalaya.events.infrastructure.event.enumerator.EventDispatcherType;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventDispatcherStrategy {

    private final List<EventDispatcher> dispatchers;
    private final EventDispatcherType type;

    public <T> void dispatch(Event<T> event) {
        getDispatcher().dispatch(event);
    }

    private EventDispatcher getDispatcher() {
        for (EventDispatcher dispatcher : dispatchers) {
            if (dispatcher.supports(type.name())) {
                return dispatcher;
            }
        }

        throw new IllegalStateException("Invalid event dispatcher");
    }

}

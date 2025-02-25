package dev.zalaya.acquisition.infrastructure.event.strategy;

import dev.zalaya.acquisition.domain.model.Event;
import dev.zalaya.acquisition.infrastructure.event.EventDispatcher;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventDispatcherStrategy {

    // TODO: Tests.

    private final List<EventDispatcher> dispatchers;

    @Value("${event.dispatcher.strategy}")
    private final String active;

    public <T> void dispatch(Event<T> event) {
        getDispatcher().dispatch(event);
    }

    private EventDispatcher getDispatcher() {
        for (EventDispatcher dispatcher : dispatchers) {
            if (dispatcher.supports(active)) {
                return dispatcher;
            }
        }

        throw new IllegalStateException("No event dispatcher found.");
    }

}

package dev.zalaya.events.infrastructure.event;

import dev.zalaya.events.domain.model.Event;

public interface EventDispatcher {

    <T> void dispatch(Event<T> event);
    String getSupportedStrategy();

    default boolean supports(String strategy) {
        if (strategy == null) {
            return false;
        }

        return strategy.equalsIgnoreCase(getSupportedStrategy());
    }

}

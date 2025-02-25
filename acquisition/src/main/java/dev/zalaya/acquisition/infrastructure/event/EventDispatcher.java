package dev.zalaya.acquisition.infrastructure.event;

import dev.zalaya.acquisition.domain.model.Event;

public interface EventDispatcher {

    <T> void dispatch(Event<T> event);
    boolean supports(String strategy);

}

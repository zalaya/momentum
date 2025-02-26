package dev.zalaya.events.infrastructure.event.enumerator;

public enum EventDispatcherType {

    LOG,
    DATABASE;

    public static EventDispatcherType fromString(String value) {
        try {
            return EventDispatcherType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid dispatcher strategy");
        }
    }

}

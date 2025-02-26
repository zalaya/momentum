package dev.zalaya.events.infrastructure.event.enumerator;

public enum EventDispatcherType {

    LOG,
    DATABASE;

    public static EventDispatcherType fromString(String value) {
        return valueOf(value.toUpperCase());
    }

}

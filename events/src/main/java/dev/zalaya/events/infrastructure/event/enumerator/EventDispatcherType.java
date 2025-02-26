package dev.zalaya.events.infrastructure.event.enumerator;

public enum EventDispatcherType {

    LOG,
    DATABASE;

    public static EventDispatcherType fromString(String value) {
        for (EventDispatcherType type : values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }

        throw new IllegalArgumentException("Invalid dispatcher strategy");
    }

}

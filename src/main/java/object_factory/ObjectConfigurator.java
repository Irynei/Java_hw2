package object_factory;

import lombok.SneakyThrows;

public interface ObjectConfigurator {
    @SneakyThrows
    <T> void configure(Class<T> type, T object);
}

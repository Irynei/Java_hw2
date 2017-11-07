package object_factory;

public interface Config {
    <T> Class<T> getImpl(Class<T> ifc);
}

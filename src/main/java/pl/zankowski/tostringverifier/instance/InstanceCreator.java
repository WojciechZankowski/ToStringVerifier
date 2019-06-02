package pl.zankowski.tostringverifier.instance;

public interface InstanceCreator {

    Object newInstance(final Class<?> clazz);

}

package pl.zankowski.tostringverifier.generator;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;

public abstract class AbstractGenerator implements Generator {

    protected String map(final Field field, final Object instance, final boolean distinguishFieldTypes) {
        try {
            field.setAccessible(true);

            final String fieldName = field.getName();
            final Object value = field.get(instance);

            if (field.getType().isArray()) {
                return fieldName + "=" + arrayToString(value);
            }
            if (field.getType().isAssignableFrom(String.class) && distinguishFieldTypes) {
                return fieldName + "='" + value.toString() + "'";
            }
            return fieldName + "=" + value.toString();
        } catch (final IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    abstract String arrayToString(final Object array);

}

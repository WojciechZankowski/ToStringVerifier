package pl.zankowski.tostringverifier;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ReflectionUtil {

    public static List<Field> getFields(final Object instance) {
        return getFields(instance.getClass());
    }

    public static List<Field> getFields(final Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> !Modifier.isStatic(field.getModifiers()))
                .collect(toList());
    }

}

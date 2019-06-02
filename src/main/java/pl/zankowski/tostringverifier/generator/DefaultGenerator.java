package pl.zankowski.tostringverifier.generator;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static pl.zankowski.tostringverifier.ReflectionUtil.getFields;

class DefaultGenerator implements Generator {

    @Override
    public GeneratorResult generate(final Object instance) {
        final String prefix = prefix(instance);
        final String suffix = "}";
        final List<String> fields = getFields(instance).stream()
                .map(field -> this.map(field, instance)).collect(toList());

        return ImmutableGeneratorResult.builder()
                .prefix(prefix)
                .suffix(suffix)
                .fields(fields)
                .full(fields.stream().collect(Collectors.joining(", ", prefix, suffix)))
                .build();
    }

    private String map(final Field field, final Object instance) {
        try {
            field.setAccessible(true);

            final String fieldName = field.getName();
            final Object value = field.get(instance);

            return fieldName + "=" + value.toString();
        } catch (final IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private String prefix(final Object instance) {
        return instance.getClass().getSimpleName() + "{";
    }

}

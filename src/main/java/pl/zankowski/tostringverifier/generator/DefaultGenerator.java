package pl.zankowski.tostringverifier.generator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static pl.zankowski.tostringverifier.ReflectionUtil.getFields;

class DefaultGenerator extends AbstractGenerator {

    private final boolean distinguishFieldTypes;
    private final char openBracket;
    private final char closingBracket;

    DefaultGenerator(final boolean distinguishFieldTypes, final char openBracket, final char closingBracket) {
        this.distinguishFieldTypes = distinguishFieldTypes;
        this.openBracket = openBracket;
        this.closingBracket = closingBracket;
    }

    DefaultGenerator(final boolean distinguishFieldTypes) {
        this(distinguishFieldTypes, '{', '}');
    }

    @Override
    public GeneratorResult generate(final Object instance) {
        final String prefix = prefix(instance);
        final String suffix = String.valueOf(closingBracket);
        final List<String> fields = getFields(instance).stream()
                .map(field -> this.map(field, instance, distinguishFieldTypes))
                .collect(toList());

        return ImmutableGeneratorResult.builder()
                .prefix(prefix)
                .suffix(suffix)
                .fields(fields)
                .full(fields.stream().collect(Collectors.joining(", ", prefix, suffix)))
                .build();
    }

    private String prefix(final Object instance) {
        return instance.getClass().getSimpleName() + openBracket;
    }

    @Override
    String arrayToString(final Object array) {
        if (array instanceof Object[]) {
            return Arrays.toString((Object[]) array);
        }
        if (array instanceof long[]) {
            return Arrays.toString((long[]) array);
        }
        if (array instanceof int[]) {
            return Arrays.toString((int[]) array);
        }
        if (array instanceof short[]) {
            return Arrays.toString((short[]) array);
        }
        if (array instanceof char[]) {
            return Arrays.toString((char[]) array);
        }
        if (array instanceof byte[]) {
            return Arrays.toString((byte[]) array);
        }
        if (array instanceof float[]) {
            return Arrays.toString((float[]) array);
        }
        if (array instanceof double[]) {
            return Arrays.toString((double[]) array);
        }
        return array.toString();
    }

}

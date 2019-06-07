package pl.zankowski.tostringverifier.generator;

import org.apache.commons.lang3.ArrayUtils;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static pl.zankowski.tostringverifier.ReflectionUtil.getFields;

public class ApacheLang3DefaultStyleGenerator extends AbstractGenerator {

    @Override
    public GeneratorResult generate(final Object instance) {
        final String prefix = prefix(instance);
        final String suffix = "]";
        final List<String> fields = getFields(instance).stream()
                .map(field -> this.map(field, instance, false))
                .collect(toList());

        return ImmutableGeneratorResult.builder()
                .prefix(prefix)
                .suffix(suffix)
                .fields(fields)
                .full(fields.stream().collect(Collectors.joining(",", prefix, suffix)))
                .build();
    }

    private String prefix(final Object instance) {
        return instance.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(instance)) + "[";
    }

    @Override
    String arrayToString(final Object array) {
        return ArrayUtils.toString(array);
    }
}

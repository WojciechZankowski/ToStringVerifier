package pl.zankowski.tostringverifier.generator;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class GeneratorFactory {

    private static final Generator DEFAULT_GENERATOR = new DefaultGenerator();

    private Map<GeneratorType, Generator> GENERATOR_MAP = ImmutableMap.<GeneratorType, Generator>builder()
            .put(GeneratorType.GUAVA, DEFAULT_GENERATOR)
            .put(GeneratorType.GUAVA_18_PLUS, DEFAULT_GENERATOR)
            .build();

    public Generator get(final GeneratorType generatorType) {
        return GENERATOR_MAP.getOrDefault(generatorType, DEFAULT_GENERATOR);
    }

}

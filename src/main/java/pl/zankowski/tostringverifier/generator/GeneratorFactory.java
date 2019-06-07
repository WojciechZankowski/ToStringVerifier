package pl.zankowski.tostringverifier.generator;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class GeneratorFactory {

    private static final Generator DEFAULT_GENERATOR_DISTINGUISHED = new DefaultGenerator(true);
    private static final Generator DEFAULT_GENERATOR = new DefaultGenerator(false);
    private static final Generator STRING_JOINER_GENERATOR = new DefaultGenerator(true, '[', ']');
    private static final Generator APACHE_LANG_3 = new ApacheLang3DefaultStyleGenerator();

    private Map<GeneratorType, Generator> GENERATOR_MAP = ImmutableMap.<GeneratorType, Generator>builder()
            .put(GeneratorType.GUAVA, DEFAULT_GENERATOR)
            .put(GeneratorType.GUAVA_18_PLUS, DEFAULT_GENERATOR)
            .put(GeneratorType.APACHE_LANG3, APACHE_LANG_3)
            .put(GeneratorType.STRING_BUFFER, DEFAULT_GENERATOR_DISTINGUISHED)
            .put(GeneratorType.STRING_BUILDER, DEFAULT_GENERATOR_DISTINGUISHED)
            .put(GeneratorType.STRING_CONCAT, DEFAULT_GENERATOR_DISTINGUISHED)
            .put(GeneratorType.STRING_JOINER, STRING_JOINER_GENERATOR)
            .build();

    public Generator get(final GeneratorType generatorType) {
        return GENERATOR_MAP.getOrDefault(generatorType, DEFAULT_GENERATOR);
    }

}

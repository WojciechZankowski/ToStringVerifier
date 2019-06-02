package pl.zankowski.tostringverifier.validator;

import pl.zankowski.tostringverifier.generator.GeneratorResult;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class SuffixValidator implements Validator {

    @Override
    public void validate(final String toString, final GeneratorResult generatorResult) {
        Objects.requireNonNull(toString);

        assertThat(toString).endsWith(generatorResult.getSuffix());
    }

}

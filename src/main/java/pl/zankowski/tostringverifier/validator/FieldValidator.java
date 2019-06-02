package pl.zankowski.tostringverifier.validator;

import pl.zankowski.tostringverifier.generator.GeneratorResult;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class FieldValidator implements Validator {

    @Override
    public void validate(final String toString, final GeneratorResult generatorResult) {
        Objects.requireNonNull(toString);

        generatorResult.getFields().forEach(field -> assertField(field, toString));
    }

    private void assertField(final String field, final String toString) {
        assertThat(toString).containsSequence(field);
    }

}

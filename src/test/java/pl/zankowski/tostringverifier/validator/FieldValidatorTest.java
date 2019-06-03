package pl.zankowski.tostringverifier.validator;

import org.junit.Before;
import org.junit.Test;
import pl.zankowski.tostringverifier.generator.ImmutableGeneratorResult;

public class FieldValidatorTest {

    private FieldValidator validator;

    @Before
    public void setUp() {
        validator = new FieldValidator();
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowAnExceptionWhenToStringIsNull() {
        validator.validate(null, ImmutableGeneratorResult.builder()
                .prefix("")
                .suffix("")
                .full("")
                .addFields("")
                .build());
    }

    @Test
    public void shouldSuccessfullyValidateField() {
        final String field = "test=test";

        validator.validate(field, ImmutableGeneratorResult.builder()
                .prefix("")
                .suffix("")
                .full("")
                .addFields(field)
                .build());
    }

}

package pl.zankowski.tostringverifier.validator;

import org.junit.Before;
import org.junit.Test;
import pl.zankowski.tostringverifier.generator.ImmutableGeneratorResult;

public class PrefixValidatorTest {

    private PrefixValidator validator;

    @Before
    public void setUp() {
        validator = new PrefixValidator();
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
        final String full = "{asdasda";

        validator.validate(full, ImmutableGeneratorResult.builder()
                .prefix("{")
                .suffix("")
                .full("")
                .addFields("")
                .build());
    }

}

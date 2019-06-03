package pl.zankowski.tostringverifier.validator;

import org.junit.Before;
import org.junit.Test;
import pl.zankowski.tostringverifier.generator.ImmutableGeneratorResult;

public class SuffixValidatorTest {

    private SuffixValidator validator;

    @Before
    public void setUp() {
        validator = new SuffixValidator();
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
        final String full = "test}";

        validator.validate(full, ImmutableGeneratorResult.builder()
                .prefix("{")
                .suffix("}")
                .full("")
                .addFields("")
                .build());
    }

}

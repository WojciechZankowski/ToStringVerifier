package pl.zankowski.tostringverifier.validator;

import org.junit.Before;
import org.junit.Test;
import pl.zankowski.tostringverifier.ImmutableVerifierConfiguration;
import pl.zankowski.tostringverifier.generator.GeneratorType;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorFactoryTest {

    private ValidatorFactory validatorFactory;

    @Before
    public void setUp() {
        validatorFactory = new ValidatorFactory();
    }

    @Test
    public void shouldSuccessfullyReturnStrictValidators() {
        final ImmutableVerifierConfiguration configuration = ImmutableVerifierConfiguration.builder()
                .clazz(BigDecimal.class)
                .generatorType(GeneratorType.GUAVA)
                .isStrictVerification(true)
                .build();

        final List<Validator> validators = validatorFactory.get(configuration);

        assertThat(validators).hasSize(1);
        assertThat(validators).hasAtLeastOneElementOfType(FullValidator.class);
    }

    @Test
    public void shouldSuccessfullyReturnNotStrictValidators() {
        final ImmutableVerifierConfiguration configuration = ImmutableVerifierConfiguration.builder()
                .clazz(BigDecimal.class)
                .generatorType(GeneratorType.GUAVA)
                .isStrictVerification(false)
                .build();

        final List<Validator> validators = validatorFactory.get(configuration);

        assertThat(validators).hasSize(3);
        assertThat(validators)
                .hasAtLeastOneElementOfType(PrefixValidator.class)
                .hasAtLeastOneElementOfType(SuffixValidator.class)
                .hasAtLeastOneElementOfType(FieldValidator.class);
    }

}

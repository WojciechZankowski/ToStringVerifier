package pl.zankowski.tostringverifier;

import pl.zankowski.tostringverifier.generator.GeneratorFactory;
import pl.zankowski.tostringverifier.generator.GeneratorType;
import pl.zankowski.tostringverifier.instance.JFixtureInstanceCreator;
import pl.zankowski.tostringverifier.validator.ToStringValidationProcessor;
import pl.zankowski.tostringverifier.validator.ValidationProcessor;
import pl.zankowski.tostringverifier.validator.ValidatorFactory;

public class ToStringVerifier implements Verifier {

    private final ValidationProcessor validationProcessor = new ToStringValidationProcessor(
            new JFixtureInstanceCreator(), new GeneratorFactory(), new ValidatorFactory());

    private final Class<?> testClazz;
    private GeneratorType generatorType;
    private boolean strictVerification;

    public ToStringVerifier(final Class<?> testClazz) {
        this.testClazz = testClazz;
    }

    public static ToStringVerifier forClass(final Class<?> clazz) {
        return new ToStringVerifier(clazz);
    }

    public ToStringVerifier withGeneratorType(final GeneratorType generatorType) {
        this.generatorType = generatorType;
        return this;
    }

    public ToStringVerifier withStrictVerification() {
        this.strictVerification = true;
        return this;
    }

    public void verify() {
        validationProcessor.validate(ImmutableVerifierConfiguration.builder()
                .clazz(testClazz)
                .generatorType(generatorType)
                .isStrictVerification(strictVerification)
                .build());
    }

}

package pl.zankowski.tostringverifier.validator;

import pl.zankowski.tostringverifier.VerifierConfiguration;
import pl.zankowski.tostringverifier.generator.Generator;
import pl.zankowski.tostringverifier.generator.GeneratorFactory;
import pl.zankowski.tostringverifier.generator.GeneratorResult;
import pl.zankowski.tostringverifier.instance.InstanceCreator;

import java.util.Objects;

public class ToStringValidationProcessor implements ValidationProcessor {

    private final InstanceCreator instanceCreator;
    private final GeneratorFactory generatorFactory;
    private final ValidatorFactory validatorFactory;

    public ToStringValidationProcessor(
            final InstanceCreator instanceCreator,
            final GeneratorFactory generatorFactory,
            final ValidatorFactory validatorFactory) {
        this.instanceCreator = instanceCreator;
        this.generatorFactory = generatorFactory;
        this.validatorFactory = validatorFactory;
    }

    @Override
    public void validate(final VerifierConfiguration verifierConfiguration) {
        Objects.requireNonNull(verifierConfiguration);

        final Object instance = instanceCreator.newInstance(verifierConfiguration.getClazz());
        final Generator generator = generatorFactory.get(verifierConfiguration.getGeneratorType());
        final GeneratorResult generatorResult = generator.generate(instance);
        final String toString = instance.toString();

        validatorFactory.get(verifierConfiguration).forEach(validator -> validator.validate(toString, generatorResult));
    }

}

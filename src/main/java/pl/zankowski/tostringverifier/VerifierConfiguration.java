package pl.zankowski.tostringverifier;

import org.immutables.value.Value;
import pl.zankowski.tostringverifier.generator.GeneratorType;

@Value.Immutable
public interface VerifierConfiguration {

    Class<?> getClazz();

    GeneratorType getGeneratorType();

    Boolean isStrictVerification();

}

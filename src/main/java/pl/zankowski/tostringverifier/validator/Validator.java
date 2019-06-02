package pl.zankowski.tostringverifier.validator;

import pl.zankowski.tostringverifier.generator.GeneratorResult;

interface Validator {

    void validate(final String toString, final GeneratorResult generatorResult);

}

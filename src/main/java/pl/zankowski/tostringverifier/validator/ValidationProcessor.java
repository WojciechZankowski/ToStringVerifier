package pl.zankowski.tostringverifier.validator;

import pl.zankowski.tostringverifier.VerifierConfiguration;

public interface ValidationProcessor {

    void validate(final VerifierConfiguration verifierConfiguration);

}

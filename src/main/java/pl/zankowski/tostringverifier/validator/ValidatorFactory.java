package pl.zankowski.tostringverifier.validator;

import com.google.common.collect.ImmutableList;
import pl.zankowski.tostringverifier.VerifierConfiguration;

import java.util.List;

public class ValidatorFactory {

    private final FieldValidator FIELD_VALIDATOR = new FieldValidator();
    private final FullValidator FULL_VALIDATOR = new FullValidator();
    private final PrefixValidator PREFIX_VALIDATOR = new PrefixValidator();
    private final SuffixValidator SUFFIX_VALIDATOR = new SuffixValidator();

    private List<Validator> STRICT_VALIDATION = ImmutableList.<Validator>builder()
            .add(FULL_VALIDATOR)
            .build();

    private List<Validator> LOOSE_VALIDATION = ImmutableList.<Validator>builder()
            .add(PREFIX_VALIDATOR)
            .add(SUFFIX_VALIDATOR)
            .add(FIELD_VALIDATOR)
            .build();

    List<Validator> get(final VerifierConfiguration verifierConfiguration) {
        if (verifierConfiguration.isStrictVerification()) {
            return STRICT_VALIDATION;
        }
        return LOOSE_VALIDATION;
    }

}

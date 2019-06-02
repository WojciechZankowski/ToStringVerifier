package pl.zankowski.tostringverifier;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.Exchange;
import pl.zankowski.tostringverifier.generator.GeneratorType;

public class ToStringVerifierTest {

    @Test
    public void test() {
        ToStringVerifier.forClass(Exchange.class)
                .withGeneratorType(GeneratorType.GUAVA_18_PLUS)
                .verify();
    }

}

package pl.zankowski.tostringverifier;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.Exchange;
import pl.zankowski.tostringverifier.generator.GeneratorType;
import pl.zankowski.tostringverifier.testdata.ApacheLang3TestData;
import pl.zankowski.tostringverifier.testdata.Guava18TestData;
import pl.zankowski.tostringverifier.testdata.StringBufferTestData;
import pl.zankowski.tostringverifier.testdata.StringBuilderTestData;
import pl.zankowski.tostringverifier.testdata.StringConcatTestData;
import pl.zankowski.tostringverifier.testdata.StringJoinerTestData;

public class ToStringVerifierTest {

    @Test
    public void test() {
        ToStringVerifier.forClass(Exchange.class)
                .withGeneratorType(GeneratorType.GUAVA_18_PLUS)
                .verify();
    }

    @Test
    public void strictTest() {
        ToStringVerifier.forClass(Exchange.class)
                .withGeneratorType(GeneratorType.GUAVA_18_PLUS)
                .withStrictVerification()
                .verify();
    }

    @Test
    public void guava18Test() {
        ToStringVerifier.forClass(Guava18TestData.class)
                .withGeneratorType(GeneratorType.GUAVA_18_PLUS)
                .withStrictVerification()
                .verify();
    }

    @Test
    public void apacheLang3Test() {
        ToStringVerifier.forClass(ApacheLang3TestData.class)
                .withGeneratorType(GeneratorType.APACHE_LANG3)
                .withStrictVerification()
                .verify();
    }

    @Test
    public void stringBufferTest() {
        ToStringVerifier.forClass(StringBufferTestData.class)
                .withGeneratorType(GeneratorType.STRING_BUFFER)
                .withStrictVerification()
                .verify();
    }

    @Test
    public void stringBuilderTest() {
        ToStringVerifier.forClass(StringBuilderTestData.class)
                .withGeneratorType(GeneratorType.STRING_BUILDER)
                .withStrictVerification()
                .verify();
    }

    @Test
    public void stringJoinerTest() {
        ToStringVerifier.forClass(StringJoinerTestData.class)
                .withGeneratorType(GeneratorType.STRING_JOINER)
                .withStrictVerification()
                .verify();
    }

    @Test
    public void stringConcatTest() {
        ToStringVerifier.forClass(StringConcatTestData.class)
                .withGeneratorType(GeneratorType.STRING_CONCAT)
                .withStrictVerification()
                .verify();
    }

}

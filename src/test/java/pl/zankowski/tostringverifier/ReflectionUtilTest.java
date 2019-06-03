package pl.zankowski.tostringverifier;

import org.assertj.core.api.Condition;
import org.junit.Test;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReflectionUtilTest {

    @Test
    public void shouldSuccessfullyGetFieldsFromInstance() {
        final List<Field> fields = ReflectionUtil.getFields(new TestObject());
        assertThat(fields).hasSize(2);
    }

    @Test
    public void shouldSuccessfullyGetFieldsFromClazz() {
        final List<Field> fields = ReflectionUtil.getFields(TestObject.class);
        assertThat(fields).hasSize(2);
    }

    static class TestObject {

        private final BigDecimal one = BigDecimal.ONE;
        private final BigDecimal two = BigDecimal.TEN;

        public TestObject() {
        }

    }

}

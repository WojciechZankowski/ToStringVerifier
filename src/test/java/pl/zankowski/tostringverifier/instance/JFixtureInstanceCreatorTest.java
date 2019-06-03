package pl.zankowski.tostringverifier.instance;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class JFixtureInstanceCreatorTest {

    private JFixtureInstanceCreator instanceCreator;

    @Before
    public void setUp() {
        instanceCreator = new JFixtureInstanceCreator();
    }

    @Test
    public void shouldSuccessfullyCreateRandomInstance() {
        final Class<?> clazz = BigDecimal.class;

        final Object instance = instanceCreator.newInstance(clazz);

        assertThat(instance).isInstanceOfAny(clazz);
    }

}

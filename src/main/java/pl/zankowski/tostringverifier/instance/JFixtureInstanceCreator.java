package pl.zankowski.tostringverifier.instance;

import com.flextrade.jfixture.JFixture;

public class JFixtureInstanceCreator implements InstanceCreator {

    private final JFixture fixture = new JFixture();

    public Object newInstance(final Class<?> clazz) {
        return fixture.create(clazz);
    }

}

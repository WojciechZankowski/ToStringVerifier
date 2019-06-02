package pl.zankowski.tostringverifier.instance;

import com.flextrade.jfixture.JFixture;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.tostringverifier.generator.DefaultGenerator;
import pl.zankowski.tostringverifier.generator.GeneratorResult;

public class JFixtureInstanceCreator implements InstanceCreator {

    private final JFixture fixture = new JFixture();

    public Object newInstance(final Class<?> clazz) {
        return fixture.create(clazz);
    }

    public static void main(String[] args) {
        final JFixtureInstanceCreator creator = new JFixtureInstanceCreator();
        creator.newInstance(Quote.class);

        final Quote quote = creator.fixture.create(Quote.class);

        final GeneratorResult result = new DefaultGenerator().generate(quote);
        System.out.println(result);
    }

}

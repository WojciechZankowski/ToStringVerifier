package pl.zankowski.tostringverifier.testdata;

import org.apache.commons.lang3.builder.ToStringBuilder;
import pl.zankowski.iextrading4j.api.refdata.v1.Exchange;

import java.util.List;

public class ApacheLang3TestData {

    private final String stringField;
    private final int primitiveField;
    private final long[] primitiveArray;
    private final Exchange[] array;
    private final List<Exchange> collection;
    private final Exchange object;

    public ApacheLang3TestData(
            final String stringField,
            final int primitiveField,
            final long[] primitiveArray,
            final Exchange[] array,
            final List<Exchange> collection,
            final Exchange object) {
        this.stringField = stringField;
        this.primitiveField = primitiveField;
        this.primitiveArray = primitiveArray;
        this.array = array;
        this.collection = collection;
        this.object = object;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("stringField", stringField)
                .append("primitiveField", primitiveField)
                .append("primitiveArray", primitiveArray)
                .append("array", array)
                .append("collection", collection)
                .append("object", object)
                .toString();
    }
}

package pl.zankowski.tostringverifier.testdata;

import pl.zankowski.iextrading4j.api.refdata.v1.Exchange;

import java.util.Arrays;
import java.util.List;

public class StringBuilderTestData {

    private final String stringField;
    private final int primitiveField;
    private final long[] primitiveArray;
    private final Exchange[] array;
    private final List<Exchange> collection;
    private final Exchange object;

    public StringBuilderTestData(
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
        final StringBuilder sb = new StringBuilder("StringBuilderTestData{");
        sb.append("stringField='").append(stringField).append('\'');
        sb.append(", primitiveField=").append(primitiveField);
        sb.append(", primitiveArray=").append(Arrays.toString(primitiveArray));
        sb.append(", array=").append(Arrays.toString(array));
        sb.append(", collection=").append(collection);
        sb.append(", object=").append(object);
        sb.append('}');
        return sb.toString();
    }
}

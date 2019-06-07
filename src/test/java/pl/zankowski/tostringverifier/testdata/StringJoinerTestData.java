package pl.zankowski.tostringverifier.testdata;

import pl.zankowski.iextrading4j.api.refdata.v1.Exchange;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StringJoinerTestData {

    private final String stringField;
    private final int primitiveField;
    private final long[] primitiveArray;
    private final Exchange[] array;
    private final List<Exchange> collection;
    private final Exchange object;

    public StringJoinerTestData(
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
        return new StringJoiner(", ", StringJoinerTestData.class.getSimpleName() + "[", "]")
                .add("stringField='" + stringField + "'")
                .add("primitiveField=" + primitiveField)
                .add("primitiveArray=" + Arrays.toString(primitiveArray))
                .add("array=" + Arrays.toString(array))
                .add("collection=" + collection)
                .add("object=" + object)
                .toString();
    }
}

package pl.zankowski.tostringverifier.testdata;

import com.google.common.base.MoreObjects;
import pl.zankowski.iextrading4j.api.refdata.v1.Exchange;

import java.util.List;

public class Guava18TestData {

    private final String stringField;
    private final int primitiveField;
    private final long[] primitiveArray;
    private final Exchange[] array;
    private final List<Exchange> collection;
    private final Exchange object;

    public Guava18TestData(
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
        return MoreObjects.toStringHelper(this)
                .add("stringField", stringField)
                .add("primitiveField", primitiveField)
                .add("primitiveArray", primitiveArray)
                .add("array", array)
                .add("collection", collection)
                .add("object", object)
                .toString();
    }
}

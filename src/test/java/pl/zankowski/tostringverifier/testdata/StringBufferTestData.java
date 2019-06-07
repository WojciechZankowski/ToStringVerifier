package pl.zankowski.tostringverifier.testdata;

import pl.zankowski.iextrading4j.api.refdata.v1.Exchange;

import java.util.Arrays;
import java.util.List;

public class StringBufferTestData {

    private final String stringField;
    private final int primitiveField;
    private final long[] primitiveArray;
    private final Exchange[] array;
    private final List<Exchange> collection;
    private final Exchange object;

    public StringBufferTestData(
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
        final StringBuffer sb = new StringBuffer("StringBufferTestData{");
        sb.append("stringField='").append(stringField).append('\'');
        sb.append(", primitiveField=").append(primitiveField);
        sb.append(", primitiveArray=");
        if (primitiveArray == null) {
            sb.append("null");
        } else {
            sb.append('[');
            for (int i = 0; i < primitiveArray.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(primitiveArray[i]);
            sb.append(']');
        }
        sb.append(", array=").append(array == null ? "null" : Arrays.asList(array).toString());
        sb.append(", collection=").append(collection);
        sb.append(", object=").append(object);
        sb.append('}');
        return sb.toString();
    }
}

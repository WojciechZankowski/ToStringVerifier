package pl.zankowski.tostringverifier.generator;


import org.immutables.value.Value;

import java.io.Serializable;
import java.util.List;

@Value.Immutable
public interface GeneratorResult extends Serializable {

    String getPrefix();

    String getSuffix();

    List<String> getFields();

    String getFull();

}

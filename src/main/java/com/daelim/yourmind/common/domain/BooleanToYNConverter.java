package com.daelim.yourmind.common.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanToYNConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? "y" : "n";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "y".equals(dbData);
    }
}

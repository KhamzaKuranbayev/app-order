package com.example.apporder.entity.template;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CharConvertor implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String value) {
        return value;
    }

    @Override
    public String convertToEntityAttribute(String value) {
        if(value == null) {
            return null;
        }
        return value.trim();
    }
}

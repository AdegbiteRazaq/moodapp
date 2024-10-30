package com.school.sport_enrollment.Utils;

import com.school.sport_enrollment.Enums.Moods;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
@Converter(autoApply = true)
public class MoodConverter implements AttributeConverter<Moods, Integer> {
   @Override
   public Integer convertToDatabaseColumn(Moods mood) {
       return mood != null ? mood.getValue() : null;
   }
   @Override
   public Moods convertToEntityAttribute(Integer value) {
       return value != null ? Moods.fromValue(value) : null;
   }

}

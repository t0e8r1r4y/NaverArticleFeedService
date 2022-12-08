package com.myservice.web.validation;

import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class KeyWordMaxCountValidator implements ConstraintValidator<MaxKeyword,String> {
  @Override
  public void initialize(MaxKeyword constraintAnnotation) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    List<String> keywords = Arrays.asList(value.split(","));
    return keywords.size() <= 10;
  }
}

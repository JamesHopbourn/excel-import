package com.example.excelimport.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author James Hopbourn
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelProperties {
    /**
     * 枚举类型 单元格颜色
     * 使用 @ExcelProperties 默认设置红色
     * @return ColorEnums
     */
    ColorEnums value() default ColorEnums.RED;

    /**
     * 字段描述，会显示在第一行，字段上方
     * @return description
     */
    String description() default "";
}
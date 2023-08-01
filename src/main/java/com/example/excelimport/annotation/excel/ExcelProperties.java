package com.example.excelimport.annotation.excel;

import com.example.excelimport.annotation.excel.pojo.ColorEnums;

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

    /**
     * 是不是唯一标识符，用来区分导入还是更新
     * @return
     */
    boolean uniqueField() default false;
}
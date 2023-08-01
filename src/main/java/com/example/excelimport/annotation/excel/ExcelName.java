package com.example.excelimport.annotation.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author James Hopbourn
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExcelName {
    /**
     * 文件名称
     * @return
     */
    String value() default "";

    /**
     * 首行：注意事项
     * @return
     */
    String attention() default "红色字段为必填项，黑色字段为可选项，第二行是字段填写注意事项，第三行是字段名";

    /**
     * 首行：添加导出操作人导出和时间，默认开启
     * @return
     */
    boolean operationLog() default true;

    /**
     * 是否添加日期时间
     * @return
     */
    boolean enableDateTime() default true;

    /**
     * 日期时间格式
     */
    String dateTimeFormat() default "yyyy-MM-dd HH:mm:ss";

    /**
     * 文件名前缀
     * @return
     */
    String prefix() default "";

    /**
     * 文件名后缀
     * @return
     */
    String suffix() default "";
}

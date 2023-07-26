package com.example.excelimport.annotation;

/**
 * @author James Hopbourn
 */
public @interface ExcelName {
    /**
     * 文件名称
     * @return
     */
    String value() default "";

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
    String endfix() default "";
}

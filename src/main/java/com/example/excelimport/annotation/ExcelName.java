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
     * 首行：注意事项
     * @return
     */
<<<<<<< HEAD
    String attention() default "红色字段为必填项";
=======
    String attention() default "红色字段为必填项，黑色字段为可选项";
>>>>>>> d8bdccc (添加注解属性)

    /**
     * 首行：添加导出操作人导出和时间，默认开启
     * @return
     */
    boolean OperationLog() default true;

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

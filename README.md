#### README.md

##### 使用方法
1. 基本使用：在需要添加颜色的字段上添加注释 `@ExcelProperties`，默认即为红色
```java
@ExcelProperties
@Excel(name = "船名", width = 10)
private String chuanMing;
```

2. 字段备注：如果需要对字段添加备注，給注解添加 description 属性即可
```java
@ExcelProperties(description = "红色字段为初始必填项目")
@Excel(name = "SO编号", width = 30)
private String soBianHao;
```

3. 文本颜色：如果使用了 `@ExcelProperties` 注释，但是希望依旧保留文字为黑色，指定相应颜色枚举即可
```java
@ExcelProperties(value = ColorEnums.BLACK, description = "箱货跟踪时必填")
@Excel(name = "船司代码", width = 20)
private String chuanSiDaiMa;
```

4. 字段排序：配置 `@Excel` orderNum 属性即可，ExcelPropertiesImpl 会读取值并按照配置生成 Excel
```java
@ExcelProperties(description = "箱货跟踪时必填")
@Excel(name = "提单号", width = 20, orderNum = "1")
private String tiDanHao;

@ExcelProperties(description = "红色字段为初始必填项目")
@Excel(name = "SO编号", width = 30, orderNum = "2")
private String soBianHao;

@ExcelProperties(description = "多次更新导入时作为唯一匹配号")
@Excel(name = "DN编号", width = 30, orderNum = "3")
private String dnBianHao;
```

5. 文件名字：Excel 导出模版下载名称，在实体类上添加 `@ExcelName` 注解即可
```java
@ExcelName("提单信息表格")
public class User {
    
}
```

6. 前缀后缀：在 Excel 文件名添加前缀和后缀，默认为空
```java
@ExcelName(value = "用户表", prefix = "PTU", suffix = "学生")
public class User {
    
}
```

7. 时间格式：Excel 导出文件是否包含导出日期时间，默认开启，可自定义日期时间格式
```java
@ExcelName(value = "用户表", dateTimeFormat = "yyyy-MM-dd")
public class User {
    
}
```

8. 注意事项：Excel 导出首行的备注信息，可以提示用户如何填写数据，默认为 `"红色字段为必填项，黑色字段为可选项，第二行是字段填写注意事项，第三行是字段名"`，可以根据业务需求场景覆盖。注意事项单元格的高度可以跟随注意事项的行数自动变化。
```java
@ExcelName(value = "用户表", attentionNote = "红色为必填字段\n黑色为可选字段")
public class User { 
    
}
```

9. 操作日志：导出首行备注信息中是否包含导出操作人员用户名以及导出时间，默认开启
```java
@ExcelName(value = "用户表", prefix = "PTU", operationLog = false)
public class User {

}
```

##### 处理流程
1. 通过 @ExcelProperties 注解添加备注和颜色
2. ExcelCellStyleUtil 用于获取不同单元格的样式  
   2.1 例如普通字段黑色、必填字段红色样式  
3. 通过 ExcelPropertiesImpl.allField() 方法获取所有含有 @Excel 和 @ExcelProperties 字段  
   3.1 定义一个字段信息类：ExcelField  
   3.2 读取所有需要导出的字段信息，创建 ExcelField 对象  
   3.3 添加 ExcelField 对象到 excelFieldList  
   3.4 返回 excelFieldList  
4. XSSFWorkbook 读取 excelFieldList for 循环创建 Excel
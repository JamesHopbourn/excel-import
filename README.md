#### README.md

##### 使用方法
- 在需要添加颜色的字段上添加注释 `@ExcelProperties`，默认即为红色
- 如果需要对字段添加备注，給注解添加 description 属性即可，例如：`@ExcelProperties(description = "红色字段为初始必填项目")`
- 如果使用了 `@ExcelProperties` 注释，但是希望依旧保留文字为黑色，指定相应颜色枚举即可，例如：`@ExcelProperties(value = ColorEnums.BLACK, description = "箱货跟踪时必填")`

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
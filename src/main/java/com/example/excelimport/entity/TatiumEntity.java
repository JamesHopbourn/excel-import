package com.example.excelimport.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TatiumEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;
    /**
     * 创建人
     */
    @Excel(name = "创建人", width = 15)
    private String chuangJianRen;
    /**
     * 创建时间
     */
    @Excel(name = "创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    private Date chuangJianShiJian;
    /**
     * 更新人
     */
    @Excel(name = "修改人", width = 15)
    private String xiuGaiRen;
    /**
     * 更新时间
     */
    @Excel(name = "修改时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    private Date xiuGaiShiJian;

}

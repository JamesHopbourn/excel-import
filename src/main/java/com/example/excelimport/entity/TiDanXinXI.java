package com.example.excelimport.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.excelimport.annotation.ColorEnums;
import com.example.excelimport.annotation.ExcelProperties;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class TiDanXinXI {
    private static final long serialVersionUID = 1L;

    /**
     * 提单号
     */
    @ExcelProperties(description = "箱货跟踪时必填")
    @Excel(name = "提单号", width = 20)
    private String tiDanHao;
    /**
     * 物流商名称
     */
    @Excel(name = "物流商名称", width = 10)
    private String wuLiuShangMingCheng;
    /**
     * SO编号
     */
    @ExcelProperties(description = "红色字段为初始必填项目")
    @Excel(name = "SO编号", width = 30)
    private String soBianHao;
    /**
     * DN编号
     */
    @ExcelProperties(description = "多次更新导入时作为唯一匹配号")
    @Excel(name = "DN编号", width = 30)
    private String dnBianHao;
    /**
     * 客户名称
     */
    @Excel(name = "客户名称", width = 20)
    private String keHuMingCheng;
    /**
     * 下单日期
     */
    @Excel(name = "下单日期", width = 20)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date xiaDanRiQi;
    /**
     * 预计货好日期
     */
    @Excel(name = "预计货好日期", width = 20)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date yuJiHuoHaoRiQi;
    /**
     * 预计交货日期
     */
    @Excel(name = "预计交货日期", width = 20)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date yuJiJiaoHuoRiQi;
    /**
     * 操作人员
     */
    @Excel(name = "操作人员", width = 20)
    private String caoZuoRenYuan;
    /**
     * 操作人员邮箱
     */
    @Excel(name = "操作人员邮箱", width = 20)
    private String caoZuoRenYuanYouXiang;
    /**
     * 件数
     */
    @Excel(name = "件数", width = 20)
    private BigDecimal jianShu;
    /**
     * 毛重
     */
    @Excel(name = "毛重", width = 20)
    private BigDecimal maoZhong;
    /**
     * 体积
     */
    @Excel(name = "体积", width = 20)
    private BigDecimal tiJi;
    /**
     * 品名
     */
    @Excel(name = "品名", width = 20)
    private String pinMing;
    /**
     * 船司代码
     */
    @ExcelProperties(value = ColorEnums.BLACK, description = "箱货跟踪时必填")
    @Excel(name = "船司代码", width = 20)
    private String chuanSiDaiMa;
    /**
     * 船名
     */
    @ExcelProperties
    @Excel(name = "船名", width = 10)
    private String chuanMing;
    /**
     * 航次
     */
    @ExcelProperties
    @Excel(name = "航次", width = 10)
    private String hangCi;
    /**
     * ETD
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date etd;
    /**
     * ETA
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date eta;
    /**
     * ATD
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date atd;
    /**
     * ATA
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ata;
    /**
     * 始发港
     */
    @ExcelProperties
    @Excel(name = "始发港", width = 10)
    private String shiFaGang;
    /**
     * 目的港
     */
    @Excel(name = "目的港", width = 10)
    private String muDiGang;
    /**
     * 进箱开始
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jinXiangKaiShi;
    /**
     * 进箱截至
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jinXiangJieZhi;
    /**
     * 清关日期
     */
    @Excel(name = "清关日期", width = 20)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date qingGuanRiQi;
    /**
     * 订阅跟踪日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dingYueGenZongRiQi;
    /**
     * 关闭跟踪
     */
    private String guanBiGenZong;
    /**
     * 租户id
     */
    private Integer tenantId;
}

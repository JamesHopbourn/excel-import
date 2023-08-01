package com.example.excelimport.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.excelimport.annotation.excel.ExcelName;
import com.example.excelimport.annotation.excel.ExcelProperties;
import com.example.excelimport.entity.system.TatiumEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors(chain = true)
@ExcelName(value = "提单信息表格", dateTimeFormat = "yyyy-MM-dd")
@EqualsAndHashCode(callSuper = false)
public class TiDanXinXi extends TatiumEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 提单号
     */
    @ExcelProperties(description = "箱货跟踪时必填", uniqueField = true)
    @Excel(name = "提单号", width = 20, orderNum = "1")
    private String tiDanHao;
    /**
     * 物流商名称
     */
    private String wuLiuShangMingCheng;
    /**
     * SO编号
     */
    private String soBianHao;
    /**
     * DN编号
     */
    private String dnBianHao;
    /**
     * 客户名称
     */
    private String keHuMingCheng;
    /**
     * 下单日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date xiaDanRiQi;
    /**
     * 预计货好日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date yuJiHuoHaoRiQi;
    /**
     * 预计交货日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date yuJiJiaoHuoRiQi;
    /**
     * 操作人员
     */
    private String caoZuoRenYuan;
    /**
     * 操作人员邮箱
     */
    private String caoZuoRenYuanYouXiang;
    /**
     * 件数
     */
    private BigDecimal jianShu;
    /**
     * 毛重
     */
    private BigDecimal maoZhong;
    /**
     * 体积
     */
    private BigDecimal tiJi;
    /**
     * 品名
     */
    private String pinMing;
    /**
     * 船司代码
     */
    @ExcelProperties(description = "箱货跟踪时必填")
    @Excel(name = "船司代码", width = 20,orderNum = "4")
    private String chuanSiDaiMa;
    /**
     * 船名
     */
    private String chuanMing;
    /**
     * 航次
     */
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
    @ExcelProperties(description = "箱货跟踪时必填")
    @Excel(name = "始发港", width = 30, orderNum = "7")
    private String shiFaGang;
    /**
     * 目的港
     */
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

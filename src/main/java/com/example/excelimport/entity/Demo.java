package com.example.excelimport.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.excelimport.annotation.ExcelProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Demo {
    @ExcelProperties(description = "红色字段为初始必填项目")
    @Excel(name = "SO编号",width = 30)
    private String soBianHao;
    @ExcelProperties
    @Excel(name = "DN编号",width = 10)
    private String dnBianHao;
    @ExcelProperties
    @Excel(name = "始发港",width = 10)
    private String shiFaGang;
    @ExcelProperties
    @Excel(name = "船名",width = 10)
    private String chuanMing;
    @ExcelProperties
    @Excel(name = "航次",width = 10)
    private String hangCi;

    @ExcelProperties(description = "箱货跟踪时必填")
    @Excel(name = "提单号",width = 20)
    private String tiDanHao;

    @Excel(name = "物流商名称",width = 20)
    private String wuLiuShangMingCheng;


    @Excel(name = "客户名称",width = 20)
    private String keHuMingCheng;
    @Excel(name = "下单日期",width = 20)
    private Date xiaDanRiQi;
    @Excel(name = "预计货好日期",width = 20)
    private Date yuJiHuoHaoRiQi;
    @Excel(name = "预计交货日期",width = 20)
    private Date yuJiJiaoHuoRiQi;

    @ExcelProperties
    @Excel(name = "操作人员",width = 20)
    private String caoZuoRenYuan;
    @Excel(name = "操作人员邮箱",width = 20)
    private String caoZuoRenYuanYouXiang;
    @Excel(name = "件数",width = 20)
    private BigDecimal jianShu;
    @Excel(name = "毛重",width = 20)
    private BigDecimal maoZhong;
    @Excel(name = "体积",width = 20)
    private BigDecimal tiJi;
    @Excel(name = "品名",width = 20)
    private String pinMing;
    @ExcelProperties(description = "箱货跟踪时必填")
    @Excel(name = "船司代码",width = 20)
    private String chuanSiDaiMa;

    private Date etd;
    private Date eta;
    private Date atd;
    private Date ata;

    @Excel(name = "目的港",width = 10)
    private String muDiGang;
    private Date jinXiangKaiShi;
    private Date jinXiangJieZhi;
    @Excel(name = "清关日期",width = 20)
    private Date qingGuanRiQi;
    private Date dingYueGenZongRiQi;
    private String guanBiGenZong;
    private Integer tenantId;
}
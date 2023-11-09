package cn.iocoder.yudao.module.yi.controller.admin.products.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 产品 Excel VO
 *
 * @author stone
 */
@Data
public class ProductsExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("发行机构ID")
    private Long orgId;

    @ExcelProperty("机构名称")
    private String orgName;

    @ExcelProperty("机构图标链接")
    private String orgIconUrl;

    @ExcelProperty(value = "产品类型", converter = DictConvert.class)
    @DictFormat("product_type") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String productType;

    @ExcelProperty("产品名称")
    private String productName;

    @ExcelProperty("产品期限(月)")
    private Integer productTermMonth;

    @ExcelProperty(value = "投资领域", converter = DictConvert.class)
    @DictFormat("investment_area") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String investmentArea;

    @ExcelProperty(value = "大小配比", converter = DictConvert.class)
    @DictFormat("dxpb") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String dxpb;

    @ExcelProperty("安全评级")
    private BigDecimal securityRate;

    @ExcelProperty(value = "发行进度", converter = DictConvert.class)
    @DictFormat("release_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String releaseStatus;

    @ExcelProperty("发行进度更新日期")
    private LocalDateTime releaseStatusUpdateAt;

    @ExcelProperty(value = "在售状态", converter = DictConvert.class)
    @DictFormat("sale_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String saleStatus;

    @ExcelProperty("募集规模")
    private String fundraisingSize;

    @ExcelProperty(value = "付息方式", converter = DictConvert.class)
    @DictFormat("interest_payment_method") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String interestPaymentMethod;

    @ExcelProperty("投资区域-省")
    private String investRegionProvince;

    @ExcelProperty("投资区域-市")
    private String investRegionCity;

    @ExcelProperty("起售日期")
    private LocalDateTime saleStartAt;

    @ExcelProperty(value = "收益类型", converter = DictConvert.class)
    @DictFormat("income_type") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String incomeTye;

    @ExcelProperty("抵/质押率")
    private BigDecimal mortgagePledgeRate;

    @ExcelProperty("补充说明")
    private String supplementaryNotes;

    @ExcelProperty("融资方")
    private String financialInstitution;

    @ExcelProperty("资金用途")
    private String howToUse;

    @ExcelProperty("还款来源")
    private String repaymentSource;

    @ExcelProperty("风控措施")
    private String riskControlMeasures;

    @ExcelProperty("项目亮点")
    private String projectHighlights;

    @ExcelProperty("募集账号-名称")
    private String raiseAccountName;

    @ExcelProperty("募集账号-开户行")
    private String raiseAccountBankName;

    @ExcelProperty("募集账号-账号")
    private String raiseAccountNo;

    @ExcelProperty("募集账号-备注")
    private String raiseAccountRemark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}

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
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 产品 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class ProductsBaseVO {

    @Schema(description = "发行机构ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "24417")
    @NotNull(message = "发行机构ID不能为空")
    private Long orgId;

    @Schema(description = "机构名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @NotNull(message = "机构名称不能为空")
    private String orgName;

    @Schema(description = "机构图标链接", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotNull(message = "机构图标链接不能为空")
    private String orgIconUrl;

    @Schema(description = "产品类型", example = "1")
    private String productType;

    @Schema(description = "产品名称", example = "芋艿")
    private String productName;

    @Schema(description = "产品期限(月)")
    private Integer productTermMonth;

    @Schema(description = "投资领域")
    private String investmentArea;

    @Schema(description = "大小配比")
    private String dxpb;

    @Schema(description = "安全评级")
    private BigDecimal securityRate;

    @Schema(description = "发行进度", example = "2")
    private String releaseStatus;

    @Schema(description = "发行进度更新日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime releaseStatusUpdateAt;

    @Schema(description = "在售状态", example = "1")
    private String saleStatus;

    @Schema(description = "募集规模")
    private String fundraisingSize;

    @Schema(description = "付息方式")
    private String interestPaymentMethod;

    @Schema(description = "投资区域-省")
    private String investRegionProvince;

    @Schema(description = "投资区域-市")
    private String investRegionCity;

    @Schema(description = "起售日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime saleStartAt;

    @Schema(description = "收益类型")
    private String incomeTye;

    @Schema(description = "抵/质押率")
    private BigDecimal mortgagePledgeRate;

    @Schema(description = "补充说明")
    private String supplementaryNotes;

    @Schema(description = "融资方")
    private String financialInstitution;

    @Schema(description = "资金用途")
    private String howToUse;

    @Schema(description = "还款来源")
    private String repaymentSource;

    @Schema(description = "风控措施")
    private String riskControlMeasures;

    @Schema(description = "项目亮点")
    private String projectHighlights;

    @Schema(description = "募集账号-名称", example = "李四")
    private String raiseAccountName;

    @Schema(description = "募集账号-开户行", example = "赵六")
    private String raiseAccountBankName;

    @Schema(description = "募集账号-账号")
    private String raiseAccountNo;

    @Schema(description = "募集账号-备注", example = "随便")
    private String raiseAccountRemark;

}

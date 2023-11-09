package cn.iocoder.yudao.module.yi.controller.admin.products.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 产品 Excel 导出 Request VO，参数和 ProductsPageReqVO 是一致的")
@Data
public class ProductsExportReqVO {

    @Schema(description = "发行机构ID", example = "24417")
    private Long orgId;

    @Schema(description = "机构名称", example = "李四")
    private String orgName;

    @Schema(description = "产品类型", example = "1")
    private String productType;

    @Schema(description = "产品名称", example = "芋艿")
    private String productName;

    @Schema(description = "产品期限(月)")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Integer[] productTermMonth;

    @Schema(description = "投资领域")
    private String investmentArea;

    @Schema(description = "大小配比")
    private String dxpb;

    @Schema(description = "安全评级")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private BigDecimal[] securityRate;

    @Schema(description = "在售状态", example = "1")
    private String saleStatus;

    @Schema(description = "付息方式")
    private String interestPaymentMethod;

    @Schema(description = "投资区域-省")
    private String investRegionProvince;

    @Schema(description = "投资区域-市")
    private String investRegionCity;

    @Schema(description = "收益类型")
    private String incomeTye;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}

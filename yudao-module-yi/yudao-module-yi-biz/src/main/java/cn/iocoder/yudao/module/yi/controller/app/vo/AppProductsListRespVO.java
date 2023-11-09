package cn.iocoder.yudao.module.yi.controller.app.vo;

import cn.iocoder.yudao.module.yi.controller.admin.products.vo.ProductsRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@Schema(description = "APP - 产品列表 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppProductsListRespVO extends ProductsRespVO {

    private BigDecimal maxInterest;

    private BigDecimal minAmountStart;

    private String customLabels;
}

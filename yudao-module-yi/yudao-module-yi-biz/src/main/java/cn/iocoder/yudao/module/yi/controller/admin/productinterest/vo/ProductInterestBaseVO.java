package cn.iocoder.yudao.module.yi.controller.admin.productinterest.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 产品认购金额收益 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class ProductInterestBaseVO {

    @Schema(description = "产品id", requiredMode = Schema.RequiredMode.REQUIRED, example = "32660")
    @NotNull(message = "产品id不能为空")
    private Long productId;

    @Schema(description = "金额大于等于（万）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "金额大于等于（万）不能为空")
    private BigDecimal amountStart;

    @Schema(description = "金额小于（万）", requiredMode = Schema.RequiredMode.REQUIRED)
//    @NotNull(message = "金额小于（万）不能为空")
    private BigDecimal amountEnd;

    @Schema(description = "预期收益", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "预期收益不能为空")
    private BigDecimal interestRate;

}

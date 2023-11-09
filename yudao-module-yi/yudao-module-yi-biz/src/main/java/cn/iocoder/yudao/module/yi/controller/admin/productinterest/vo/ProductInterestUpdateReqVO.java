package cn.iocoder.yudao.module.yi.controller.admin.productinterest.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 产品认购金额收益更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductInterestUpdateReqVO extends ProductInterestBaseVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "4760")
    @NotNull(message = "id不能为空")
    private Long id;

}

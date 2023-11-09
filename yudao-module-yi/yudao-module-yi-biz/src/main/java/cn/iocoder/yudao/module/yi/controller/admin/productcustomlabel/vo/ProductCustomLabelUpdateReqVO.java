package cn.iocoder.yudao.module.yi.controller.admin.productcustomlabel.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 产品自定义标签更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductCustomLabelUpdateReqVO extends ProductCustomLabelBaseVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "5556")
    @NotNull(message = "id不能为空")
    private Long id;

}

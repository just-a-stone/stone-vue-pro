package cn.iocoder.yudao.module.yi.controller.admin.productfiles.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 产品资料(文件)更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductFilesUpdateReqVO extends ProductFilesBaseVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "4723")
    @NotNull(message = "id不能为空")
    private Long id;

}

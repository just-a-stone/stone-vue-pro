package cn.iocoder.yudao.module.yi.controller.admin.productlabel.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 产品标签 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class ProductLabelBaseVO {

    @Schema(description = "产品id", requiredMode = Schema.RequiredMode.REQUIRED, example = "31410")
    @NotNull(message = "产品id不能为空")
    private Long productId;

    @Schema(description = "标签key", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "标签key不能为空")
    private String labelKey;

    @Schema(description = "标签value", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "标签value不能为空")
    private String labelValue;

    @Schema(description = "排序")
    private Integer sort;

}

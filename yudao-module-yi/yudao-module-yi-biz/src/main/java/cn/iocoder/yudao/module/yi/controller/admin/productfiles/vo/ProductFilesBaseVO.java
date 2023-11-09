package cn.iocoder.yudao.module.yi.controller.admin.productfiles.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 产品资料(文件) Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class ProductFilesBaseVO {

    @Schema(description = "产品id", requiredMode = Schema.RequiredMode.REQUIRED, example = "10516")
    @NotNull(message = "产品id不能为空")
    private Long productId;

    @Schema(description = "文件名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @NotNull(message = "文件名称不能为空")
    private String fileName;

    @Schema(description = "文件链接", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotNull(message = "文件链接不能为空")
    private String fileUrl;

    @Schema(description = "排序")
    private Integer sort;

}

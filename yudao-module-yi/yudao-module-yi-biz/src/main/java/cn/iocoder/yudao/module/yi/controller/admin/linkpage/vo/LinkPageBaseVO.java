package cn.iocoder.yudao.module.yi.controller.admin.linkpage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 外链网页 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class LinkPageBaseVO {

    @Schema(description = "主题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "主题不能为空")
    private String title;

    @Schema(description = "图片链接", example = "https://www.iocoder.cn")
//    @NotNull(message = "图片链接不能为空")
    private String picUrl;

    @Schema(description = "网页链接", example = "https://www.iocoder.cn")
    private String linkUrl;

    @Schema(description = "链接分类", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "链接分类不能为空")
    private String category;

    @Schema(description = "展示顺序")
    private Integer sort;

}

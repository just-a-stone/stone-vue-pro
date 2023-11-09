package cn.iocoder.yudao.module.yi.controller.admin.orgs.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 机构 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class OrgsBaseVO {

    @Schema(description = "机构名称", example = "王五")
    private String orgName;

    @Schema(description = "机构缩略图链接", example = "https://www.iocoder.cn")
    private String iconUrl;

}

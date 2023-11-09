package cn.iocoder.yudao.module.yi.controller.app.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "APP - 产品数量统计 Response VO")
@Data
@ToString(callSuper = true)
public class AppProductsCategoryCountVo {

    @Schema(description = "产品类型")
    private String productType;

    @Schema(description = "类型产品数量")
    private Integer count;

}

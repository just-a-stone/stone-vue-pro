package cn.iocoder.yudao.module.yi.controller.admin.productfiles.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 产品资料(文件) Excel 导出 Request VO，参数和 ProductFilesPageReqVO 是一致的")
@Data
public class ProductFilesExportReqVO {

    @Schema(description = "产品id", example = "10516")
    private Long productId;

    @Schema(description = "文件名称", example = "王五")
    private String fileName;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}

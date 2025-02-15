package cn.iocoder.yudao.module.yi.controller.admin.linkpage.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 外链网页 Excel 导出 Request VO，参数和 LinkPagePageReqVO 是一致的")
@Data
public class LinkPageExportReqVO {

    @Schema(description = "主题")
    private String title;

    @Schema(description = "链接分类")
    private String category;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}

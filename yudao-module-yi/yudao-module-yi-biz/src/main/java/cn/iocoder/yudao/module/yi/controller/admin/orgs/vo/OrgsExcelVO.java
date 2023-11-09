package cn.iocoder.yudao.module.yi.controller.admin.orgs.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 机构 Excel VO
 *
 * @author stone
 */
@Data
public class OrgsExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("机构名称")
    private String orgName;

    @ExcelProperty("机构缩略图链接")
    private String iconUrl;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}

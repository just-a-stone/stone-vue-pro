package cn.iocoder.yudao.module.yi.controller.admin.productcustomlabel.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 产品自定义标签 Excel VO
 *
 * @author stone
 */
@Data
public class ProductCustomLabelExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("产品id")
    private Long productId;

    @ExcelProperty("标签value")
    private String labelValue;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("排序")
    private Integer sort;

}

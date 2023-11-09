package cn.iocoder.yudao.module.yi.controller.admin.productlabel.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 产品标签 Excel VO
 *
 * @author stone
 */
@Data
public class ProductLabelExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("产品id")
    private Long productId;

    @ExcelProperty(value = "标签key", converter = DictConvert.class)
    @DictFormat("product_label") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String labelKey;

    @ExcelProperty("标签value")
    private String labelValue;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("排序")
    private Integer sort;

}

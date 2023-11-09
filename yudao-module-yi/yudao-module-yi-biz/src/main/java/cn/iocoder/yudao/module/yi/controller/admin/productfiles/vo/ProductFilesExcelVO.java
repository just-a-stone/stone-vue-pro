package cn.iocoder.yudao.module.yi.controller.admin.productfiles.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 产品资料(文件) Excel VO
 *
 * @author stone
 */
@Data
public class ProductFilesExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("产品id")
    private Long productId;

    @ExcelProperty("文件名称")
    private String fileName;

    @ExcelProperty("文件链接")
    private String fileUrl;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("排序")
    private Integer sort;

}

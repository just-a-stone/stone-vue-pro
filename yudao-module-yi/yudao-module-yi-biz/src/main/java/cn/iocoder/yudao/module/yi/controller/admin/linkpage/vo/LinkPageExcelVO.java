package cn.iocoder.yudao.module.yi.controller.admin.linkpage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 外链网页 Excel VO
 *
 * @author stone
 */
@Data
public class LinkPageExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("主题")
    private String title;

    @ExcelProperty("图片链接")
    private String picUrl;

    @ExcelProperty("网页链接")
    private String linkUrl;

    @ExcelProperty(value = "链接分类", converter = DictConvert.class)
    @DictFormat("link_page_category") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String category;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("展示顺序")
    private Integer sort;

}

package cn.iocoder.yudao.module.yi.controller.admin.productinterest.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 产品认购金额收益 Excel VO
 *
 * @author stone
 */
@Data
public class ProductInterestExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("产品id")
    private Long productId;

    @ExcelProperty("金额大于等于（万）")
    private BigDecimal amountStart;

    @ExcelProperty("金额小于（万）")
    private BigDecimal amountEnd;

    @ExcelProperty("预期收益")
    private BigDecimal interestRate;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}

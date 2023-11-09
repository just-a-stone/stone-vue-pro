package cn.iocoder.yudao.module.yi.dal.dataobject.productinterest;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 产品认购金额收益 DO
 *
 * @author stone
 */
@TableName("yi_product_interest")
@KeySequence("yi_product_interest_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInterestDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 金额大于等于（万）
     */
    private BigDecimal amountStart;
    /**
     * 金额小于（万）
     */
    private BigDecimal amountEnd;
    /**
     * 预期收益
     */
    private BigDecimal interestRate;

}

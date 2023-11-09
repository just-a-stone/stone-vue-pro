package cn.iocoder.yudao.module.yi.dal.dataobject.productlabel;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 产品标签 DO
 *
 * @author stone
 */
@TableName("yi_product_label")
@KeySequence("yi_product_label_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductLabelDO extends BaseDO {

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
     * 标签key
     *
     * 枚举 {@link TODO product_label 对应的类}
     */
    private String labelKey;
    /**
     * 标签value
     */
    private String labelValue;
    /**
     * 排序
     */
    private Integer sort;

}

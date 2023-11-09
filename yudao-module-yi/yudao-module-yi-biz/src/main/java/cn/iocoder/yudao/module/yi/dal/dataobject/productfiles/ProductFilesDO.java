package cn.iocoder.yudao.module.yi.dal.dataobject.productfiles;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 产品资料(文件) DO
 *
 * @author stone
 */
@TableName("yi_product_files")
@KeySequence("yi_product_files_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilesDO extends BaseDO {

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
     * 文件名称
     */
    private String fileName;
    /**
     * 文件链接
     */
    private String fileUrl;
    /**
     * 排序
     */
    private Integer sort;

}

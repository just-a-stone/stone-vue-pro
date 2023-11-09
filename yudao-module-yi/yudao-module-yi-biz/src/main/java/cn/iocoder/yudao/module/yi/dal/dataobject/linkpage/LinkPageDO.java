package cn.iocoder.yudao.module.yi.dal.dataobject.linkpage;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 外链网页 DO
 *
 * @author stone
 */
@TableName("yi_link_page")
@KeySequence("yi_link_page_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkPageDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 主题
     */
    private String title;
    /**
     * 图片链接
     */
    private String picUrl;
    /**
     * 网页链接
     */
    private String linkUrl;
    /**
     * 链接分类
     *
     * 枚举 {@link TODO link_page_category 对应的类}
     */
    private String category;
    /**
     * 展示顺序
     */
    private Integer sort;

}

package cn.iocoder.yudao.module.yi.dal.dataobject.orgs;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 机构 DO
 *
 * @author stone
 */
@TableName("yi_orgs")
@KeySequence("yi_orgs_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrgsDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 机构名称
     */
    private String orgName;
    /**
     * 机构缩略图链接
     */
    private String iconUrl;

}

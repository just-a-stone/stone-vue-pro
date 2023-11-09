package cn.iocoder.yudao.module.yi.dal.dataobject.products;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 产品 DO
 *
 * @author stone
 */
@TableName("yi_products")
@KeySequence("yi_products_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 发行机构ID
     */
    private Long orgId;
    /**
     * 机构名称
     */
    private String orgName;
    /**
     * 机构图标链接
     */
    private String orgIconUrl;
    /**
     * 产品类型
     *
     * 枚举 {@link TODO product_type 对应的类}
     */
    private String productType;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品期限(月)
     */
    private Integer productTermMonth;
    /**
     * 投资领域
     *
     * 枚举 {@link TODO investment_area 对应的类}
     */
    private String investmentArea;
    /**
     * 大小配比
     *
     * 枚举 {@link TODO dxpb 对应的类}
     */
    private String dxpb;
    /**
     * 安全评级
     */
    private BigDecimal securityRate;
    /**
     * 发行进度
     *
     * 枚举 {@link TODO release_status 对应的类}
     */
    private String releaseStatus;
    /**
     * 发行进度更新日期
     */
    private LocalDateTime releaseStatusUpdateAt;
    /**
     * 在售状态
     *
     * 枚举 {@link TODO sale_status 对应的类}
     */
    private String saleStatus;
    /**
     * 募集规模
     */
    private String fundraisingSize;
    /**
     * 付息方式
     *
     * 枚举 {@link TODO interest_payment_method 对应的类}
     */
    private String interestPaymentMethod;
    /**
     * 投资区域-省
     */
    private String investRegionProvince;
    /**
     * 投资区域-市
     */
    private String investRegionCity;
    /**
     * 起售日期
     */
    private LocalDateTime saleStartAt;
    /**
     * 收益类型
     *
     * 枚举 {@link TODO income_type 对应的类}
     */
    private String incomeTye;
    /**
     * 抵/质押率
     */
    private BigDecimal mortgagePledgeRate;
    /**
     * 补充说明
     */
    private String supplementaryNotes;
    /**
     * 融资方
     */
    private String financialInstitution;
    /**
     * 资金用途
     */
    private String howToUse;
    /**
     * 还款来源
     */
    private String repaymentSource;
    /**
     * 风控措施
     */
    private String riskControlMeasures;
    /**
     * 项目亮点
     */
    private String projectHighlights;
    /**
     * 募集账号-名称
     */
    private String raiseAccountName;
    /**
     * 募集账号-开户行
     */
    private String raiseAccountBankName;
    /**
     * 募集账号-账号
     */
    private String raiseAccountNo;
    /**
     * 募集账号-备注
     */
    private String raiseAccountRemark;

}

package cn.iocoder.yudao.module.yi.service.productcustomlabel;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.yi.controller.admin.productcustomlabel.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productcustomlabel.ProductCustomLabelDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 产品自定义标签 Service 接口
 *
 * @author stone
 */
public interface ProductCustomLabelService {

    /**
     * 创建产品自定义标签
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProductCustomLabel(@Valid ProductCustomLabelCreateReqVO createReqVO);

    /**
     * 更新产品自定义标签
     *
     * @param updateReqVO 更新信息
     */
    void updateProductCustomLabel(@Valid ProductCustomLabelUpdateReqVO updateReqVO);

    /**
     * 删除产品自定义标签
     *
     * @param id 编号
     */
    void deleteProductCustomLabel(Long id);

    /**
     * 获得产品自定义标签
     *
     * @param id 编号
     * @return 产品自定义标签
     */
    ProductCustomLabelDO getProductCustomLabel(Long id);

    /**
     * 获得产品自定义标签列表
     *
     * @param ids 编号
     * @return 产品自定义标签列表
     */
    List<ProductCustomLabelDO> getProductCustomLabelList(Collection<Long> ids);

    /**
     * 获得产品自定义标签分页
     *
     * @param pageReqVO 分页查询
     * @return 产品自定义标签分页
     */
    PageResult<ProductCustomLabelDO> getProductCustomLabelPage(ProductCustomLabelPageReqVO pageReqVO);

    /**
     * 获得产品自定义标签列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 产品自定义标签列表
     */
    List<ProductCustomLabelDO> getProductCustomLabelList(ProductCustomLabelExportReqVO exportReqVO);

    List<ProductCustomLabelDO> getProductCustomLabelList(Long productId);
}

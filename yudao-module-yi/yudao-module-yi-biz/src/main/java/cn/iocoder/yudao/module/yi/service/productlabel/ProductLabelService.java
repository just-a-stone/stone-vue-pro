package cn.iocoder.yudao.module.yi.service.productlabel;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.yi.controller.admin.productlabel.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productlabel.ProductLabelDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 产品标签 Service 接口
 *
 * @author stone
 */
public interface ProductLabelService {

    /**
     * 创建产品标签
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProductLabel(@Valid ProductLabelCreateReqVO createReqVO);

    /**
     * 更新产品标签
     *
     * @param updateReqVO 更新信息
     */
    void updateProductLabel(@Valid ProductLabelUpdateReqVO updateReqVO);

    /**
     * 删除产品标签
     *
     * @param id 编号
     */
    void deleteProductLabel(Long id);

    /**
     * 获得产品标签
     *
     * @param id 编号
     * @return 产品标签
     */
    ProductLabelDO getProductLabel(Long id);

    /**
     * 获得产品标签列表
     *
     * @param ids 编号
     * @return 产品标签列表
     */
    List<ProductLabelDO> getProductLabelList(Collection<Long> ids);

    /**
     * 获得产品标签列表
     *
     * @param productId 产品编号
     * @return 产品标签列表
     */
    List<ProductLabelDO> getProductLabelList(Long productId);

    /**
     * 获得产品标签分页
     *
     * @param pageReqVO 分页查询
     * @return 产品标签分页
     */
    PageResult<ProductLabelDO> getProductLabelPage(ProductLabelPageReqVO pageReqVO);

    /**
     * 获得产品标签列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 产品标签列表
     */
    List<ProductLabelDO> getProductLabelList(ProductLabelExportReqVO exportReqVO);

}

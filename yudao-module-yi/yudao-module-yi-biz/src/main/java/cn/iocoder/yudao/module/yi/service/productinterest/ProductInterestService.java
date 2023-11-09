package cn.iocoder.yudao.module.yi.service.productinterest;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.yi.controller.admin.productinterest.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productinterest.ProductInterestDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 产品认购金额收益 Service 接口
 *
 * @author stone
 */
public interface ProductInterestService {

    /**
     * 创建产品认购金额收益
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProductInterest(@Valid ProductInterestCreateReqVO createReqVO);

    /**
     * 更新产品认购金额收益
     *
     * @param updateReqVO 更新信息
     */
    void updateProductInterest(@Valid ProductInterestUpdateReqVO updateReqVO);

    /**
     * 删除产品认购金额收益
     *
     * @param id 编号
     */
    void deleteProductInterest(Long id);

    /**
     * 获得产品认购金额收益
     *
     * @param id 编号
     * @return 产品认购金额收益
     */
    ProductInterestDO getProductInterest(Long id);

    /**
     * 获得产品认购金额收益列表
     *
     * @param ids 编号
     * @return 产品认购金额收益列表
     */
    List<ProductInterestDO> getProductInterestList(Collection<Long> ids);

    /**
     * 获得产品认购金额收益分页
     *
     * @param pageReqVO 分页查询
     * @return 产品认购金额收益分页
     */
    PageResult<ProductInterestDO> getProductInterestPage(ProductInterestPageReqVO pageReqVO);

    /**
     * 获得产品认购金额收益列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 产品认购金额收益列表
     */
    List<ProductInterestDO> getProductInterestList(ProductInterestExportReqVO exportReqVO);

    List<ProductInterestDO> getProductInterestList(Long productId);
}

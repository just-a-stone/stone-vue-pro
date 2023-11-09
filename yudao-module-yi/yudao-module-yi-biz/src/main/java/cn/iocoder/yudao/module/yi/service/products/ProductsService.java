package cn.iocoder.yudao.module.yi.service.products;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.yi.controller.admin.products.vo.*;
import cn.iocoder.yudao.module.yi.controller.app.vo.AppProductsCategoryCountVo;
import cn.iocoder.yudao.module.yi.controller.app.vo.AppProductsListRespVO;
import cn.iocoder.yudao.module.yi.controller.app.vo.AppProductsPageReqVO;
import cn.iocoder.yudao.module.yi.dal.dataobject.products.ProductsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 产品 Service 接口
 *
 * @author stone
 */
public interface ProductsService {

    /**
     * 创建产品
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProducts(@Valid ProductsCreateReqVO createReqVO);

    /**
     * 更新产品
     *
     * @param updateReqVO 更新信息
     */
    void updateProducts(@Valid ProductsUpdateReqVO updateReqVO);

    /**
     * 删除产品
     *
     * @param id 编号
     */
    void deleteProducts(Long id);

    /**
     * 获得产品
     *
     * @param id 编号
     * @return 产品
     */
    ProductsDO getProducts(Long id);

    /**
     * 获得产品列表
     *
     * @param ids 编号
     * @return 产品列表
     */
    List<ProductsDO> getProductsList(Collection<Long> ids);

    /**
     * 获得产品分页
     *
     * @param pageReqVO 分页查询
     * @return 产品分页
     */
    PageResult<ProductsDO> getProductsPage(ProductsPageReqVO pageReqVO);

    /**
     * 获得产品列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 产品列表
     */
    List<ProductsDO> getProductsList(ProductsExportReqVO exportReqVO);

    PageResult<AppProductsListRespVO> getAppProductsPage(AppProductsPageReqVO pageVO);

    List<AppProductsCategoryCountVo> getProductsCategoryCont();
}

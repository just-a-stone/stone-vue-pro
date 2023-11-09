package cn.iocoder.yudao.module.yi.service.productfiles;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.yi.controller.admin.productfiles.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productfiles.ProductFilesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 产品资料(文件) Service 接口
 *
 * @author stone
 */
public interface ProductFilesService {

    /**
     * 创建产品资料(文件)
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProductFiles(@Valid ProductFilesCreateReqVO createReqVO);

    /**
     * 更新产品资料(文件)
     *
     * @param updateReqVO 更新信息
     */
    void updateProductFiles(@Valid ProductFilesUpdateReqVO updateReqVO);

    /**
     * 删除产品资料(文件)
     *
     * @param id 编号
     */
    void deleteProductFiles(Long id);

    /**
     * 获得产品资料(文件)
     *
     * @param id 编号
     * @return 产品资料(文件)
     */
    ProductFilesDO getProductFiles(Long id);

    /**
     * 获得产品资料(文件)列表
     *
     * @param ids 编号
     * @return 产品资料(文件)列表
     */
    List<ProductFilesDO> getProductFilesList(Collection<Long> ids);

    /**
     * 获得产品资料(文件)分页
     *
     * @param pageReqVO 分页查询
     * @return 产品资料(文件)分页
     */
    PageResult<ProductFilesDO> getProductFilesPage(ProductFilesPageReqVO pageReqVO);

    /**
     * 获得产品资料(文件)列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 产品资料(文件)列表
     */
    List<ProductFilesDO> getProductFilesList(ProductFilesExportReqVO exportReqVO);

    List<ProductFilesDO> getProductFilesList(Long productId);
}

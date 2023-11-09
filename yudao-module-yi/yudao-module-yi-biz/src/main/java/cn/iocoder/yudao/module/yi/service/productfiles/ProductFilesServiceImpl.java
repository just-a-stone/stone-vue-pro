package cn.iocoder.yudao.module.yi.service.productfiles;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.yi.controller.admin.productfiles.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productfiles.ProductFilesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.yi.convert.productfiles.ProductFilesConvert;
import cn.iocoder.yudao.module.yi.dal.mysql.productfiles.ProductFilesMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.yi.enums.ErrorCodeConstants.*;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;

/**
 * 产品资料(文件) Service 实现类
 *
 * @author stone
 */
@Service
@Validated
public class ProductFilesServiceImpl implements ProductFilesService {

    @Resource
    private ProductFilesMapper productFilesMapper;

    @Override
    public Long createProductFiles(ProductFilesCreateReqVO createReqVO) {
        // 插入
        ProductFilesDO productFiles = ProductFilesConvert.INSTANCE.convert(createReqVO);
        productFilesMapper.insert(productFiles);
        // 返回
        return productFiles.getId();
    }

    @Override
    public void updateProductFiles(ProductFilesUpdateReqVO updateReqVO) {
        // 校验存在
        validateProductFilesExists(updateReqVO.getId());
        // 更新
        ProductFilesDO updateObj = ProductFilesConvert.INSTANCE.convert(updateReqVO);
        productFilesMapper.updateById(updateObj);
    }

    @Override
    public void deleteProductFiles(Long id) {
        // 校验存在
        validateProductFilesExists(id);
        // 删除
        productFilesMapper.deleteById(id);
    }

    private void validateProductFilesExists(Long id) {
        if (productFilesMapper.selectById(id) == null) {
            throw exception(PRODUCT_FILES_NOT_EXISTS);
        }
    }

    @Override
    public ProductFilesDO getProductFiles(Long id) {
        return productFilesMapper.selectById(id);
    }

    @Override
    public List<ProductFilesDO> getProductFilesList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return ListUtil.empty();
        }
        return productFilesMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ProductFilesDO> getProductFilesPage(ProductFilesPageReqVO pageReqVO) {
        return productFilesMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ProductFilesDO> getProductFilesList(ProductFilesExportReqVO exportReqVO) {
        return productFilesMapper.selectList(exportReqVO);
    }

    @Override
    public List<ProductFilesDO> getProductFilesList(Long productId) {

        return productFilesMapper.queryByProductId(productId);
    }

}

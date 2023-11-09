package cn.iocoder.yudao.module.yi.service.productlabel;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.yi.controller.admin.productlabel.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productlabel.ProductLabelDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.yi.convert.productlabel.ProductLabelConvert;
import cn.iocoder.yudao.module.yi.dal.mysql.productlabel.ProductLabelMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.yi.enums.ErrorCodeConstants.*;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;

/**
 * 产品标签 Service 实现类
 *
 * @author stone
 */
@Service
@Validated
public class ProductLabelServiceImpl implements ProductLabelService {

    @Resource
    private ProductLabelMapper productLabelMapper;

    @Override
    public Long createProductLabel(ProductLabelCreateReqVO createReqVO) {
        // 插入
        ProductLabelDO productLabel = ProductLabelConvert.INSTANCE.convert(createReqVO);
        productLabelMapper.insert(productLabel);
        // 返回
        return productLabel.getId();
    }

    @Override
    public void updateProductLabel(ProductLabelUpdateReqVO updateReqVO) {
        // 校验存在
        validateProductLabelExists(updateReqVO.getId());
        // 更新
        ProductLabelDO updateObj = ProductLabelConvert.INSTANCE.convert(updateReqVO);
        productLabelMapper.updateById(updateObj);
    }

    @Override
    public void deleteProductLabel(Long id) {
        // 校验存在
        validateProductLabelExists(id);
        // 删除
        productLabelMapper.deleteById(id);
    }

    private void validateProductLabelExists(Long id) {
        if (productLabelMapper.selectById(id) == null) {
            throw exception(PRODUCT_LABEL_NOT_EXISTS);
        }
    }

    @Override
    public ProductLabelDO getProductLabel(Long id) {
        return productLabelMapper.selectById(id);
    }

    @Override
    public List<ProductLabelDO> getProductLabelList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return ListUtil.empty();
        }
        return productLabelMapper.selectBatchIds(ids);
    }

    @Override
    public List<ProductLabelDO> getProductLabelList(Long productId) {
        return productLabelMapper.queryByProductId(productId);
    }

    @Override
    public PageResult<ProductLabelDO> getProductLabelPage(ProductLabelPageReqVO pageReqVO) {
        return productLabelMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ProductLabelDO> getProductLabelList(ProductLabelExportReqVO exportReqVO) {
        return productLabelMapper.selectList(exportReqVO);
    }

}

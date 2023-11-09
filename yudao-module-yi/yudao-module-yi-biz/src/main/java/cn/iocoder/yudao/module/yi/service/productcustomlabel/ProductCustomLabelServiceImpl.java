package cn.iocoder.yudao.module.yi.service.productcustomlabel;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.yi.controller.admin.productcustomlabel.vo.ProductCustomLabelCreateReqVO;
import cn.iocoder.yudao.module.yi.controller.admin.productcustomlabel.vo.ProductCustomLabelExportReqVO;
import cn.iocoder.yudao.module.yi.controller.admin.productcustomlabel.vo.ProductCustomLabelPageReqVO;
import cn.iocoder.yudao.module.yi.controller.admin.productcustomlabel.vo.ProductCustomLabelUpdateReqVO;
import cn.iocoder.yudao.module.yi.convert.productcustomlabel.ProductCustomLabelConvert;
import cn.iocoder.yudao.module.yi.dal.dataobject.productcustomlabel.ProductCustomLabelDO;
import cn.iocoder.yudao.module.yi.dal.mysql.productcustomlabel.ProductCustomLabelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.yi.enums.ErrorCodeConstants.PRODUCT_CUSTOM_LABEL_NOT_EXISTS;

/**
 * 产品自定义标签 Service 实现类
 *
 * @author stone
 */
@Service
@Validated
public class ProductCustomLabelServiceImpl implements ProductCustomLabelService {

    @Resource
    private ProductCustomLabelMapper productCustomLabelMapper;

    @Override
    public Long createProductCustomLabel(ProductCustomLabelCreateReqVO createReqVO) {
        // 插入
        ProductCustomLabelDO productCustomLabel = ProductCustomLabelConvert.INSTANCE.convert(createReqVO);
        productCustomLabelMapper.insert(productCustomLabel);
        // 返回
        return productCustomLabel.getId();
    }

    @Override
    public void updateProductCustomLabel(ProductCustomLabelUpdateReqVO updateReqVO) {
        // 校验存在
        validateProductCustomLabelExists(updateReqVO.getId());
        // 更新
        ProductCustomLabelDO updateObj = ProductCustomLabelConvert.INSTANCE.convert(updateReqVO);
        productCustomLabelMapper.updateById(updateObj);
    }

    @Override
    public void deleteProductCustomLabel(Long id) {
        // 校验存在
        validateProductCustomLabelExists(id);
        // 删除
        productCustomLabelMapper.deleteById(id);
    }

    private void validateProductCustomLabelExists(Long id) {
        if (productCustomLabelMapper.selectById(id) == null) {
            throw exception(PRODUCT_CUSTOM_LABEL_NOT_EXISTS);
        }
    }

    @Override
    public ProductCustomLabelDO getProductCustomLabel(Long id) {
        return productCustomLabelMapper.selectById(id);
    }

    @Override
    public List<ProductCustomLabelDO> getProductCustomLabelList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return ListUtil.empty();
        }
        return productCustomLabelMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ProductCustomLabelDO> getProductCustomLabelPage(ProductCustomLabelPageReqVO pageReqVO) {
        return productCustomLabelMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ProductCustomLabelDO> getProductCustomLabelList(ProductCustomLabelExportReqVO exportReqVO) {
        return productCustomLabelMapper.selectList(exportReqVO);
    }

    @Override
    public List<ProductCustomLabelDO> getProductCustomLabelList(Long productId) {

        return productCustomLabelMapper.queryByProductId(productId);
    }

}

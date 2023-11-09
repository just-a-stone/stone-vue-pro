package cn.iocoder.yudao.module.yi.service.productinterest;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.yi.controller.admin.productinterest.vo.ProductInterestCreateReqVO;
import cn.iocoder.yudao.module.yi.controller.admin.productinterest.vo.ProductInterestExportReqVO;
import cn.iocoder.yudao.module.yi.controller.admin.productinterest.vo.ProductInterestPageReqVO;
import cn.iocoder.yudao.module.yi.controller.admin.productinterest.vo.ProductInterestUpdateReqVO;
import cn.iocoder.yudao.module.yi.convert.productinterest.ProductInterestConvert;
import cn.iocoder.yudao.module.yi.dal.dataobject.productinterest.ProductInterestDO;
import cn.iocoder.yudao.module.yi.dal.mysql.productinterest.ProductInterestMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.yi.enums.ErrorCodeConstants.PRODUCT_INTEREST_NOT_EXISTS;

/**
 * 产品认购金额收益 Service 实现类
 *
 * @author stone
 */
@Service
@Validated
public class ProductInterestServiceImpl implements ProductInterestService {

    @Resource
    private ProductInterestMapper productInterestMapper;

    @Override
    public Long createProductInterest(ProductInterestCreateReqVO createReqVO) {
        // 插入
        ProductInterestDO productInterest = ProductInterestConvert.INSTANCE.convert(createReqVO);
        productInterestMapper.insert(productInterest);
        // 返回
        return productInterest.getId();
    }

    @Override
    public void updateProductInterest(ProductInterestUpdateReqVO updateReqVO) {
        // 校验存在
        validateProductInterestExists(updateReqVO.getId());
        // 更新
        ProductInterestDO updateObj = ProductInterestConvert.INSTANCE.convert(updateReqVO);
        productInterestMapper.updateById(updateObj);
    }

    @Override
    public void deleteProductInterest(Long id) {
        // 校验存在
        validateProductInterestExists(id);
        // 删除
        productInterestMapper.deleteById(id);
    }

    private void validateProductInterestExists(Long id) {
        if (productInterestMapper.selectById(id) == null) {
            throw exception(PRODUCT_INTEREST_NOT_EXISTS);
        }
    }

    @Override
    public ProductInterestDO getProductInterest(Long id) {
        return productInterestMapper.selectById(id);
    }

    @Override
    public List<ProductInterestDO> getProductInterestList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return ListUtil.empty();
        }
        return productInterestMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ProductInterestDO> getProductInterestPage(ProductInterestPageReqVO pageReqVO) {
        return productInterestMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ProductInterestDO> getProductInterestList(ProductInterestExportReqVO exportReqVO) {
        return productInterestMapper.selectList(exportReqVO);
    }

    @Override
    public List<ProductInterestDO> getProductInterestList(Long productId) {

        return productInterestMapper.queryByProductId(productId);
    }

}

package cn.iocoder.yudao.module.yi.dal.mysql.productinterest;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.yi.controller.admin.productinterest.vo.ProductInterestExportReqVO;
import cn.iocoder.yudao.module.yi.controller.admin.productinterest.vo.ProductInterestPageReqVO;
import cn.iocoder.yudao.module.yi.dal.dataobject.productinterest.ProductInterestDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 产品认购金额收益 Mapper
 *
 * @author stone
 */
@Mapper
public interface ProductInterestMapper extends BaseMapperX<ProductInterestDO> {

    default PageResult<ProductInterestDO> selectPage(ProductInterestPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductInterestDO>()
                .eqIfPresent(ProductInterestDO::getProductId, reqVO.getProductId())
                .betweenIfPresent(ProductInterestDO::getAmountStart, reqVO.getAmountStart())
                .betweenIfPresent(ProductInterestDO::getAmountEnd, reqVO.getAmountEnd())
                .betweenIfPresent(ProductInterestDO::getInterestRate, reqVO.getInterestRate())
                .betweenIfPresent(ProductInterestDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductInterestDO::getId));
    }

    default List<ProductInterestDO> selectList(ProductInterestExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ProductInterestDO>()
                .eqIfPresent(ProductInterestDO::getProductId, reqVO.getProductId())
                .betweenIfPresent(ProductInterestDO::getAmountStart, reqVO.getAmountStart())
                .betweenIfPresent(ProductInterestDO::getAmountEnd, reqVO.getAmountEnd())
                .betweenIfPresent(ProductInterestDO::getInterestRate, reqVO.getInterestRate())
                .betweenIfPresent(ProductInterestDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductInterestDO::getId));
    }

    default List<ProductInterestDO> queryByProductId(Long productId) {
        return selectList(new LambdaQueryWrapperX<ProductInterestDO>()
                .eqIfPresent(ProductInterestDO::getProductId, productId)
                .orderByAsc(ProductInterestDO::getAmountStart));
    }
}

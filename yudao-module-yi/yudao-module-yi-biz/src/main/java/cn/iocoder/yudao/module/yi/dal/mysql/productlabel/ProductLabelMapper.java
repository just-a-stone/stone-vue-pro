package cn.iocoder.yudao.module.yi.dal.mysql.productlabel;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.yi.dal.dataobject.productlabel.ProductLabelDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.yi.controller.admin.productlabel.vo.*;

/**
 * 产品标签 Mapper
 *
 * @author stone
 */
@Mapper
public interface ProductLabelMapper extends BaseMapperX<ProductLabelDO> {

    default PageResult<ProductLabelDO> selectPage(ProductLabelPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductLabelDO>()
                .eqIfPresent(ProductLabelDO::getProductId, reqVO.getProductId())
                .eqIfPresent(ProductLabelDO::getLabelKey, reqVO.getLabelKey())
                .likeIfPresent(ProductLabelDO::getLabelValue, reqVO.getLabelValue())
                .betweenIfPresent(ProductLabelDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductLabelDO::getId));
    }

    default List<ProductLabelDO> selectList(ProductLabelExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ProductLabelDO>()
                .eqIfPresent(ProductLabelDO::getProductId, reqVO.getProductId())
                .eqIfPresent(ProductLabelDO::getLabelKey, reqVO.getLabelKey())
                .likeIfPresent(ProductLabelDO::getLabelValue, reqVO.getLabelValue())
                .betweenIfPresent(ProductLabelDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductLabelDO::getId));
    }

    default List<ProductLabelDO> queryByProductId(Long productId){
        return selectList(new LambdaQueryWrapperX<ProductLabelDO>()
                .eq(ProductLabelDO::getProductId, productId)
                .orderByAsc(ProductLabelDO::getSort));
    }
}

package cn.iocoder.yudao.module.yi.dal.mysql.productcustomlabel;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.yi.dal.dataobject.productcustomlabel.ProductCustomLabelDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.yi.controller.admin.productcustomlabel.vo.*;

/**
 * 产品自定义标签 Mapper
 *
 * @author stone
 */
@Mapper
public interface ProductCustomLabelMapper extends BaseMapperX<ProductCustomLabelDO> {

    default PageResult<ProductCustomLabelDO> selectPage(ProductCustomLabelPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductCustomLabelDO>()
                .eqIfPresent(ProductCustomLabelDO::getProductId, reqVO.getProductId())
                .betweenIfPresent(ProductCustomLabelDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductCustomLabelDO::getId));
    }

    default List<ProductCustomLabelDO> selectList(ProductCustomLabelExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ProductCustomLabelDO>()
                .eqIfPresent(ProductCustomLabelDO::getProductId, reqVO.getProductId())
                .betweenIfPresent(ProductCustomLabelDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductCustomLabelDO::getId));
    }

    default List<ProductCustomLabelDO> queryByProductId(Long productId){
        return selectList(new LambdaQueryWrapperX<ProductCustomLabelDO>()
                .eqIfPresent(ProductCustomLabelDO::getProductId, productId)
                .orderByAsc(ProductCustomLabelDO::getSort));
    }
}

package cn.iocoder.yudao.module.yi.dal.mysql.productfiles;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.yi.dal.dataobject.productfiles.ProductFilesDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.yi.controller.admin.productfiles.vo.*;

/**
 * 产品资料(文件) Mapper
 *
 * @author stone
 */
@Mapper
public interface ProductFilesMapper extends BaseMapperX<ProductFilesDO> {

    default PageResult<ProductFilesDO> selectPage(ProductFilesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductFilesDO>()
                .eqIfPresent(ProductFilesDO::getProductId, reqVO.getProductId())
                .likeIfPresent(ProductFilesDO::getFileName, reqVO.getFileName())
                .betweenIfPresent(ProductFilesDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductFilesDO::getId));
    }

    default List<ProductFilesDO> selectList(ProductFilesExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ProductFilesDO>()
                .eqIfPresent(ProductFilesDO::getProductId, reqVO.getProductId())
                .likeIfPresent(ProductFilesDO::getFileName, reqVO.getFileName())
                .betweenIfPresent(ProductFilesDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductFilesDO::getId));
    }

    default List<ProductFilesDO> queryByProductId(Long productId){
        return selectList(new LambdaQueryWrapperX<ProductFilesDO>()
                .eqIfPresent(ProductFilesDO::getProductId, productId)
                .orderByAsc(ProductFilesDO::getSort));
    }
}

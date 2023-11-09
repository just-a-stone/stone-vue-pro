package cn.iocoder.yudao.module.yi.dal.mysql.products;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.yi.controller.admin.products.vo.ProductsExportReqVO;
import cn.iocoder.yudao.module.yi.controller.admin.products.vo.ProductsPageReqVO;
import cn.iocoder.yudao.module.yi.controller.app.vo.AppProductsCategoryCountVo;
import cn.iocoder.yudao.module.yi.controller.app.vo.AppProductsListRespVO;
import cn.iocoder.yudao.module.yi.controller.app.vo.AppProductsPageReqVO;
import cn.iocoder.yudao.module.yi.dal.dataobject.products.ProductsDO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品 Mapper
 *
 * @author stone
 */
@Mapper
public interface ProductsMapper extends BaseMapperX<ProductsDO> {

    default PageResult<ProductsDO> selectPage(ProductsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductsDO>()
                .eqIfPresent(ProductsDO::getOrgId, reqVO.getOrgId())
                .likeIfPresent(ProductsDO::getOrgName, reqVO.getOrgName())
                .eqIfPresent(ProductsDO::getProductType, reqVO.getProductType())
                .likeIfPresent(ProductsDO::getProductName, reqVO.getProductName())
                .betweenIfPresent(ProductsDO::getProductTermMonth, reqVO.getProductTermMonth())
                .eqIfPresent(ProductsDO::getInvestmentArea, reqVO.getInvestmentArea())
                .eqIfPresent(ProductsDO::getDxpb, reqVO.getDxpb())
                .betweenIfPresent(ProductsDO::getSecurityRate, reqVO.getSecurityRate())
                .eqIfPresent(ProductsDO::getSaleStatus, reqVO.getSaleStatus())
                .eqIfPresent(ProductsDO::getInterestPaymentMethod, reqVO.getInterestPaymentMethod())
                .eqIfPresent(ProductsDO::getInvestRegionProvince, reqVO.getInvestRegionProvince())
                .eqIfPresent(ProductsDO::getInvestRegionCity, reqVO.getInvestRegionCity())
                .eqIfPresent(ProductsDO::getIncomeTye, reqVO.getIncomeTye())
                .betweenIfPresent(ProductsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductsDO::getId));
    }

    default List<ProductsDO> selectList(ProductsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ProductsDO>()
                .eqIfPresent(ProductsDO::getOrgId, reqVO.getOrgId())
                .likeIfPresent(ProductsDO::getOrgName, reqVO.getOrgName())
                .eqIfPresent(ProductsDO::getProductType, reqVO.getProductType())
                .likeIfPresent(ProductsDO::getProductName, reqVO.getProductName())
                .betweenIfPresent(ProductsDO::getProductTermMonth, reqVO.getProductTermMonth())
                .eqIfPresent(ProductsDO::getInvestmentArea, reqVO.getInvestmentArea())
                .eqIfPresent(ProductsDO::getDxpb, reqVO.getDxpb())
                .betweenIfPresent(ProductsDO::getSecurityRate, reqVO.getSecurityRate())
                .eqIfPresent(ProductsDO::getSaleStatus, reqVO.getSaleStatus())
                .eqIfPresent(ProductsDO::getInterestPaymentMethod, reqVO.getInterestPaymentMethod())
                .eqIfPresent(ProductsDO::getInvestRegionProvince, reqVO.getInvestRegionProvince())
                .eqIfPresent(ProductsDO::getInvestRegionCity, reqVO.getInvestRegionCity())
                .eqIfPresent(ProductsDO::getIncomeTye, reqVO.getIncomeTye())
                .betweenIfPresent(ProductsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductsDO::getId));
    }

    Page<AppProductsListRespVO> queryAppProductsPage(Page<AppProductsListRespVO> page, @Param("reqVo") AppProductsPageReqVO pageVO);

    List<AppProductsCategoryCountVo> getProductsCategoryCont();
}

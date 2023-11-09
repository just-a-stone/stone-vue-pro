package cn.iocoder.yudao.module.yi.convert.products;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.yi.controller.app.vo.ProductDetailRespVO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.yi.controller.admin.products.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.products.ProductsDO;

/**
 * 产品 Convert
 *
 * @author stone
 */
@Mapper
public interface ProductsConvert {

    ProductsConvert INSTANCE = Mappers.getMapper(ProductsConvert.class);

    ProductsDO convert(ProductsCreateReqVO bean);

    ProductsDO convert(ProductsUpdateReqVO bean);

    ProductsRespVO convert(ProductsDO bean);

    @IterableMapping(elementTargetType = ProductsRespVO.class)
    List<ProductsRespVO> convertList(List<ProductsDO> list);

    PageResult<ProductsRespVO> convertPage(PageResult<ProductsDO> page);

    List<ProductsExcelVO> convertList02(List<ProductsDO> list);
    ProductDetailRespVO convertAppProduct(ProductsDO products);
}

package cn.iocoder.yudao.module.yi.convert.productinterest;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.yi.controller.admin.productinterest.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productinterest.ProductInterestDO;

/**
 * 产品认购金额收益 Convert
 *
 * @author stone
 */
@Mapper
public interface ProductInterestConvert {

    ProductInterestConvert INSTANCE = Mappers.getMapper(ProductInterestConvert.class);

    ProductInterestDO convert(ProductInterestCreateReqVO bean);

    ProductInterestDO convert(ProductInterestUpdateReqVO bean);

    ProductInterestRespVO convert(ProductInterestDO bean);

    List<ProductInterestRespVO> convertList(List<ProductInterestDO> list);

    PageResult<ProductInterestRespVO> convertPage(PageResult<ProductInterestDO> page);

    List<ProductInterestExcelVO> convertList02(List<ProductInterestDO> list);

}

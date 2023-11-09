package cn.iocoder.yudao.module.yi.convert.productlabel;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.yi.controller.admin.productlabel.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productlabel.ProductLabelDO;

/**
 * 产品标签 Convert
 *
 * @author stone
 */
@Mapper
public interface ProductLabelConvert {

    ProductLabelConvert INSTANCE = Mappers.getMapper(ProductLabelConvert.class);

    ProductLabelDO convert(ProductLabelCreateReqVO bean);

    ProductLabelDO convert(ProductLabelUpdateReqVO bean);

    ProductLabelRespVO convert(ProductLabelDO bean);

    List<ProductLabelRespVO> convertList(List<ProductLabelDO> list);

    PageResult<ProductLabelRespVO> convertPage(PageResult<ProductLabelDO> page);

    List<ProductLabelExcelVO> convertList02(List<ProductLabelDO> list);

}

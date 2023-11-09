package cn.iocoder.yudao.module.yi.convert.productcustomlabel;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.yi.controller.admin.productcustomlabel.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productcustomlabel.ProductCustomLabelDO;

/**
 * 产品自定义标签 Convert
 *
 * @author stone
 */
@Mapper
public interface ProductCustomLabelConvert {

    ProductCustomLabelConvert INSTANCE = Mappers.getMapper(ProductCustomLabelConvert.class);

    ProductCustomLabelDO convert(ProductCustomLabelCreateReqVO bean);

    ProductCustomLabelDO convert(ProductCustomLabelUpdateReqVO bean);

    ProductCustomLabelRespVO convert(ProductCustomLabelDO bean);

    List<ProductCustomLabelRespVO> convertList(List<ProductCustomLabelDO> list);

    PageResult<ProductCustomLabelRespVO> convertPage(PageResult<ProductCustomLabelDO> page);

    List<ProductCustomLabelExcelVO> convertList02(List<ProductCustomLabelDO> list);

}

package cn.iocoder.yudao.module.yi.convert.productfiles;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.yi.controller.admin.productfiles.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productfiles.ProductFilesDO;

/**
 * 产品资料(文件) Convert
 *
 * @author stone
 */
@Mapper
public interface ProductFilesConvert {

    ProductFilesConvert INSTANCE = Mappers.getMapper(ProductFilesConvert.class);

    ProductFilesDO convert(ProductFilesCreateReqVO bean);

    ProductFilesDO convert(ProductFilesUpdateReqVO bean);

    ProductFilesRespVO convert(ProductFilesDO bean);

    List<ProductFilesRespVO> convertList(List<ProductFilesDO> list);

    PageResult<ProductFilesRespVO> convertPage(PageResult<ProductFilesDO> page);

    List<ProductFilesExcelVO> convertList02(List<ProductFilesDO> list);

}

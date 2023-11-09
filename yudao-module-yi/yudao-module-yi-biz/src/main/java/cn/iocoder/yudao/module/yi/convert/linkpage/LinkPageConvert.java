package cn.iocoder.yudao.module.yi.convert.linkpage;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.yi.controller.admin.linkpage.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.linkpage.LinkPageDO;

/**
 * 外链网页 Convert
 *
 * @author stone
 */
@Mapper
public interface LinkPageConvert {

    LinkPageConvert INSTANCE = Mappers.getMapper(LinkPageConvert.class);

    LinkPageDO convert(LinkPageCreateReqVO bean);

    LinkPageDO convert(LinkPageUpdateReqVO bean);

    LinkPageRespVO convert(LinkPageDO bean);

    List<LinkPageRespVO> convertList(List<LinkPageDO> list);

    PageResult<LinkPageRespVO> convertPage(PageResult<LinkPageDO> page);

    List<LinkPageExcelVO> convertList02(List<LinkPageDO> list);

}

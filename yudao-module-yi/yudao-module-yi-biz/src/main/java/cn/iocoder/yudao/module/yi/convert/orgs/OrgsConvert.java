package cn.iocoder.yudao.module.yi.convert.orgs;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.yi.controller.admin.orgs.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.orgs.OrgsDO;

/**
 * 机构 Convert
 *
 * @author stone
 */
@Mapper
public interface OrgsConvert {

    OrgsConvert INSTANCE = Mappers.getMapper(OrgsConvert.class);

    OrgsDO convert(OrgsCreateReqVO bean);

    OrgsDO convert(OrgsUpdateReqVO bean);

    OrgsRespVO convert(OrgsDO bean);

    List<OrgsRespVO> convertList(List<OrgsDO> list);

    PageResult<OrgsRespVO> convertPage(PageResult<OrgsDO> page);

    List<OrgsExcelVO> convertList02(List<OrgsDO> list);

}

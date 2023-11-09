package cn.iocoder.yudao.module.yi.dal.mysql.orgs;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.yi.dal.dataobject.orgs.OrgsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.yi.controller.admin.orgs.vo.*;

/**
 * 机构 Mapper
 *
 * @author stone
 */
@Mapper
public interface OrgsMapper extends BaseMapperX<OrgsDO> {

    default PageResult<OrgsDO> selectPage(OrgsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<OrgsDO>()
                .likeIfPresent(OrgsDO::getOrgName, reqVO.getOrgName())
                .betweenIfPresent(OrgsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(OrgsDO::getId));
    }

    default List<OrgsDO> selectList(OrgsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<OrgsDO>()
                .likeIfPresent(OrgsDO::getOrgName, reqVO.getOrgName())
                .betweenIfPresent(OrgsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(OrgsDO::getId));
    }

}

package cn.iocoder.yudao.module.yi.dal.mysql.linkpage;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.yi.dal.dataobject.linkpage.LinkPageDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.yi.controller.admin.linkpage.vo.*;

/**
 * 外链网页 Mapper
 *
 * @author stone
 */
@Mapper
public interface LinkPageMapper extends BaseMapperX<LinkPageDO> {

    default PageResult<LinkPageDO> selectPage(LinkPagePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<LinkPageDO>()
                .eqIfPresent(LinkPageDO::getTitle, reqVO.getTitle())
                .eqIfPresent(LinkPageDO::getCategory, reqVO.getCategory())
                .betweenIfPresent(LinkPageDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(LinkPageDO::getId));
    }

    default List<LinkPageDO> selectList(LinkPageExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<LinkPageDO>()
                .eqIfPresent(LinkPageDO::getTitle, reqVO.getTitle())
                .eqIfPresent(LinkPageDO::getCategory, reqVO.getCategory())
                .betweenIfPresent(LinkPageDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(LinkPageDO::getId));
    }

}

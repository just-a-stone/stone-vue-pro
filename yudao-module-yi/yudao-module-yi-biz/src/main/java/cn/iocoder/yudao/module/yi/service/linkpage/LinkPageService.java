package cn.iocoder.yudao.module.yi.service.linkpage;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.yi.controller.admin.linkpage.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.linkpage.LinkPageDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 外链网页 Service 接口
 *
 * @author stone
 */
public interface LinkPageService {

    /**
     * 创建外链网页
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createLinkPage(@Valid LinkPageCreateReqVO createReqVO);

    /**
     * 更新外链网页
     *
     * @param updateReqVO 更新信息
     */
    void updateLinkPage(@Valid LinkPageUpdateReqVO updateReqVO);

    /**
     * 删除外链网页
     *
     * @param id 编号
     */
    void deleteLinkPage(Long id);

    /**
     * 获得外链网页
     *
     * @param id 编号
     * @return 外链网页
     */
    LinkPageDO getLinkPage(Long id);

    /**
     * 获得外链网页列表
     *
     * @param ids 编号
     * @return 外链网页列表
     */
    List<LinkPageDO> getLinkPageList(Collection<Long> ids);

    /**
     * 获得外链网页分页
     *
     * @param pageReqVO 分页查询
     * @return 外链网页分页
     */
    PageResult<LinkPageDO> getLinkPagePage(LinkPagePageReqVO pageReqVO);

    /**
     * 获得外链网页列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 外链网页列表
     */
    List<LinkPageDO> getLinkPageList(LinkPageExportReqVO exportReqVO);

}

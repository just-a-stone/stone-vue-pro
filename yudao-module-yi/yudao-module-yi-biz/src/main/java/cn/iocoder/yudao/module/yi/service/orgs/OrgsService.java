package cn.iocoder.yudao.module.yi.service.orgs;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.yi.controller.admin.orgs.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.orgs.OrgsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 机构 Service 接口
 *
 * @author stone
 */
public interface OrgsService {

    /**
     * 创建机构
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createOrgs(@Valid OrgsCreateReqVO createReqVO);

    /**
     * 更新机构
     *
     * @param updateReqVO 更新信息
     */
    void updateOrgs(@Valid OrgsUpdateReqVO updateReqVO);

    /**
     * 删除机构
     *
     * @param id 编号
     */
    void deleteOrgs(Long id);

    /**
     * 获得机构
     *
     * @param id 编号
     * @return 机构
     */
    OrgsDO getOrgs(Long id);

    /**
     * 获得机构列表
     *
     * @param ids 编号
     * @return 机构列表
     */
    List<OrgsDO> getOrgsList(Collection<Long> ids);

    /**
     * 获得机构分页
     *
     * @param pageReqVO 分页查询
     * @return 机构分页
     */
    PageResult<OrgsDO> getOrgsPage(OrgsPageReqVO pageReqVO);

    /**
     * 获得机构列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 机构列表
     */
    List<OrgsDO> getOrgsList(OrgsExportReqVO exportReqVO);

}

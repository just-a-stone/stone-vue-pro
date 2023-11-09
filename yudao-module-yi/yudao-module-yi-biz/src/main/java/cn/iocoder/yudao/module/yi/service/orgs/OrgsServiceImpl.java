package cn.iocoder.yudao.module.yi.service.orgs;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.yi.controller.admin.orgs.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.orgs.OrgsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.yi.convert.orgs.OrgsConvert;
import cn.iocoder.yudao.module.yi.dal.mysql.orgs.OrgsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.yi.enums.ErrorCodeConstants.*;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;

/**
 * 机构 Service 实现类
 *
 * @author stone
 */
@Service
@Validated
public class OrgsServiceImpl implements OrgsService {

    @Resource
    private OrgsMapper orgsMapper;

    @Override
    public Long createOrgs(OrgsCreateReqVO createReqVO) {
        // 插入
        OrgsDO orgs = OrgsConvert.INSTANCE.convert(createReqVO);
        orgsMapper.insert(orgs);
        // 返回
        return orgs.getId();
    }

    @Override
    public void updateOrgs(OrgsUpdateReqVO updateReqVO) {
        // 校验存在
        validateOrgsExists(updateReqVO.getId());
        // 更新
        OrgsDO updateObj = OrgsConvert.INSTANCE.convert(updateReqVO);
        orgsMapper.updateById(updateObj);
    }

    @Override
    public void deleteOrgs(Long id) {
        // 校验存在
        validateOrgsExists(id);
        // 删除
        orgsMapper.deleteById(id);
    }

    private void validateOrgsExists(Long id) {
        if (orgsMapper.selectById(id) == null) {
            throw exception(ORGS_NOT_EXISTS);
        }
    }

    @Override
    public OrgsDO getOrgs(Long id) {
        return orgsMapper.selectById(id);
    }

    @Override
    public List<OrgsDO> getOrgsList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return ListUtil.empty();
        }
        return orgsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<OrgsDO> getOrgsPage(OrgsPageReqVO pageReqVO) {
        return orgsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<OrgsDO> getOrgsList(OrgsExportReqVO exportReqVO) {
        return orgsMapper.selectList(exportReqVO);
    }

}

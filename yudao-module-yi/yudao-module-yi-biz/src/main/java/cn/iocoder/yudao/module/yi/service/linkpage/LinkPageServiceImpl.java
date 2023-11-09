package cn.iocoder.yudao.module.yi.service.linkpage;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.yi.controller.admin.linkpage.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.linkpage.LinkPageDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.yi.convert.linkpage.LinkPageConvert;
import cn.iocoder.yudao.module.yi.dal.mysql.linkpage.LinkPageMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.yi.enums.ErrorCodeConstants.*;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;

/**
 * 外链网页 Service 实现类
 *
 * @author stone
 */
@Service
@Validated
public class LinkPageServiceImpl implements LinkPageService {

    @Resource
    private LinkPageMapper linkPageMapper;

    @Override
    public Long createLinkPage(LinkPageCreateReqVO createReqVO) {
        // 插入
        LinkPageDO linkPage = LinkPageConvert.INSTANCE.convert(createReqVO);
        linkPageMapper.insert(linkPage);
        // 返回
        return linkPage.getId();
    }

    @Override
    public void updateLinkPage(LinkPageUpdateReqVO updateReqVO) {
        // 校验存在
        validateLinkPageExists(updateReqVO.getId());
        // 更新
        LinkPageDO updateObj = LinkPageConvert.INSTANCE.convert(updateReqVO);
        linkPageMapper.updateById(updateObj);
    }

    @Override
    public void deleteLinkPage(Long id) {
        // 校验存在
        validateLinkPageExists(id);
        // 删除
        linkPageMapper.deleteById(id);
    }

    private void validateLinkPageExists(Long id) {
        if (linkPageMapper.selectById(id) == null) {
            throw exception(LINK_PAGE_NOT_EXISTS);
        }
    }

    @Override
    public LinkPageDO getLinkPage(Long id) {
        return linkPageMapper.selectById(id);
    }

    @Override
    public List<LinkPageDO> getLinkPageList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return ListUtil.empty();
        }
        return linkPageMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<LinkPageDO> getLinkPagePage(LinkPagePageReqVO pageReqVO) {
        return linkPageMapper.selectPage(pageReqVO);
    }

    @Override
    public List<LinkPageDO> getLinkPageList(LinkPageExportReqVO exportReqVO) {
        return linkPageMapper.selectList(exportReqVO);
    }

}

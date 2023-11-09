package cn.iocoder.yudao.module.yi.service.linkpage;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.yi.controller.admin.linkpage.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.linkpage.LinkPageDO;
import cn.iocoder.yudao.module.yi.dal.mysql.linkpage.LinkPageMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.yi.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * {@link LinkPageServiceImpl} 的单元测试类
 *
 * @author stone
 */
@Import(LinkPageServiceImpl.class)
public class LinkPageServiceImplTest extends BaseDbUnitTest {

    @Resource
    private LinkPageServiceImpl linkPageService;

    @Resource
    private LinkPageMapper linkPageMapper;

    @Test
    public void testCreateLinkPage_success() {
        // 准备参数
        LinkPageCreateReqVO reqVO = randomPojo(LinkPageCreateReqVO.class);

        // 调用
        Long linkPageId = linkPageService.createLinkPage(reqVO);
        // 断言
        assertNotNull(linkPageId);
        // 校验记录的属性是否正确
        LinkPageDO linkPage = linkPageMapper.selectById(linkPageId);
        assertPojoEquals(reqVO, linkPage);
    }

    @Test
    public void testUpdateLinkPage_success() {
        // mock 数据
        LinkPageDO dbLinkPage = randomPojo(LinkPageDO.class);
        linkPageMapper.insert(dbLinkPage);// @Sql: 先插入出一条存在的数据
        // 准备参数
        LinkPageUpdateReqVO reqVO = randomPojo(LinkPageUpdateReqVO.class, o -> {
            o.setId(dbLinkPage.getId()); // 设置更新的 ID
        });

        // 调用
        linkPageService.updateLinkPage(reqVO);
        // 校验是否更新正确
        LinkPageDO linkPage = linkPageMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, linkPage);
    }

    @Test
    public void testUpdateLinkPage_notExists() {
        // 准备参数
        LinkPageUpdateReqVO reqVO = randomPojo(LinkPageUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> linkPageService.updateLinkPage(reqVO), LINK_PAGE_NOT_EXISTS);
    }

    @Test
    public void testDeleteLinkPage_success() {
        // mock 数据
        LinkPageDO dbLinkPage = randomPojo(LinkPageDO.class);
        linkPageMapper.insert(dbLinkPage);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbLinkPage.getId();

        // 调用
        linkPageService.deleteLinkPage(id);
       // 校验数据不存在了
       assertNull(linkPageMapper.selectById(id));
    }

    @Test
    public void testDeleteLinkPage_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> linkPageService.deleteLinkPage(id), LINK_PAGE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetLinkPagePage() {
       // mock 数据
       LinkPageDO dbLinkPage = randomPojo(LinkPageDO.class, o -> { // 等会查询到
           o.setTitle(null);
           o.setCategory(null);
           o.setCreateTime(null);
       });
       linkPageMapper.insert(dbLinkPage);
       // 测试 title 不匹配
       linkPageMapper.insert(cloneIgnoreId(dbLinkPage, o -> o.setTitle(null)));
       // 测试 category 不匹配
       linkPageMapper.insert(cloneIgnoreId(dbLinkPage, o -> o.setCategory(null)));
       // 测试 createTime 不匹配
       linkPageMapper.insert(cloneIgnoreId(dbLinkPage, o -> o.setCreateTime(null)));
       // 准备参数
       LinkPagePageReqVO reqVO = new LinkPagePageReqVO();
       reqVO.setTitle(null);
       reqVO.setCategory(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<LinkPageDO> pageResult = linkPageService.getLinkPagePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbLinkPage, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetLinkPageList() {
       // mock 数据
       LinkPageDO dbLinkPage = randomPojo(LinkPageDO.class, o -> { // 等会查询到
           o.setTitle(null);
           o.setCategory(null);
           o.setCreateTime(null);
       });
       linkPageMapper.insert(dbLinkPage);
       // 测试 title 不匹配
       linkPageMapper.insert(cloneIgnoreId(dbLinkPage, o -> o.setTitle(null)));
       // 测试 category 不匹配
       linkPageMapper.insert(cloneIgnoreId(dbLinkPage, o -> o.setCategory(null)));
       // 测试 createTime 不匹配
       linkPageMapper.insert(cloneIgnoreId(dbLinkPage, o -> o.setCreateTime(null)));
       // 准备参数
       LinkPageExportReqVO reqVO = new LinkPageExportReqVO();
       reqVO.setTitle(null);
       reqVO.setCategory(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<LinkPageDO> list = linkPageService.getLinkPageList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbLinkPage, list.get(0));
    }

}

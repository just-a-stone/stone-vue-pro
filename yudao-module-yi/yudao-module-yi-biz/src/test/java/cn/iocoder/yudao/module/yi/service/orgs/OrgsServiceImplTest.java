package cn.iocoder.yudao.module.yi.service.orgs;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.yi.controller.admin.orgs.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.orgs.OrgsDO;
import cn.iocoder.yudao.module.yi.dal.mysql.orgs.OrgsMapper;
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
 * {@link OrgsServiceImpl} 的单元测试类
 *
 * @author stone
 */
@Import(OrgsServiceImpl.class)
public class OrgsServiceImplTest extends BaseDbUnitTest {

    @Resource
    private OrgsServiceImpl orgsService;

    @Resource
    private OrgsMapper orgsMapper;

    @Test
    public void testCreateOrgs_success() {
        // 准备参数
        OrgsCreateReqVO reqVO = randomPojo(OrgsCreateReqVO.class);

        // 调用
        Long orgsId = orgsService.createOrgs(reqVO);
        // 断言
        assertNotNull(orgsId);
        // 校验记录的属性是否正确
        OrgsDO orgs = orgsMapper.selectById(orgsId);
        assertPojoEquals(reqVO, orgs);
    }

    @Test
    public void testUpdateOrgs_success() {
        // mock 数据
        OrgsDO dbOrgs = randomPojo(OrgsDO.class);
        orgsMapper.insert(dbOrgs);// @Sql: 先插入出一条存在的数据
        // 准备参数
        OrgsUpdateReqVO reqVO = randomPojo(OrgsUpdateReqVO.class, o -> {
            o.setId(dbOrgs.getId()); // 设置更新的 ID
        });

        // 调用
        orgsService.updateOrgs(reqVO);
        // 校验是否更新正确
        OrgsDO orgs = orgsMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, orgs);
    }

    @Test
    public void testUpdateOrgs_notExists() {
        // 准备参数
        OrgsUpdateReqVO reqVO = randomPojo(OrgsUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> orgsService.updateOrgs(reqVO), ORGS_NOT_EXISTS);
    }

    @Test
    public void testDeleteOrgs_success() {
        // mock 数据
        OrgsDO dbOrgs = randomPojo(OrgsDO.class);
        orgsMapper.insert(dbOrgs);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbOrgs.getId();

        // 调用
        orgsService.deleteOrgs(id);
       // 校验数据不存在了
       assertNull(orgsMapper.selectById(id));
    }

    @Test
    public void testDeleteOrgs_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> orgsService.deleteOrgs(id), ORGS_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOrgsPage() {
       // mock 数据
       OrgsDO dbOrgs = randomPojo(OrgsDO.class, o -> { // 等会查询到
           o.setOrgName(null);
           o.setCreateTime(null);
       });
       orgsMapper.insert(dbOrgs);
       // 测试 orgName 不匹配
       orgsMapper.insert(cloneIgnoreId(dbOrgs, o -> o.setOrgName(null)));
       // 测试 createTime 不匹配
       orgsMapper.insert(cloneIgnoreId(dbOrgs, o -> o.setCreateTime(null)));
       // 准备参数
       OrgsPageReqVO reqVO = new OrgsPageReqVO();
       reqVO.setOrgName(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<OrgsDO> pageResult = orgsService.getOrgsPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbOrgs, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOrgsList() {
       // mock 数据
       OrgsDO dbOrgs = randomPojo(OrgsDO.class, o -> { // 等会查询到
           o.setOrgName(null);
           o.setCreateTime(null);
       });
       orgsMapper.insert(dbOrgs);
       // 测试 orgName 不匹配
       orgsMapper.insert(cloneIgnoreId(dbOrgs, o -> o.setOrgName(null)));
       // 测试 createTime 不匹配
       orgsMapper.insert(cloneIgnoreId(dbOrgs, o -> o.setCreateTime(null)));
       // 准备参数
       OrgsExportReqVO reqVO = new OrgsExportReqVO();
       reqVO.setOrgName(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<OrgsDO> list = orgsService.getOrgsList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbOrgs, list.get(0));
    }

}

package cn.iocoder.yudao.module.yi.service.productcustomlabel;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.yi.controller.admin.productcustomlabel.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productcustomlabel.ProductCustomLabelDO;
import cn.iocoder.yudao.module.yi.dal.mysql.productcustomlabel.ProductCustomLabelMapper;
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
 * {@link ProductCustomLabelServiceImpl} 的单元测试类
 *
 * @author stone
 */
@Import(ProductCustomLabelServiceImpl.class)
public class ProductCustomLabelServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ProductCustomLabelServiceImpl productCustomLabelService;

    @Resource
    private ProductCustomLabelMapper productCustomLabelMapper;

    @Test
    public void testCreateProductCustomLabel_success() {
        // 准备参数
        ProductCustomLabelCreateReqVO reqVO = randomPojo(ProductCustomLabelCreateReqVO.class);

        // 调用
        Long productCustomLabelId = productCustomLabelService.createProductCustomLabel(reqVO);
        // 断言
        assertNotNull(productCustomLabelId);
        // 校验记录的属性是否正确
        ProductCustomLabelDO productCustomLabel = productCustomLabelMapper.selectById(productCustomLabelId);
        assertPojoEquals(reqVO, productCustomLabel);
    }

    @Test
    public void testUpdateProductCustomLabel_success() {
        // mock 数据
        ProductCustomLabelDO dbProductCustomLabel = randomPojo(ProductCustomLabelDO.class);
        productCustomLabelMapper.insert(dbProductCustomLabel);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ProductCustomLabelUpdateReqVO reqVO = randomPojo(ProductCustomLabelUpdateReqVO.class, o -> {
            o.setId(dbProductCustomLabel.getId()); // 设置更新的 ID
        });

        // 调用
        productCustomLabelService.updateProductCustomLabel(reqVO);
        // 校验是否更新正确
        ProductCustomLabelDO productCustomLabel = productCustomLabelMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, productCustomLabel);
    }

    @Test
    public void testUpdateProductCustomLabel_notExists() {
        // 准备参数
        ProductCustomLabelUpdateReqVO reqVO = randomPojo(ProductCustomLabelUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> productCustomLabelService.updateProductCustomLabel(reqVO), PRODUCT_CUSTOM_LABEL_NOT_EXISTS);
    }

    @Test
    public void testDeleteProductCustomLabel_success() {
        // mock 数据
        ProductCustomLabelDO dbProductCustomLabel = randomPojo(ProductCustomLabelDO.class);
        productCustomLabelMapper.insert(dbProductCustomLabel);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbProductCustomLabel.getId();

        // 调用
        productCustomLabelService.deleteProductCustomLabel(id);
       // 校验数据不存在了
       assertNull(productCustomLabelMapper.selectById(id));
    }

    @Test
    public void testDeleteProductCustomLabel_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> productCustomLabelService.deleteProductCustomLabel(id), PRODUCT_CUSTOM_LABEL_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetProductCustomLabelPage() {
       // mock 数据
       ProductCustomLabelDO dbProductCustomLabel = randomPojo(ProductCustomLabelDO.class, o -> { // 等会查询到
           o.setProductId(null);
           o.setCreateTime(null);
       });
       productCustomLabelMapper.insert(dbProductCustomLabel);
       // 测试 productId 不匹配
       productCustomLabelMapper.insert(cloneIgnoreId(dbProductCustomLabel, o -> o.setProductId(null)));
       // 测试 createTime 不匹配
       productCustomLabelMapper.insert(cloneIgnoreId(dbProductCustomLabel, o -> o.setCreateTime(null)));
       // 准备参数
       ProductCustomLabelPageReqVO reqVO = new ProductCustomLabelPageReqVO();
       reqVO.setProductId(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<ProductCustomLabelDO> pageResult = productCustomLabelService.getProductCustomLabelPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbProductCustomLabel, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetProductCustomLabelList() {
       // mock 数据
       ProductCustomLabelDO dbProductCustomLabel = randomPojo(ProductCustomLabelDO.class, o -> { // 等会查询到
           o.setProductId(null);
           o.setCreateTime(null);
       });
       productCustomLabelMapper.insert(dbProductCustomLabel);
       // 测试 productId 不匹配
       productCustomLabelMapper.insert(cloneIgnoreId(dbProductCustomLabel, o -> o.setProductId(null)));
       // 测试 createTime 不匹配
       productCustomLabelMapper.insert(cloneIgnoreId(dbProductCustomLabel, o -> o.setCreateTime(null)));
       // 准备参数
       ProductCustomLabelExportReqVO reqVO = new ProductCustomLabelExportReqVO();
       reqVO.setProductId(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<ProductCustomLabelDO> list = productCustomLabelService.getProductCustomLabelList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbProductCustomLabel, list.get(0));
    }

}

package cn.iocoder.yudao.module.yi.service.productlabel;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.yi.controller.admin.productlabel.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productlabel.ProductLabelDO;
import cn.iocoder.yudao.module.yi.dal.mysql.productlabel.ProductLabelMapper;
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
 * {@link ProductLabelServiceImpl} 的单元测试类
 *
 * @author stone
 */
@Import(ProductLabelServiceImpl.class)
public class ProductLabelServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ProductLabelServiceImpl productLabelService;

    @Resource
    private ProductLabelMapper productLabelMapper;

    @Test
    public void testCreateProductLabel_success() {
        // 准备参数
        ProductLabelCreateReqVO reqVO = randomPojo(ProductLabelCreateReqVO.class);

        // 调用
        Long productLabelId = productLabelService.createProductLabel(reqVO);
        // 断言
        assertNotNull(productLabelId);
        // 校验记录的属性是否正确
        ProductLabelDO productLabel = productLabelMapper.selectById(productLabelId);
        assertPojoEquals(reqVO, productLabel);
    }

    @Test
    public void testUpdateProductLabel_success() {
        // mock 数据
        ProductLabelDO dbProductLabel = randomPojo(ProductLabelDO.class);
        productLabelMapper.insert(dbProductLabel);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ProductLabelUpdateReqVO reqVO = randomPojo(ProductLabelUpdateReqVO.class, o -> {
            o.setId(dbProductLabel.getId()); // 设置更新的 ID
        });

        // 调用
        productLabelService.updateProductLabel(reqVO);
        // 校验是否更新正确
        ProductLabelDO productLabel = productLabelMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, productLabel);
    }

    @Test
    public void testUpdateProductLabel_notExists() {
        // 准备参数
        ProductLabelUpdateReqVO reqVO = randomPojo(ProductLabelUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> productLabelService.updateProductLabel(reqVO), PRODUCT_LABEL_NOT_EXISTS);
    }

    @Test
    public void testDeleteProductLabel_success() {
        // mock 数据
        ProductLabelDO dbProductLabel = randomPojo(ProductLabelDO.class);
        productLabelMapper.insert(dbProductLabel);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbProductLabel.getId();

        // 调用
        productLabelService.deleteProductLabel(id);
       // 校验数据不存在了
       assertNull(productLabelMapper.selectById(id));
    }

    @Test
    public void testDeleteProductLabel_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> productLabelService.deleteProductLabel(id), PRODUCT_LABEL_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetProductLabelPage() {
       // mock 数据
       ProductLabelDO dbProductLabel = randomPojo(ProductLabelDO.class, o -> { // 等会查询到
           o.setProductId(null);
           o.setLabelKey(null);
           o.setLabelValue(null);
           o.setCreateTime(null);
       });
       productLabelMapper.insert(dbProductLabel);
       // 测试 productId 不匹配
       productLabelMapper.insert(cloneIgnoreId(dbProductLabel, o -> o.setProductId(null)));
       // 测试 labelKey 不匹配
       productLabelMapper.insert(cloneIgnoreId(dbProductLabel, o -> o.setLabelKey(null)));
       // 测试 labelValue 不匹配
       productLabelMapper.insert(cloneIgnoreId(dbProductLabel, o -> o.setLabelValue(null)));
       // 测试 createTime 不匹配
       productLabelMapper.insert(cloneIgnoreId(dbProductLabel, o -> o.setCreateTime(null)));
       // 准备参数
       ProductLabelPageReqVO reqVO = new ProductLabelPageReqVO();
       reqVO.setProductId(null);
       reqVO.setLabelKey(null);
       reqVO.setLabelValue(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<ProductLabelDO> pageResult = productLabelService.getProductLabelPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbProductLabel, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetProductLabelList() {
       // mock 数据
       ProductLabelDO dbProductLabel = randomPojo(ProductLabelDO.class, o -> { // 等会查询到
           o.setProductId(null);
           o.setLabelKey(null);
           o.setLabelValue(null);
           o.setCreateTime(null);
       });
       productLabelMapper.insert(dbProductLabel);
       // 测试 productId 不匹配
       productLabelMapper.insert(cloneIgnoreId(dbProductLabel, o -> o.setProductId(null)));
       // 测试 labelKey 不匹配
       productLabelMapper.insert(cloneIgnoreId(dbProductLabel, o -> o.setLabelKey(null)));
       // 测试 labelValue 不匹配
       productLabelMapper.insert(cloneIgnoreId(dbProductLabel, o -> o.setLabelValue(null)));
       // 测试 createTime 不匹配
       productLabelMapper.insert(cloneIgnoreId(dbProductLabel, o -> o.setCreateTime(null)));
       // 准备参数
       ProductLabelExportReqVO reqVO = new ProductLabelExportReqVO();
       reqVO.setProductId(null);
       reqVO.setLabelKey(null);
       reqVO.setLabelValue(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<ProductLabelDO> list = productLabelService.getProductLabelList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbProductLabel, list.get(0));
    }

}

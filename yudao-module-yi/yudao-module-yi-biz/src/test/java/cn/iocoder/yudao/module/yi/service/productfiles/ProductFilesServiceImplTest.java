package cn.iocoder.yudao.module.yi.service.productfiles;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.yi.controller.admin.productfiles.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productfiles.ProductFilesDO;
import cn.iocoder.yudao.module.yi.dal.mysql.productfiles.ProductFilesMapper;
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
 * {@link ProductFilesServiceImpl} 的单元测试类
 *
 * @author stone
 */
@Import(ProductFilesServiceImpl.class)
public class ProductFilesServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ProductFilesServiceImpl productFilesService;

    @Resource
    private ProductFilesMapper productFilesMapper;

    @Test
    public void testCreateProductFiles_success() {
        // 准备参数
        ProductFilesCreateReqVO reqVO = randomPojo(ProductFilesCreateReqVO.class);

        // 调用
        Long productFilesId = productFilesService.createProductFiles(reqVO);
        // 断言
        assertNotNull(productFilesId);
        // 校验记录的属性是否正确
        ProductFilesDO productFiles = productFilesMapper.selectById(productFilesId);
        assertPojoEquals(reqVO, productFiles);
    }

    @Test
    public void testUpdateProductFiles_success() {
        // mock 数据
        ProductFilesDO dbProductFiles = randomPojo(ProductFilesDO.class);
        productFilesMapper.insert(dbProductFiles);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ProductFilesUpdateReqVO reqVO = randomPojo(ProductFilesUpdateReqVO.class, o -> {
            o.setId(dbProductFiles.getId()); // 设置更新的 ID
        });

        // 调用
        productFilesService.updateProductFiles(reqVO);
        // 校验是否更新正确
        ProductFilesDO productFiles = productFilesMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, productFiles);
    }

    @Test
    public void testUpdateProductFiles_notExists() {
        // 准备参数
        ProductFilesUpdateReqVO reqVO = randomPojo(ProductFilesUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> productFilesService.updateProductFiles(reqVO), PRODUCT_FILES_NOT_EXISTS);
    }

    @Test
    public void testDeleteProductFiles_success() {
        // mock 数据
        ProductFilesDO dbProductFiles = randomPojo(ProductFilesDO.class);
        productFilesMapper.insert(dbProductFiles);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbProductFiles.getId();

        // 调用
        productFilesService.deleteProductFiles(id);
       // 校验数据不存在了
       assertNull(productFilesMapper.selectById(id));
    }

    @Test
    public void testDeleteProductFiles_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> productFilesService.deleteProductFiles(id), PRODUCT_FILES_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetProductFilesPage() {
       // mock 数据
       ProductFilesDO dbProductFiles = randomPojo(ProductFilesDO.class, o -> { // 等会查询到
           o.setProductId(null);
           o.setFileName(null);
           o.setCreateTime(null);
       });
       productFilesMapper.insert(dbProductFiles);
       // 测试 productId 不匹配
       productFilesMapper.insert(cloneIgnoreId(dbProductFiles, o -> o.setProductId(null)));
       // 测试 fileName 不匹配
       productFilesMapper.insert(cloneIgnoreId(dbProductFiles, o -> o.setFileName(null)));
       // 测试 createTime 不匹配
       productFilesMapper.insert(cloneIgnoreId(dbProductFiles, o -> o.setCreateTime(null)));
       // 准备参数
       ProductFilesPageReqVO reqVO = new ProductFilesPageReqVO();
       reqVO.setProductId(null);
       reqVO.setFileName(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<ProductFilesDO> pageResult = productFilesService.getProductFilesPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbProductFiles, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetProductFilesList() {
       // mock 数据
       ProductFilesDO dbProductFiles = randomPojo(ProductFilesDO.class, o -> { // 等会查询到
           o.setProductId(null);
           o.setFileName(null);
           o.setCreateTime(null);
       });
       productFilesMapper.insert(dbProductFiles);
       // 测试 productId 不匹配
       productFilesMapper.insert(cloneIgnoreId(dbProductFiles, o -> o.setProductId(null)));
       // 测试 fileName 不匹配
       productFilesMapper.insert(cloneIgnoreId(dbProductFiles, o -> o.setFileName(null)));
       // 测试 createTime 不匹配
       productFilesMapper.insert(cloneIgnoreId(dbProductFiles, o -> o.setCreateTime(null)));
       // 准备参数
       ProductFilesExportReqVO reqVO = new ProductFilesExportReqVO();
       reqVO.setProductId(null);
       reqVO.setFileName(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<ProductFilesDO> list = productFilesService.getProductFilesList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbProductFiles, list.get(0));
    }

}

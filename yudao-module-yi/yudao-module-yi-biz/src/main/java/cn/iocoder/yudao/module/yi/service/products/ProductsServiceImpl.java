package cn.iocoder.yudao.module.yi.service.products;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.yi.controller.admin.products.vo.ProductsCreateReqVO;
import cn.iocoder.yudao.module.yi.controller.admin.products.vo.ProductsExportReqVO;
import cn.iocoder.yudao.module.yi.controller.admin.products.vo.ProductsPageReqVO;
import cn.iocoder.yudao.module.yi.controller.admin.products.vo.ProductsUpdateReqVO;
import cn.iocoder.yudao.module.yi.controller.app.vo.AppProductsCategoryCountVo;
import cn.iocoder.yudao.module.yi.controller.app.vo.AppProductsListRespVO;
import cn.iocoder.yudao.module.yi.controller.app.vo.AppProductsPageReqVO;
import cn.iocoder.yudao.module.yi.convert.products.ProductsConvert;
import cn.iocoder.yudao.module.yi.dal.dataobject.products.ProductsDO;
import cn.iocoder.yudao.module.yi.dal.mysql.products.ProductsMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.yi.enums.ErrorCodeConstants.PRODUCTS_NOT_EXISTS;

/**
 * 产品 Service 实现类
 *
 * @author stone
 */
@Service
@Validated
public class ProductsServiceImpl implements ProductsService {

    @Resource
    private ProductsMapper productsMapper;

    @Override
    public Long createProducts(ProductsCreateReqVO createReqVO) {
        // 插入
        ProductsDO products = ProductsConvert.INSTANCE.convert(createReqVO);
        productsMapper.insert(products);
        // 返回
        return products.getId();
    }

    @Override
    public void updateProducts(ProductsUpdateReqVO updateReqVO) {
        // 校验存在
        validateProductsExists(updateReqVO.getId());
        // 更新
        ProductsDO updateObj = ProductsConvert.INSTANCE.convert(updateReqVO);
        productsMapper.updateById(updateObj);
    }

    @Override
    public void deleteProducts(Long id) {
        // 校验存在
        validateProductsExists(id);
        // 删除
        productsMapper.deleteById(id);
    }

    private void validateProductsExists(Long id) {
        if (productsMapper.selectById(id) == null) {
            throw exception(PRODUCTS_NOT_EXISTS);
        }
    }

    @Override
    public ProductsDO getProducts(Long id) {
        return productsMapper.selectById(id);
    }

    @Override
    public List<ProductsDO> getProductsList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return ListUtil.empty();
        }
        return productsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ProductsDO> getProductsPage(ProductsPageReqVO pageReqVO) {
        return productsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ProductsDO> getProductsList(ProductsExportReqVO exportReqVO) {
        return productsMapper.selectList(exportReqVO);
    }

    @Override
    public PageResult<AppProductsListRespVO> getAppProductsPage(AppProductsPageReqVO pageVO) {

        Page<AppProductsListRespVO> queryPage = new Page<>(pageVO.getPageNo(), pageVO.getPageSize());
        if (!StringUtils.hasLength(pageVO.getSortField())){
            pageVO.setSortField("update_time");
            pageVO.setSortOrder("desc");
        }
        OrderItem orderItem = new OrderItem();
        orderItem.setColumn(pageVO.getSortField());
        orderItem.setAsc(pageVO.getSortOrder().equals("asc"));
        queryPage.addOrder(orderItem);
        IPage<AppProductsListRespVO> page = productsMapper.queryAppProductsPage(queryPage, pageVO);
        return new PageResult<>(page.getRecords(), page.getTotal());
    }

    @Override
    public List<AppProductsCategoryCountVo> getProductsCategoryCont() {
        return productsMapper.getProductsCategoryCont();
    }

}

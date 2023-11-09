package cn.iocoder.yudao.module.yi.controller.app;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.yi.controller.app.vo.AppProductsCategoryCountVo;
import cn.iocoder.yudao.module.yi.controller.app.vo.AppProductsListRespVO;
import cn.iocoder.yudao.module.yi.controller.app.vo.AppProductsPageReqVO;
import cn.iocoder.yudao.module.yi.controller.app.vo.ProductDetailRespVO;
import cn.iocoder.yudao.module.yi.convert.productcustomlabel.ProductCustomLabelConvert;
import cn.iocoder.yudao.module.yi.convert.productfiles.ProductFilesConvert;
import cn.iocoder.yudao.module.yi.convert.productinterest.ProductInterestConvert;
import cn.iocoder.yudao.module.yi.convert.productlabel.ProductLabelConvert;
import cn.iocoder.yudao.module.yi.convert.products.ProductsConvert;
import cn.iocoder.yudao.module.yi.dal.dataobject.products.ProductsDO;
import cn.iocoder.yudao.module.yi.service.productcustomlabel.ProductCustomLabelService;
import cn.iocoder.yudao.module.yi.service.productfiles.ProductFilesService;
import cn.iocoder.yudao.module.yi.service.productinterest.ProductInterestService;
import cn.iocoder.yudao.module.yi.service.productlabel.ProductLabelService;
import cn.iocoder.yudao.module.yi.service.products.ProductsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "APP - 产品")
@RestController
@RequestMapping("/yi/app/products")
@Validated
public class AppProductController {

    @Resource
    private ProductsService productsService;

    @Resource
    private ProductLabelService productLabelService;

    @Resource
    private ProductInterestService productInterestService;

    @Resource
    private ProductFilesService productFilesService;

    @Resource
    private ProductCustomLabelService productCustomLabelService;

    @GetMapping("/page")
    @Operation(summary = "获得产品分页")
    public CommonResult<PageResult<AppProductsListRespVO>> getProductsPage(@Valid AppProductsPageReqVO pageVO) {
        PageResult<AppProductsListRespVO> pageResult = productsService.getAppProductsPage(pageVO);
        return success(pageResult);
    }

    @GetMapping("/get")
    @Operation(summary = "获得产品详情")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<ProductDetailRespVO> getProducts(@RequestParam("id") Long id) {
        ProductsDO products = productsService.getProducts(id);
        ProductDetailRespVO detailRespVO = ProductsConvert.INSTANCE.convertAppProduct(products);

        detailRespVO.setProductLabels(
                ProductLabelConvert.INSTANCE.convertList(productLabelService.getProductLabelList(detailRespVO.getId())));

        detailRespVO.setProductInterests(
                ProductInterestConvert.INSTANCE.convertList(productInterestService.getProductInterestList(detailRespVO.getId())));

        detailRespVO.setProductCustomLabels(
                ProductCustomLabelConvert.INSTANCE.convertList(productCustomLabelService.getProductCustomLabelList(detailRespVO.getId()))
        );

        detailRespVO.setProductFiles(
                ProductFilesConvert.INSTANCE.convertList(productFilesService.getProductFilesList(detailRespVO.getId()))
        );

        return success(detailRespVO);
    }

    @GetMapping("/category")
    @Operation(summary = "获得分类产品数量统计")
    public CommonResult<List<AppProductsCategoryCountVo>> getProductsCategoryCont() {
        List<AppProductsCategoryCountVo> result = productsService.getProductsCategoryCont();
        return success(result);
    }

}

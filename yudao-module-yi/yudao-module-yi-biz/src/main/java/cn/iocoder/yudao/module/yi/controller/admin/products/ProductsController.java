package cn.iocoder.yudao.module.yi.controller.admin.products;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.yi.controller.admin.products.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.products.ProductsDO;
import cn.iocoder.yudao.module.yi.convert.products.ProductsConvert;
import cn.iocoder.yudao.module.yi.service.products.ProductsService;

@Tag(name = "管理后台 - 产品")
@RestController
@RequestMapping("/yi/products")
@Validated
public class ProductsController {

    @Resource
    private ProductsService productsService;

    @PostMapping("/create")
    @Operation(summary = "创建产品")
    @PreAuthorize("@ss.hasPermission('yi:products:create')")
    public CommonResult<Long> createProducts(@Valid @RequestBody ProductsCreateReqVO createReqVO) {
        return success(productsService.createProducts(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新产品")
    @PreAuthorize("@ss.hasPermission('yi:products:update')")
    public CommonResult<Boolean> updateProducts(@Valid @RequestBody ProductsUpdateReqVO updateReqVO) {
        productsService.updateProducts(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除产品")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('yi:products:delete')")
    public CommonResult<Boolean> deleteProducts(@RequestParam("id") Long id) {
        productsService.deleteProducts(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得产品")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('yi:products:query')")
    public CommonResult<ProductsRespVO> getProducts(@RequestParam("id") Long id) {
        ProductsDO products = productsService.getProducts(id);
        return success(ProductsConvert.INSTANCE.convert(products));
    }

    @GetMapping("/list")
    @Operation(summary = "获得产品列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('yi:products:query')")
    public CommonResult<List<ProductsRespVO>> getProductsList(@RequestParam("ids") Collection<Long> ids) {
        List<ProductsDO> list = productsService.getProductsList(ids);
        return success(ProductsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得产品分页")
    @PreAuthorize("@ss.hasPermission('yi:products:query')")
    public CommonResult<PageResult<ProductsRespVO>> getProductsPage(@Valid ProductsPageReqVO pageVO) {
        PageResult<ProductsDO> pageResult = productsService.getProductsPage(pageVO);
        return success(ProductsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出产品 Excel")
    @PreAuthorize("@ss.hasPermission('yi:products:export')")
    @OperateLog(type = EXPORT)
    public void exportProductsExcel(@Valid ProductsExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ProductsDO> list = productsService.getProductsList(exportReqVO);
        // 导出 Excel
        List<ProductsExcelVO> datas = ProductsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "产品.xls", "数据", ProductsExcelVO.class, datas);
    }

}

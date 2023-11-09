package cn.iocoder.yudao.module.yi.controller.admin.productfiles;

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

import cn.iocoder.yudao.module.yi.controller.admin.productfiles.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productfiles.ProductFilesDO;
import cn.iocoder.yudao.module.yi.convert.productfiles.ProductFilesConvert;
import cn.iocoder.yudao.module.yi.service.productfiles.ProductFilesService;

@Tag(name = "管理后台 - 产品资料(文件)")
@RestController
@RequestMapping("/yi/product-files")
@Validated
public class ProductFilesController {

    @Resource
    private ProductFilesService productFilesService;

    @PostMapping("/create")
    @Operation(summary = "创建产品资料(文件)")
    @PreAuthorize("@ss.hasPermission('yi:product-files:create')")
    public CommonResult<Long> createProductFiles(@Valid @RequestBody ProductFilesCreateReqVO createReqVO) {
        return success(productFilesService.createProductFiles(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新产品资料(文件)")
    @PreAuthorize("@ss.hasPermission('yi:product-files:update')")
    public CommonResult<Boolean> updateProductFiles(@Valid @RequestBody ProductFilesUpdateReqVO updateReqVO) {
        productFilesService.updateProductFiles(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除产品资料(文件)")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('yi:product-files:delete')")
    public CommonResult<Boolean> deleteProductFiles(@RequestParam("id") Long id) {
        productFilesService.deleteProductFiles(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得产品资料(文件)")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('yi:product-files:query')")
    public CommonResult<ProductFilesRespVO> getProductFiles(@RequestParam("id") Long id) {
        ProductFilesDO productFiles = productFilesService.getProductFiles(id);
        return success(ProductFilesConvert.INSTANCE.convert(productFiles));
    }

    @GetMapping("/list")
    @Operation(summary = "获得产品资料(文件)列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('yi:product-files:query')")
    public CommonResult<List<ProductFilesRespVO>> getProductFilesList(@RequestParam("ids") Collection<Long> ids) {
        List<ProductFilesDO> list = productFilesService.getProductFilesList(ids);
        return success(ProductFilesConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得产品资料(文件)分页")
    @PreAuthorize("@ss.hasPermission('yi:product-files:query')")
    public CommonResult<PageResult<ProductFilesRespVO>> getProductFilesPage(@Valid ProductFilesPageReqVO pageVO) {
        PageResult<ProductFilesDO> pageResult = productFilesService.getProductFilesPage(pageVO);
        return success(ProductFilesConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出产品资料(文件) Excel")
    @PreAuthorize("@ss.hasPermission('yi:product-files:export')")
    @OperateLog(type = EXPORT)
    public void exportProductFilesExcel(@Valid ProductFilesExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ProductFilesDO> list = productFilesService.getProductFilesList(exportReqVO);
        // 导出 Excel
        List<ProductFilesExcelVO> datas = ProductFilesConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "产品资料(文件).xls", "数据", ProductFilesExcelVO.class, datas);
    }

}

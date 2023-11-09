package cn.iocoder.yudao.module.yi.controller.admin.productcustomlabel;

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

import cn.iocoder.yudao.module.yi.controller.admin.productcustomlabel.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productcustomlabel.ProductCustomLabelDO;
import cn.iocoder.yudao.module.yi.convert.productcustomlabel.ProductCustomLabelConvert;
import cn.iocoder.yudao.module.yi.service.productcustomlabel.ProductCustomLabelService;

@Tag(name = "管理后台 - 产品自定义标签")
@RestController
@RequestMapping("/yi/product-custom-label")
@Validated
public class ProductCustomLabelController {

    @Resource
    private ProductCustomLabelService productCustomLabelService;

    @PostMapping("/create")
    @Operation(summary = "创建产品自定义标签")
    @PreAuthorize("@ss.hasPermission('yi:product-custom-label:create')")
    public CommonResult<Long> createProductCustomLabel(@Valid @RequestBody ProductCustomLabelCreateReqVO createReqVO) {
        return success(productCustomLabelService.createProductCustomLabel(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新产品自定义标签")
    @PreAuthorize("@ss.hasPermission('yi:product-custom-label:update')")
    public CommonResult<Boolean> updateProductCustomLabel(@Valid @RequestBody ProductCustomLabelUpdateReqVO updateReqVO) {
        productCustomLabelService.updateProductCustomLabel(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除产品自定义标签")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('yi:product-custom-label:delete')")
    public CommonResult<Boolean> deleteProductCustomLabel(@RequestParam("id") Long id) {
        productCustomLabelService.deleteProductCustomLabel(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得产品自定义标签")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('yi:product-custom-label:query')")
    public CommonResult<ProductCustomLabelRespVO> getProductCustomLabel(@RequestParam("id") Long id) {
        ProductCustomLabelDO productCustomLabel = productCustomLabelService.getProductCustomLabel(id);
        return success(ProductCustomLabelConvert.INSTANCE.convert(productCustomLabel));
    }

    @GetMapping("/list")
    @Operation(summary = "获得产品自定义标签列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('yi:product-custom-label:query')")
    public CommonResult<List<ProductCustomLabelRespVO>> getProductCustomLabelList(@RequestParam("ids") Collection<Long> ids) {
        List<ProductCustomLabelDO> list = productCustomLabelService.getProductCustomLabelList(ids);
        return success(ProductCustomLabelConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得产品自定义标签分页")
    @PreAuthorize("@ss.hasPermission('yi:product-custom-label:query')")
    public CommonResult<PageResult<ProductCustomLabelRespVO>> getProductCustomLabelPage(@Valid ProductCustomLabelPageReqVO pageVO) {
        PageResult<ProductCustomLabelDO> pageResult = productCustomLabelService.getProductCustomLabelPage(pageVO);
        return success(ProductCustomLabelConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出产品自定义标签 Excel")
    @PreAuthorize("@ss.hasPermission('yi:product-custom-label:export')")
    @OperateLog(type = EXPORT)
    public void exportProductCustomLabelExcel(@Valid ProductCustomLabelExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ProductCustomLabelDO> list = productCustomLabelService.getProductCustomLabelList(exportReqVO);
        // 导出 Excel
        List<ProductCustomLabelExcelVO> datas = ProductCustomLabelConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "产品自定义标签.xls", "数据", ProductCustomLabelExcelVO.class, datas);
    }

}

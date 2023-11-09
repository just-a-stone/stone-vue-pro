package cn.iocoder.yudao.module.yi.controller.admin.productlabel;

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

import cn.iocoder.yudao.module.yi.controller.admin.productlabel.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productlabel.ProductLabelDO;
import cn.iocoder.yudao.module.yi.convert.productlabel.ProductLabelConvert;
import cn.iocoder.yudao.module.yi.service.productlabel.ProductLabelService;

@Tag(name = "管理后台 - 产品标签")
@RestController
@RequestMapping("/yi/product-label")
@Validated
public class ProductLabelController {

    @Resource
    private ProductLabelService productLabelService;

    @PostMapping("/create")
    @Operation(summary = "创建产品标签")
    @PreAuthorize("@ss.hasPermission('yi:product-label:create')")
    public CommonResult<Long> createProductLabel(@Valid @RequestBody ProductLabelCreateReqVO createReqVO) {
        return success(productLabelService.createProductLabel(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新产品标签")
    @PreAuthorize("@ss.hasPermission('yi:product-label:update')")
    public CommonResult<Boolean> updateProductLabel(@Valid @RequestBody ProductLabelUpdateReqVO updateReqVO) {
        productLabelService.updateProductLabel(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除产品标签")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('yi:product-label:delete')")
    public CommonResult<Boolean> deleteProductLabel(@RequestParam("id") Long id) {
        productLabelService.deleteProductLabel(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得产品标签")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('yi:product-label:query')")
    public CommonResult<ProductLabelRespVO> getProductLabel(@RequestParam("id") Long id) {
        ProductLabelDO productLabel = productLabelService.getProductLabel(id);
        return success(ProductLabelConvert.INSTANCE.convert(productLabel));
    }

    @GetMapping("/list")
    @Operation(summary = "获得产品标签列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('yi:product-label:query')")
    public CommonResult<List<ProductLabelRespVO>> getProductLabelList(@RequestParam("ids") Collection<Long> ids) {
        List<ProductLabelDO> list = productLabelService.getProductLabelList(ids);
        return success(ProductLabelConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得产品标签分页")
    @PreAuthorize("@ss.hasPermission('yi:product-label:query')")
    public CommonResult<PageResult<ProductLabelRespVO>> getProductLabelPage(@Valid ProductLabelPageReqVO pageVO) {
        PageResult<ProductLabelDO> pageResult = productLabelService.getProductLabelPage(pageVO);
        return success(ProductLabelConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出产品标签 Excel")
    @PreAuthorize("@ss.hasPermission('yi:product-label:export')")
    @OperateLog(type = EXPORT)
    public void exportProductLabelExcel(@Valid ProductLabelExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ProductLabelDO> list = productLabelService.getProductLabelList(exportReqVO);
        // 导出 Excel
        List<ProductLabelExcelVO> datas = ProductLabelConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "产品标签.xls", "数据", ProductLabelExcelVO.class, datas);
    }

}

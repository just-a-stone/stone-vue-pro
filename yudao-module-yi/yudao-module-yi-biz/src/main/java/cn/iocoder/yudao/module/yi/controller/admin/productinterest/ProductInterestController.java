package cn.iocoder.yudao.module.yi.controller.admin.productinterest;

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

import cn.iocoder.yudao.module.yi.controller.admin.productinterest.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.productinterest.ProductInterestDO;
import cn.iocoder.yudao.module.yi.convert.productinterest.ProductInterestConvert;
import cn.iocoder.yudao.module.yi.service.productinterest.ProductInterestService;

@Tag(name = "管理后台 - 产品认购金额收益")
@RestController
@RequestMapping("/yi/product-interest")
@Validated
public class ProductInterestController {

    @Resource
    private ProductInterestService productInterestService;

    @PostMapping("/create")
    @Operation(summary = "创建产品认购金额收益")
    @PreAuthorize("@ss.hasPermission('yi:product-interest:create')")
    public CommonResult<Long> createProductInterest(@Valid @RequestBody ProductInterestCreateReqVO createReqVO) {
        return success(productInterestService.createProductInterest(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新产品认购金额收益")
    @PreAuthorize("@ss.hasPermission('yi:product-interest:update')")
    public CommonResult<Boolean> updateProductInterest(@Valid @RequestBody ProductInterestUpdateReqVO updateReqVO) {
        productInterestService.updateProductInterest(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除产品认购金额收益")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('yi:product-interest:delete')")
    public CommonResult<Boolean> deleteProductInterest(@RequestParam("id") Long id) {
        productInterestService.deleteProductInterest(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得产品认购金额收益")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('yi:product-interest:query')")
    public CommonResult<ProductInterestRespVO> getProductInterest(@RequestParam("id") Long id) {
        ProductInterestDO productInterest = productInterestService.getProductInterest(id);
        return success(ProductInterestConvert.INSTANCE.convert(productInterest));
    }

    @GetMapping("/list")
    @Operation(summary = "获得产品认购金额收益列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('yi:product-interest:query')")
    public CommonResult<List<ProductInterestRespVO>> getProductInterestList(@RequestParam("ids") Collection<Long> ids) {
        List<ProductInterestDO> list = productInterestService.getProductInterestList(ids);
        return success(ProductInterestConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得产品认购金额收益分页")
    @PreAuthorize("@ss.hasPermission('yi:product-interest:query')")
    public CommonResult<PageResult<ProductInterestRespVO>> getProductInterestPage(@Valid ProductInterestPageReqVO pageVO) {
        PageResult<ProductInterestDO> pageResult = productInterestService.getProductInterestPage(pageVO);
        return success(ProductInterestConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出产品认购金额收益 Excel")
    @PreAuthorize("@ss.hasPermission('yi:product-interest:export')")
    @OperateLog(type = EXPORT)
    public void exportProductInterestExcel(@Valid ProductInterestExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ProductInterestDO> list = productInterestService.getProductInterestList(exportReqVO);
        // 导出 Excel
        List<ProductInterestExcelVO> datas = ProductInterestConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "产品认购金额收益.xls", "数据", ProductInterestExcelVO.class, datas);
    }

}

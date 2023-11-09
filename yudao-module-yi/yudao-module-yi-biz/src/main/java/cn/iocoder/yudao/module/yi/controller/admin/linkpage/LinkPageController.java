package cn.iocoder.yudao.module.yi.controller.admin.linkpage;

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

import cn.iocoder.yudao.module.yi.controller.admin.linkpage.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.linkpage.LinkPageDO;
import cn.iocoder.yudao.module.yi.convert.linkpage.LinkPageConvert;
import cn.iocoder.yudao.module.yi.service.linkpage.LinkPageService;

@Tag(name = "管理后台 - 外链网页")
@RestController
@RequestMapping("/yi/link-page")
@Validated
public class LinkPageController {

    @Resource
    private LinkPageService linkPageService;

    @PostMapping("/create")
    @Operation(summary = "创建外链网页")
    @PreAuthorize("@ss.hasPermission('yi:link-page:create')")
    public CommonResult<Long> createLinkPage(@Valid @RequestBody LinkPageCreateReqVO createReqVO) {
        return success(linkPageService.createLinkPage(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新外链网页")
    @PreAuthorize("@ss.hasPermission('yi:link-page:update')")
    public CommonResult<Boolean> updateLinkPage(@Valid @RequestBody LinkPageUpdateReqVO updateReqVO) {
        linkPageService.updateLinkPage(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除外链网页")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('yi:link-page:delete')")
    public CommonResult<Boolean> deleteLinkPage(@RequestParam("id") Long id) {
        linkPageService.deleteLinkPage(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得外链网页")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('yi:link-page:query')")
    public CommonResult<LinkPageRespVO> getLinkPage(@RequestParam("id") Long id) {
        LinkPageDO linkPage = linkPageService.getLinkPage(id);
        return success(LinkPageConvert.INSTANCE.convert(linkPage));
    }

    @GetMapping("/list")
    @Operation(summary = "获得外链网页列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('yi:link-page:query')")
    public CommonResult<List<LinkPageRespVO>> getLinkPageList(@RequestParam("ids") Collection<Long> ids) {
        List<LinkPageDO> list = linkPageService.getLinkPageList(ids);
        return success(LinkPageConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得外链网页分页")
    @PreAuthorize("@ss.hasPermission('yi:link-page:query')")
    public CommonResult<PageResult<LinkPageRespVO>> getLinkPagePage(@Valid LinkPagePageReqVO pageVO) {
        PageResult<LinkPageDO> pageResult = linkPageService.getLinkPagePage(pageVO);
        return success(LinkPageConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出外链网页 Excel")
    @PreAuthorize("@ss.hasPermission('yi:link-page:export')")
    @OperateLog(type = EXPORT)
    public void exportLinkPageExcel(@Valid LinkPageExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<LinkPageDO> list = linkPageService.getLinkPageList(exportReqVO);
        // 导出 Excel
        List<LinkPageExcelVO> datas = LinkPageConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "外链网页.xls", "数据", LinkPageExcelVO.class, datas);
    }

}

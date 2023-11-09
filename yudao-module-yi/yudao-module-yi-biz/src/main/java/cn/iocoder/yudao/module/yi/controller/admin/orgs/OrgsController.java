package cn.iocoder.yudao.module.yi.controller.admin.orgs;

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

import cn.iocoder.yudao.module.yi.controller.admin.orgs.vo.*;
import cn.iocoder.yudao.module.yi.dal.dataobject.orgs.OrgsDO;
import cn.iocoder.yudao.module.yi.convert.orgs.OrgsConvert;
import cn.iocoder.yudao.module.yi.service.orgs.OrgsService;

@Tag(name = "管理后台 - 机构")
@RestController
@RequestMapping("/yi/orgs")
@Validated
public class OrgsController {

    @Resource
    private OrgsService orgsService;

    @PostMapping("/create")
    @Operation(summary = "创建机构")
    @PreAuthorize("@ss.hasPermission('yi:orgs:create')")
    public CommonResult<Long> createOrgs(@Valid @RequestBody OrgsCreateReqVO createReqVO) {
        return success(orgsService.createOrgs(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新机构")
    @PreAuthorize("@ss.hasPermission('yi:orgs:update')")
    public CommonResult<Boolean> updateOrgs(@Valid @RequestBody OrgsUpdateReqVO updateReqVO) {
        orgsService.updateOrgs(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除机构")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('yi:orgs:delete')")
    public CommonResult<Boolean> deleteOrgs(@RequestParam("id") Long id) {
        orgsService.deleteOrgs(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得机构")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('yi:orgs:query')")
    public CommonResult<OrgsRespVO> getOrgs(@RequestParam("id") Long id) {
        OrgsDO orgs = orgsService.getOrgs(id);
        return success(OrgsConvert.INSTANCE.convert(orgs));
    }

    @GetMapping("/list")
    @Operation(summary = "获得机构列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('yi:orgs:query')")
    public CommonResult<List<OrgsRespVO>> getOrgsList(@RequestParam("ids") Collection<Long> ids) {
        List<OrgsDO> list = orgsService.getOrgsList(ids);
        return success(OrgsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得机构分页")
    @PreAuthorize("@ss.hasPermission('yi:orgs:query')")
    public CommonResult<PageResult<OrgsRespVO>> getOrgsPage(@Valid OrgsPageReqVO pageVO) {
        PageResult<OrgsDO> pageResult = orgsService.getOrgsPage(pageVO);
        return success(OrgsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出机构 Excel")
    @PreAuthorize("@ss.hasPermission('yi:orgs:export')")
    @OperateLog(type = EXPORT)
    public void exportOrgsExcel(@Valid OrgsExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<OrgsDO> list = orgsService.getOrgsList(exportReqVO);
        // 导出 Excel
        List<OrgsExcelVO> datas = OrgsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "机构.xls", "数据", OrgsExcelVO.class, datas);
    }

}

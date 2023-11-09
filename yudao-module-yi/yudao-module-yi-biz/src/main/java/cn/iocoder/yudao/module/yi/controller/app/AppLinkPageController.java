package cn.iocoder.yudao.module.yi.controller.app;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.yi.controller.admin.linkpage.vo.LinkPagePageReqVO;
import cn.iocoder.yudao.module.yi.controller.admin.linkpage.vo.LinkPageRespVO;
import cn.iocoder.yudao.module.yi.convert.linkpage.LinkPageConvert;
import cn.iocoder.yudao.module.yi.dal.dataobject.linkpage.LinkPageDO;
import cn.iocoder.yudao.module.yi.service.linkpage.LinkPageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "APP - 外链网页")
@RestController
@RequestMapping("/yi/app/link-page")
@Validated
public class AppLinkPageController {

    @Resource
    private LinkPageService linkPageService;


    @GetMapping("/page")
    @Operation(summary = "获得外链网页分页")
    public CommonResult<PageResult<LinkPageRespVO>> getLinkPagePage(@Valid LinkPagePageReqVO pageVO) {
        PageResult<LinkPageDO> pageResult = linkPageService.getLinkPagePage(pageVO);
        return success(LinkPageConvert.INSTANCE.convertPage(pageResult));
    }

}

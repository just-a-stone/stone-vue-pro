package cn.iocoder.yudao.module.yi.controller.admin.linkpage.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 外链网页创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LinkPageCreateReqVO extends LinkPageBaseVO {

}

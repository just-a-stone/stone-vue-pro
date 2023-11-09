package cn.iocoder.yudao.module.yi.controller.admin.productfiles.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 产品资料(文件)创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductFilesCreateReqVO extends ProductFilesBaseVO {

}

package cn.iocoder.yudao.module.yi.controller.admin.productcustomlabel.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 产品自定义标签创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductCustomLabelCreateReqVO extends ProductCustomLabelBaseVO {

}

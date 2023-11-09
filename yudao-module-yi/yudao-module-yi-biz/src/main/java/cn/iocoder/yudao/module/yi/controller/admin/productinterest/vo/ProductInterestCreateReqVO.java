package cn.iocoder.yudao.module.yi.controller.admin.productinterest.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 产品认购金额收益创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductInterestCreateReqVO extends ProductInterestBaseVO {

}

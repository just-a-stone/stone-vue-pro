package cn.iocoder.yudao.module.yi.controller.app.vo;

import cn.iocoder.yudao.module.yi.controller.admin.productcustomlabel.vo.ProductCustomLabelRespVO;
import cn.iocoder.yudao.module.yi.controller.admin.productfiles.vo.ProductFilesRespVO;
import cn.iocoder.yudao.module.yi.controller.admin.productinterest.vo.ProductInterestRespVO;
import cn.iocoder.yudao.module.yi.controller.admin.productlabel.vo.ProductLabelRespVO;
import cn.iocoder.yudao.module.yi.controller.admin.products.vo.ProductsRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "APP - 产品 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductDetailRespVO extends ProductsRespVO {

    private List<ProductLabelRespVO> productLabels;

    private List<ProductCustomLabelRespVO> productCustomLabels;

    private List<ProductInterestRespVO> productInterests;

    private List<ProductFilesRespVO> productFiles;

}

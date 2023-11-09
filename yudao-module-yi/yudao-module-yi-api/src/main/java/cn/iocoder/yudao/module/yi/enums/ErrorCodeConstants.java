package cn.iocoder.yudao.module.yi.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public class ErrorCodeConstants {

    public static ErrorCode PRODUCT_CUSTOM_LABEL_NOT_EXISTS = new ErrorCode(310001, "产品自定义标签不存在");
    public static ErrorCode PRODUCT_FILES_NOT_EXISTS = new ErrorCode(310002, "产品资料(文件)不存在");

    public static ErrorCode PRODUCT_INTEREST_NOT_EXISTS = new ErrorCode(310003, "产品认购金额收益不存在");

    public static ErrorCode PRODUCT_LABEL_NOT_EXISTS = new ErrorCode(310004, "产品标签不存在");

    public static ErrorCode PRODUCTS_NOT_EXISTS = new ErrorCode(310005, "产品不存在");

    public static ErrorCode LINK_PAGE_NOT_EXISTS = new ErrorCode(310006, "外链网页不存在");

    public static ErrorCode ORGS_NOT_EXISTS = new ErrorCode(310007, "机构不存在");
}


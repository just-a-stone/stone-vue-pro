DROP TABLE IF EXISTS yi_products;
CREATE TABLE yi_products(
                            `id` bigint NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
                            `org_id` bigint NOT NULL   COMMENT '发行机构ID' ,
                            `org_name` varchar(255) NOT NULL   COMMENT '机构名称' ,
                            `org_icon_url` varchar(255) NOT NULL   COMMENT '机构图标链接' ,
                            `product_type` varchar(32)    COMMENT '产品类型' ,
                            `product_name` varchar(255)    COMMENT '产品名称' ,
                            `product_term_month` int    COMMENT '产品期限(月)' ,
                            `investment_area` varchar(255)    COMMENT '投资领域' ,
                            `dxpb` varchar(32)    COMMENT '大小配比' ,
                            `security_rate` decimal(24,6)    COMMENT '安全评级' ,
                            `release_status` varchar(32)    COMMENT '发行进度' ,
                            `release_status_update_at` datetime    COMMENT '发行进度更新日期' ,
                            `sale_status` varchar(32)    COMMENT '在售状态' ,
                            `fundraising_size` varchar(255)    COMMENT '募集规模' ,
                            `interest_payment_method` varchar(32)    COMMENT '付息方式' ,
                            `invest_region_province` varchar(32)    COMMENT '投资区域-省' ,
                            `invest_region_city` varchar(32)    COMMENT '投资区域-市' ,
                            `sale_start_at` datetime    COMMENT '起售日期' ,
                            `income_tye` varchar(32)    COMMENT '收益类型' ,
                            `mortgage_pledge_rate` decimal(24,6)    COMMENT '抵/质押率' ,
                            `supplementary_notes` varchar(900)    COMMENT '补充说明' ,
                            `financial_institution` varchar(900)    COMMENT '融资方' ,
                            `how_to_use` varchar(900)    COMMENT '资金用途' ,
                            `repayment_source` varchar(900)    COMMENT '还款来源' ,
                            `risk_control_measures` varchar(900)    COMMENT '风控措施' ,
                            `project_highlights` varchar(900)    COMMENT '项目亮点' ,
                            `raise_account_name` varchar(255)    COMMENT '募集账号-名称' ,
                            `raise_account_bank_name` varchar(255)    COMMENT '募集账号-开户行' ,
                            `raise_account_no` varchar(255)    COMMENT '募集账号-账号' ,
                            `raise_account_remark` varchar(900)    COMMENT '募集账号-备注' ,
                            `creator` VARCHAR(64)    COMMENT '创建者' ,
                            `create_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
                            `updater` VARCHAR(64)    COMMENT '更新者' ,
                            `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间' ,
                            `deleted` BIT(1) NOT NULL  DEFAULT b'0' COMMENT '是否删除' ,
                            PRIMARY KEY (id)
)  COMMENT = '产品表';


CREATE INDEX idx_product_type ON yi_products(product_type);
CREATE INDEX idx_product_months ON yi_products(product_term_month);

DROP TABLE IF EXISTS yi_orgs;
CREATE TABLE yi_orgs(
                        `id` bigint NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
                        `org_name` varchar(255)    COMMENT '机构名称' ,
                        `icon_url` varchar(255)    COMMENT '机构缩略图链接' ,
                        `creator` VARCHAR(64)    COMMENT '创建者' ,
                        `create_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
                        `updater` VARCHAR(64)    COMMENT '更新者' ,
                        `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间' ,
                        `deleted` BIT(1) NOT NULL  DEFAULT b'0' COMMENT '是否删除' ,
                        PRIMARY KEY (id)
)  COMMENT = '机构表';

DROP TABLE IF EXISTS yi_product_files;
CREATE TABLE yi_product_files(
                                 `id` bigint NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
                                 `product_id` bigint NOT NULL   COMMENT '产品id' ,
                                 `file_name` varchar(255) NOT NULL   COMMENT '文件名称' ,
                                 `file_url` varchar(255) NOT NULL   COMMENT '文件链接' ,
                                 `order` int    COMMENT '排序' ,
                                 `creator` VARCHAR(64)    COMMENT '创建者' ,
                                 `create_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
                                 `updater` VARCHAR(64)    COMMENT '更新者' ,
                                 `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间' ,
                                 `deleted` BIT(1) NOT NULL  DEFAULT b'0' COMMENT '是否删除' ,
                                 PRIMARY KEY (id)
)  COMMENT = '产品资料(文件)';


CREATE INDEX idx_product_id ON yi_product_files(product_id);

DROP TABLE IF EXISTS yi_product_label;
CREATE TABLE yi_product_label(
                                 `id` bigint NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
                                 `product_id` bigint NOT NULL   COMMENT '产品id' ,
                                 `label_key` VARCHAR(16) NOT NULL   COMMENT '标签key' ,
                                 `label_value` VARCHAR(16) NOT NULL   COMMENT '标签value' ,
                                 `order` INT    COMMENT '排序' ,
                                 `creator` VARCHAR(64)    COMMENT '创建者' ,
                                 `create_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
                                 `updater` VARCHAR(64)    COMMENT '更新者' ,
                                 `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间' ,
                                 `deleted` BIT(1) NOT NULL  DEFAULT b'0' COMMENT '是否删除' ,
                                 PRIMARY KEY (id)
)  COMMENT = '产品标签';


CREATE INDEX idx_product_id ON yi_product_label(product_id);

DROP TABLE IF EXISTS yi_product_custom_label;
CREATE TABLE yi_product_custom_label(
                                        `id` bigint NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
                                        `product_id` bigint NOT NULL   COMMENT '产品id' ,
                                        `label_value` VARCHAR(16) NOT NULL   COMMENT '标签value' ,
                                        `order` int    COMMENT '排序' ,
                                        `creator` VARCHAR(64)    COMMENT '创建者' ,
                                        `create_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
                                        `updater` VARCHAR(64)    COMMENT '更新者' ,
                                        `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间' ,
                                        `deleted` BIT(1) NOT NULL  DEFAULT b'0' COMMENT '是否删除' ,
                                        PRIMARY KEY (id)
)  COMMENT = '产品自定义标签';


CREATE INDEX idx_product_id ON yi_product_custom_label(product_id);

DROP TABLE IF EXISTS yi_product_interest;
CREATE TABLE yi_product_interest(
                                    `id` bigint NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
                                    `product_id` bigint NOT NULL   COMMENT '产品id' ,
                                    `amount_start` DECIMAL(24,6) NOT NULL   COMMENT '金额大于等于（万）' ,
                                    `amount_end` DECIMAL(24,6) NOT NULL   COMMENT '金额小于（万）' ,
                                    `interest_rate` DECIMAL(24,6) NOT NULL   COMMENT '预期收益' ,
                                    `creator` VARCHAR(64)    COMMENT '创建者' ,
                                    `create_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
                                    `updater` VARCHAR(64)    COMMENT '更新者' ,
                                    `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间' ,
                                    `deleted` BIT(1) NOT NULL  DEFAULT b'0' COMMENT '是否删除' ,
                                    PRIMARY KEY (id)
)  COMMENT = '产品认购金额收益表';


CREATE INDEX idx_product_id ON yi_product_interest(product_id);

DROP TABLE IF EXISTS yi_link_page;
CREATE TABLE yi_link_page(
                             `id` BIGINT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
                             `title` VARCHAR(64) NOT NULL   COMMENT '主题' ,
                             `pic_url` VARCHAR(255) NOT NULL   COMMENT '图片链接' ,
                             `link_url` varchar(255)    COMMENT '网页链接' ,
                             `order` int   DEFAULT 0 COMMENT '展示顺序' ,
                             `category` varchar(32) NOT NULL   COMMENT '链接分类' ,
                             `creator` VARCHAR(64)    COMMENT '创建人' ,
                             `create_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
                             `updater` VARCHAR(64)    COMMENT '更新人' ,
                             `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间' ,
                             `deleted` BIT(1) NOT NULL  DEFAULT b'0' COMMENT '是否已删除' ,
                             PRIMARY KEY (id)
)  COMMENT = '外链网页';


CREATE INDEX idx_category ON yi_link_page(category);


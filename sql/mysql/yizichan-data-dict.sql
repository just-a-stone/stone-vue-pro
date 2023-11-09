/* 插入字典总表[product_type-产品类型] */
INSERT INTO system_dict_type(type,name,remark) VALUES('product_type','产品类型','');
/* 插入字典明细表 */
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('product_type','xintuo','信托产品','1','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('product_type','chengtou','城投融资','2','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('product_type','biaozhai','标债资管','3','');

/* 插入字典总表[dxpb-大小配比] */
INSERT INTO system_dict_type(type,name,remark) VALUES('dxpb','大小配比','');
/* 插入字典明细表 */
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('dxpb','xecd','小额畅打','1','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('dxpb','ypcxe','已配出小额','2','');

/* 插入字典总表[release_status-发行进度] */
INSERT INTO system_dict_type(type,name,remark) VALUES('release_status','发行进度','');
/* 插入字典明细表 */
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('release_status','fund_in','进款中','1','');

/* 插入字典总表[sale_status-在售状态] */
INSERT INTO system_dict_type(type,name,remark) VALUES('sale_status','在售状态','');
/* 插入字典明细表 */
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('sale_status','on_sale','在售','1','');

/* 插入字典总表[interest_payment_method-付息方式] */
INSERT INTO system_dict_type(type,name,remark) VALUES('interest_payment_method','付息方式','');
/* 插入字典明细表 */
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('interest_payment_method','month','按月付息','1','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('interest_payment_method','season','按季付息','2','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('interest_payment_method','halth_year','半年付息','3','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('interest_payment_method','year','按年付息','4','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('interest_payment_method','end','到期付息','5','');

/* 插入字典总表[income_type-收益类型] */
INSERT INTO system_dict_type(type,name,remark) VALUES('income_type','收益类型','');
/* 插入字典明细表 */
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('income_type','non_guaranteed_fixed_income','非保本固定收益','1','');

/* 插入字典总表[product_label-产品标签] */
INSERT INTO system_dict_type(type,name,remark) VALUES('product_label','产品标签','');
/* 插入字典明细表 */
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('product_label','AA','AA主体','1','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('product_label','mortage','有抵押物','2','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('product_label','city_platform','市级平台','3','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('product_label','gov_income','政府应收','4','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('product_label','developed_area','发达地区','5','');

/* 插入字典总表[yes_or_no-是否] */
INSERT INTO system_dict_type(type,name,remark) VALUES('yes_or_no','是否','');
/* 插入字典明细表 */
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('yes_or_no','0','否','1','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('yes_or_no','1','是','2','');

/* 插入字典总表[link_page_category-链接网页分类] */
INSERT INTO system_dict_type(type,name,remark) VALUES('link_page_category','链接网页分类','');
/* 插入字典明细表 */
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('link_page_category','gallery','首页轮播图','1','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('link_page_category','featured_topics','精选专题','2','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('link_page_category','self_news','小易资讯','3','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('link_page_category','class','小易课堂','4','');
INSERT INTO system_dict_data(dict_type,value,label,sort,remark) VALUES('link_page_category','media_news','媒体报道','5','');


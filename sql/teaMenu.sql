-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教师', '3', '1', '/module/tea', 'C', '0', 'module:tea:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '教师菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教师查询', @parentId, '1',  '#',  'F', '0', 'module:tea:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教师新增', @parentId, '2',  '#',  'F', '0', 'module:tea:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教师修改', @parentId, '3',  '#',  'F', '0', 'module:tea:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教师删除', @parentId, '4',  '#',  'F', '0', 'module:tea:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

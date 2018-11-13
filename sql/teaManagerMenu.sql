-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教师管理', '3', '1', '/module/teaManager', 'C', '0', 'module:teaManager:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '教师管理菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教师管理查询', @parentId, '1',  '#',  'F', '0', 'module:teaManager:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教师管理新增', @parentId, '2',  '#',  'F', '0', 'module:teaManager:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教师管理修改', @parentId, '3',  '#',  'F', '0', 'module:teaManager:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教师管理删除', @parentId, '4',  '#',  'F', '0', 'module:teaManager:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

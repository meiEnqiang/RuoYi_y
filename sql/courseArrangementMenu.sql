-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('课程安排', '3', '1', '/module/courseArrangement', 'C', '0', 'module:courseArrangement:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '课程安排菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('课程安排查询', @parentId, '1',  '#',  'F', '0', 'module:courseArrangement:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('课程安排新增', @parentId, '2',  '#',  'F', '0', 'module:courseArrangement:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('课程安排修改', @parentId, '3',  '#',  'F', '0', 'module:courseArrangement:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('课程安排删除', @parentId, '4',  '#',  'F', '0', 'module:courseArrangement:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

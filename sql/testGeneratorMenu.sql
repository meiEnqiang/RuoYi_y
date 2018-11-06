-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('测试', '3', '1', '/module/testGenerator', 'C', '0', 'module:testGenerator:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '测试菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('测试查询', @parentId, '1',  '#',  'F', '0', 'module:testGenerator:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('测试新增', @parentId, '2',  '#',  'F', '0', 'module:testGenerator:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('测试修改', @parentId, '3',  '#',  'F', '0', 'module:testGenerator:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('测试删除', @parentId, '4',  '#',  'F', '0', 'module:testGenerator:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

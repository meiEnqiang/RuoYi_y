package com.ruoyi.project.tool.gen.service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.exception.base.BaseException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.config.GenConfig;
import com.ruoyi.project.tool.gen.domain.ColumnInfo;
import com.ruoyi.project.tool.gen.domain.TableInfo;
import com.ruoyi.project.tool.gen.mapper.GenMapper;
import com.ruoyi.project.tool.gen.util.GenUtils;
import com.ruoyi.project.tool.gen.util.VelocityInitializer;

/**
 * 代码生成 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class GenServiceImpl implements IGenService
{
    @Autowired
    private GenMapper genMapper;

    /**
     * 查询ry数据库表信息
     * 
     * @param tableInfo 表信息
     * @return 数据库表列表
     */
    @Override
    public List<TableInfo> selectTableList(TableInfo tableInfo)
    {
        return genMapper.selectTableList(tableInfo);
    }

    /**
     * 生成代码
     * 
     * @param tableName 表名称
     * @return 数据
     */
    @Override
    public byte[] generatorCode(String tableName)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        // 查询表信息
        TableInfo table = genMapper.selectTableByName(tableName);
        // 查询列信息
        List<ColumnInfo> columns = genMapper.selectTableColumnsByName(tableName);
        // 生成代码
        generatorCode(table, columns, zip);
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    /**
     * 批量生成代码
     * 
     * @param tableNames 表数组
     * @return 数据
     */
    @Override
    public byte[] generatorCode(String[] tableNames)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for (String tableName : tableNames)
        {
            // 查询表信息
            TableInfo table = genMapper.selectTableByName(tableName);
            // 查询列信息
            List<ColumnInfo> columns = genMapper.selectTableColumnsByName(tableName);
            // 生成代码
            generatorCode(table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    /**
     * 生成代码
     */
    public void generatorCode(TableInfo table, List<ColumnInfo> columns, ZipOutputStream zip)
    {
        // 表名转换成Java属性名
        String className = GenUtils.tableToJava(table.getTableName());
        table.setClassName(className);
        table.setClassname(StringUtils.uncapitalize(className));
        // 列信息
        table.setColumns(GenUtils.transColums(columns));
        // 设置主键
        table.setPrimaryKey(table.getColumnsLast());

        VelocityInitializer.initVelocity();

        String packageName = GenConfig.getPackageName();
        String moduleName = GenUtils.getModuleName(packageName);

        VelocityContext context = GenUtils.getVelocityContext(table);

        // 获取模板列表
        List<String> templates = GenUtils.getTemplates();
        for (String template : templates)
        {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, Constants.UTF8);
            tpl.merge(context, sw);
            try
            {
                String fileName = GenUtils.getFileName(template, table, moduleName);
                //写到项目里去
                String codePath = GenConfig.getCodePath();
                File file = new File(codePath);
                if(file.exists()){
                    file = new File(codePath + fileName);
                    // 如果当前文件父目录不存在，则创建
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    // 如果当前文件已经存在着不创建这个文件
                    if (!file.exists()) {
                        System.out.println("path:" + "D:\\code\\RuoYi_y\\" + fileName);
                        FileOutputStream outputStream = new FileOutputStream(file);
                        BufferedWriter writer = new BufferedWriter(
                                new OutputStreamWriter(outputStream, Constants.UTF8));
                        tpl.merge(context,writer);
                        writer.flush();
                        writer.close();
                    }

                }
                // 添加到zip
                zip.putNextEntry(new ZipEntry(fileName));
                IOUtils.write(sw.toString(), zip, Constants.UTF8);
                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            }
            catch (IOException e)
            {
                throw new BaseException("渲染模板失败，表名：" + table.getTableName(), e.getMessage());
            }
        }
    }
}

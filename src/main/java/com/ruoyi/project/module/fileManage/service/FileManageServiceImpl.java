package com.ruoyi.project.module.fileManage.service;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.fastDFS.FastDFSFile;
import com.ruoyi.common.fastDFS.FastDFSService;
import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.entity.FileManage;
import com.ruoyi.entity.FileManageExample;
import com.ruoyi.framework.datascope.DataScopeUtils;
import com.ruoyi.project.module.fileManage.mapper.FileManageExtendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * 文件管理 服务层实现
 *
 * @author MeiEQ
 * @date 2018-10-26
 */
@Service
public class FileManageServiceImpl implements IFileManageService {
    @Autowired
    private FileManageExtendMapper fileManageMapper;
    @Autowired
    private FastDFSService fastDFSService;

    /**
     * 查询文件管理信息
     *
     * @param fileId 文件管理ID
     * @return 文件管理信息
     */
    @Override
    public FileManage selectFileManageById(Integer fileId) {
        return fileManageMapper.selectByPrimaryKey(fileId);
    }

    /**
     * 查询文件管理列表
     *
     * @param fileManage 文件管理信息
     * @return 文件管理集合
     */
    @Override
    public List<FileManage> selectFileManageList(FileManage fileManage) {
        fileManage.getParams().put("dataScope", DataScopeUtils.dataScopeFilter());
        return fileManageMapper.selectFileManageList(fileManage);
    }

    /**
     * 新增文件管理
     *
     * @param fileManage 文件管理信息
     * @return 结果
     */
    @Override
    public int insertFileManage(FileManage fileManage) {
        fileManage.setCreateBy(ShiroUtils.getLoginName());
        return fileManageMapper.insertSelective(fileManage);
    }

    /**
     * 修改文件管理
     *
     * @param fileManage 文件管理信息
     * @param file       上传的文件
     * @return 结果
     */
    @Override
    public int updateFileManage(FileManage fileManage, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                fastDFSService.deleteFile(getFastDFSFileByFilePath(fileManage.getFilePath()));
                FastDFSFile fastDFSFile = fastDFSService.saveFile(file);
                String filePath = fastDFSFile.getFilePath();
                fileManage.setFilePath(filePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return updateFileManage(fileManage);
    }

    /**
     * 修改文件管理
     *
     * @param fileManage 文件管理信息
     * @return 结果
     */
    @Override
    public int updateFileManage(FileManage fileManage) {
        fileManage.setUpdateBy(ShiroUtils.getLoginName());
        fileManage.setUpdateTime(new Date());
        return fileManageMapper.updateByPrimaryKeySelective(fileManage);
    }

    /**
     * 删除文件管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFileManageByIds(String ids) {
        String[] str = Convert.toStrArray(ids);
        int count = 0;
        for (String id : str) {
            int fileId = Integer.parseInt(id);
            String filePath = selectFileManageById(fileId).getFilePath();
            int i = fileManageMapper.deleteByPrimaryKey(fileId);
            if (i > 0) {
                fastDFSService.deleteFile(getFastDFSFileByFilePath(filePath));
                count++;
            }
        }
        //return fileManageMapper.deleteFileManageByIds(Convert.toStrArray(ids));
        return count;
    }

    /**
     * 保存文件
     *
     * @param fileManage 文件实体类
     * @param file       上传的文件
     * @return 保存的条数
     */
    @Override
    public int saveFile(FileManage fileManage, MultipartFile file) {
        FastDFSFile fastDFSFile = fastDFSService.saveFile(file);
        String filePath = fastDFSFile.getFilePath();
        fileManage.setFilePath(filePath);
        return insertFileManage(fileManage);
    }

    /**
     * 保存文件
     *
     * @param fileManage 文件实体类
     * @param files      上传的文件
     * @return 保存的条数
     */
    @Override
    public int saveFile(FileManage fileManage, List<MultipartFile> files) {
        if(files.size() == 1){
            return saveFile(fileManage, files.get(0));
        }
        int i = 0;
        for (MultipartFile multipartFile : files) {
            fileManage.setFileName(multipartFile.getOriginalFilename());
            i += saveFile(fileManage, multipartFile);
        }
        return i;
    }

    /**
     * 根据主id和文件名字判断是否有相同的
     *
     * @param fileId   文件主id
     * @param fileName 文件名称
     * @return string "1" 有 "0" 没有
     */
    @Override
    public String checkFileNameUnique(Integer fileId, String fileName) {
        FileManageExample example = new FileManageExample();
        example.createCriteria().andFileNameEqualTo(fileName).andFileIdNotEqualTo(fileId);
        List<FileManage> list = fileManageMapper.selectByExample(example);
        if (list.size() > 0) {
            return UserConstants.DEPT_NAME_NOT_UNIQUE;
        }
        return UserConstants.DEPT_NAME_UNIQUE;
    }

    /**
     * 根据保存的文件路径获取文件的所有信息
     *
     * @param filePath 文件路径
     * @return FastDFSFile
     */
    @Override
    public FastDFSFile getFastDFSFileByFilePath(String filePath) {
        FastDFSFile fastDFSFile = new FastDFSFile();
        if (StringUtils.isNotEmpty(filePath)) {
            String[] strs = StringUtils.split(filePath, "/", 4);
            fastDFSFile.setFileGroup(strs[2]);
            fastDFSFile.setRemoteFileName(strs[3]);
        }
        return fastDFSFile;

    }
}

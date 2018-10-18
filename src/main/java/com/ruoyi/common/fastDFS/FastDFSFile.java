package com.ruoyi.common.fastDFS;

import lombok.Data;

/**
 * @author MeiEnQiang
 * @date 2018/10/15/0015
 */
@Data
public class FastDFSFile {
    private String name;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;
    private String fileName;
    private String fileGroup;
    private String remoteFileName;
    private String filePath;
    public FastDFSFile() {
        super();
    }
    public FastDFSFile(String fileName, String fileGroup, String remoteFileName, String filePath) {
        super();
        this.fileName = fileName;
        this.fileGroup = fileGroup;
        this.remoteFileName = remoteFileName;
        this.filePath = filePath;
    }
    public FastDFSFile(String name, byte[] content, String ext) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
    }
}

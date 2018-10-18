package com.ruoyi.common.fastDFS;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author MeiEnQiang
 * @date 2018/10/15/0015
 */
public class FastDFSClient {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(FastDFSClient.class);
    static {
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();;
            ClientGlobal.init(filePath);
        } catch (Exception e) {
            logger.error("FastDFS Client Init Fail!",e);
        }
    }
    public static FastDFSFile upload(FastDFSFile file) {
        try {
            NameValuePair[] metaList = new NameValuePair[1];
            metaList[0] = new NameValuePair("author", file.getAuthor());
            long startTime = System.currentTimeMillis();
            String[] uploadResults = null;
            StorageClient storageClient=null;
            storageClient = getTrackerClient();
            uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), metaList);
            logger.info("upload_file time used:" + (System.currentTimeMillis() - startTime) + " ms");
            if (uploadResults == null && storageClient!=null) {
                logger.error("upload file fail, error code:" + storageClient.getErrorCode());
            }
            String groupName = uploadResults[0];
            String remoteFileName = uploadResults[1];
            String filePath = getTrackerUrl() + groupName + "/" + remoteFileName;
            FastDFSFile fastDFSFile = new FastDFSFile(file.getName(),groupName,remoteFileName,filePath);
            logger.info("upload file successfully!!!" + "group_name:" + groupName + ", remoteFileName:" + " " + remoteFileName);
            return fastDFSFile;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("FastDFS上传失败：" + e.getMessage());
            return null;
        }
    }

    public static FileInfo getFile(String groupName, String remoteFileName) {
        try {
            StorageClient storageClient = getTrackerClient();
            return storageClient.get_file_info(groupName, remoteFileName);
        } catch (IOException e) {
            logger.error("IO Exception: Get File from Fast DFS failed", e);
        } catch (Exception e) {
            logger.error("Non IO Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }

    public static InputStream downFile(String groupName, String remoteFileName) {
        try {
            StorageClient storageClient = getTrackerClient();
            byte[] fileByte = storageClient.download_file(groupName, remoteFileName);
            return new ByteArrayInputStream(fileByte);
        } catch (IOException e) {
            logger.error("IO Exception: Get File from Fast DFS failed", e);
        } catch (Exception e) {
            logger.error("Non IO Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }

    public static void deleteFile(String groupName, String remoteFileName)
            throws Exception {
        StorageClient storageClient = getTrackerClient();
        int i = storageClient.delete_file(groupName, remoteFileName);
        logger.info("delete file successfully!!!" + i);
    }

    public static StorageServer[] getStoreStorages(String groupName)
            throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getStoreStorages(trackerServer, groupName);
    }

    public static ServerInfo[] getFetchStorages(String groupName, String remoteFileName) throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getFetchStorages(trackerServer, groupName, remoteFileName);
    }

    public static String getTrackerUrl() throws IOException {
        return "http://"+getTrackerServer().getInetSocketAddress().getHostString()+":"+ClientGlobal.getG_tracker_http_port()+"/";
    }

    private static StorageClient getTrackerClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        return new StorageClient(trackerServer, null);
    }

    private static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        return trackerClient.getConnection();
    }
}

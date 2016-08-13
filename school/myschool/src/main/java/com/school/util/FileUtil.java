package com.school.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.school.vo.ResourceVo;

/**
 * 一个处理本项目有关文件的工具类
* @author  作者  chenbowei E-mail:bowei_chan@163.com
* @date 创建时间：Aug 10, 2016 2:17:09 AM 
* @version 1.0
 */
public class FileUtil {
    
    public static ResourceVo upload(MultipartFile file,HttpServletRequest request) throws IOException {
	ResourceVo rv = null;
	String savePath = null;
	String contextPath = null;
	if (file.isEmpty()) {
		return null;
	}
	rv = new ResourceVo();
	
	contextPath = request.getSession().getServletContext().getRealPath("/upload");
	savePath = contextPath + "/" + createDir(contextPath);
	String fileName = file.getOriginalFilename();//客户端的文件名称
	fileName = createFileName(file);
	
	rv.setThumb_path(contextPath + "/thumb/" + createDir(contextPath) + "/" + fileName);//设置缩略图存放路径
	rv.setRelativeThumbPath("/thumb/" + createDir(contextPath) + "/" + fileName);//缩略图相对路径
	rv.setFileName(fileName);//设置文件名
	savePath = savePath + "/" + fileName;
	
	try {
	    file.transferTo(new File(savePath));//保存文件到服务器上
	    
	    rv.setAbsolutePath(savePath);
	    rv.setRelative_path(savePath.substring(contextPath.length()));
	    
	 // 2.生成对应缩略图
	    // 判断是什么文件，生成缩略图
	    if (ImageUtil.isImage(rv.getFileName())) {
		rv.setType(1);
		// 按原比例的0.3进行缩放，生成缩略图
		ThumbUtil.thumbnailImage(rv.getAbsolutePath(), 0.3,
			rv.getThumb_path());
	    } else if (FileFormatUtil.isVideo(rv.getFileName())) {
		rv.setType(2);
		// 以后缀名为jpg的格式生成视频缩略图，保存路径在对应的thumb目录下
		String path = VideoCoverGenerator.generateVideoCover(rv);
		rv.setRelativeThumbPath("/thumb" + path);
	    }
	} catch (IllegalStateException | IOException e) {
	    e.printStackTrace();
	    rv = null;
	}
	return rv;
    }
    
    /**
     * 文件数组上传
     * @param files
     * @param request
     * @return
     * @throws IOException 
     */
    public static ResourceVo[] upload(CommonsMultipartFile[] files,HttpServletRequest request) throws IOException {
	ResourceVo[] resources = new ResourceVo[files.length];
	int i = 0;
	for(CommonsMultipartFile file:files) {
	    resources[i ++] = upload(file, request);
	}
	return resources;
    }
    
    public static ResourceVo delete(ResourceVo rv) {
	File file1 = new File(rv.getAbsolutePath());
	File file2 = new File(rv.getThumb_path());
	if(!file1.delete() || !file2.delete()) {
	    return null;
	}
	return rv;
    }
    
    /*
     * 根据系统时间生成文件名
     */
    private static String createFileName(MultipartFile file) {
	String tempName = file.getOriginalFilename();
	int index = tempName.lastIndexOf(".");
	tempName = tempName.substring(index, tempName.length()); // 截取文件类型
	return System.currentTimeMillis() + tempName;
    }
    
    /*
     * 根据日期存放资源创建目录
     */
    private static String createDir(String savePath) {
	String dir = DateFormatUtil.formatDateToDay(new Date()).replace("-", "");
	File f1 = new File(savePath + "/" +dir);
	File f2 = new File(savePath + "/thumb/" + dir);
	if(!f1.exists()) {
	    f1.mkdirs();
	}
	if(!f2.exists()) {
	    f2.mkdirs();//创建用来存放缩略图的目录
	}
	return dir;
    }
    
}

package com.school.util;

import java.util.ArrayList;

/**
 * 用来判断文件类型的工具类
 * 
 * @author 作者 chenbowei E-mail:bowei_chan@163.com
 * @date 创建时间：Aug 10, 2016 2:50:07 PM
 * @version 1.0
 */
public class FileFormatUtil {

    private  static final ArrayList<String> imageSuffixList = new ArrayList<String>();
    private  static final ArrayList<String> videoSuffixList = new ArrayList<String>();
    private  static final ArrayList<String> invalidSuffixList = new ArrayList<String>();
    static {
	/*
	 * ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG,
	 * WBMP, GIF, gif] /
	 *****************************************************************/
	imageSuffixList.add("bmp");
	imageSuffixList.add("jpg");
	imageSuffixList.add("jpeg");
	imageSuffixList.add("wbmp");
	imageSuffixList.add("png");
	imageSuffixList.add("gif");
	
	/*
	 * video支持的视频类型
	 * mkv，flv，rmvb ，wmv,avi,mp4,3gp
	 */
	videoSuffixList.add("wmv");
	videoSuffixList.add("flv");
	videoSuffixList.add("rmvb");
	videoSuffixList.add("mp4");
	videoSuffixList.add("avi");
	videoSuffixList.add("3gp");
	videoSuffixList.add("mkv");
	
	/*
	 * 不合法的文件名
	 * jsp,php,asp
	 */
	invalidSuffixList.add("jsp");
	invalidSuffixList.add("php");
	invalidSuffixList.add("asp");
	
    }
    
    /**
     * 是否是图片
     * @param fileName
     * @return
     */
    public static boolean isImage(String fileName) {
	if (fileName == null) {
	    return false;
	}
	String suffix = getFileEnd(fileName);
	if (suffix == null || "".equals(suffix)) {
	    return false;
	}
	suffix = suffix.toLowerCase();
	if (imageSuffixList.contains(suffix)) {
	    return true;
	}
	return false;
    }

    /**
     * 是否是视频
     * @param fileName
     * @return
     */
    public static boolean isVideo(String fileName) {
	if (fileName == null) {
	    return false;
	}
	String suffix = getFileEnd(fileName);
	if (suffix == null || "".equals(suffix)) {
	    return false;
	}
	suffix = suffix.toLowerCase();
	if (videoSuffixList.contains(suffix)) {
	    return true;
	}
	return false;
    }
    
    /*
     * 文件名是否合法
     * true 为合法，false不合法
     */
    public static boolean isValidFile(String fileName) {
	if(fileName == null) {
	    return false;
	}
	String suffix = getFileEnd(fileName);
	if(suffix == null || "".equals(suffix)) {
	    return false;
	}
	suffix = suffix.toLowerCase();
	if(invalidSuffixList.contains(suffix)) {
	    return false;
	}
	return true;
    }
    
    /*
     * 获取文件后缀名
     */
    private static String getFileEnd(String fileName) {
	String suffix = null;
	if (fileName.indexOf(".") > -1) {
	    suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
	}
	return suffix;
    }
}

package com.school.util;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

/**
 * 本项目所用生成缩略图工具类
* @author  作者  chenbowei E-mail:bowei_chan@163.com
* @date 创建时间：Aug 10, 2016 3:38:20 AM 
* @version 1.0
 */
public class ThumbUtil {
//    private static final String DEFAULT_PREVFIX = "thumb";//前缀？
//    private static final double DEFAULT_SCALE = 0.3;//收缩比例
//    private static final Boolean DEFAULT_FORCE = true;
    
    /*
     * 按比例缩放
     */
    public static void thumbnailImage(String imagePath,double scale,String savePath) throws IOException {
	Thumbnails.of(new File(imagePath)).scale(scale).toFile(savePath);
    }
    
    /*
     * 按大小缩放
     */
    public static void thumbnailImage(String imagePath,int wieght,int height,String savePath) throws IOException {
	Thumbnails.of(new File(imagePath)).size(wieght, height).toFile(savePath);
    }
}

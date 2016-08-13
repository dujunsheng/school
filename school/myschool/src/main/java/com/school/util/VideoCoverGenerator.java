package com.school.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.school.vo.ResourceVo;


/**
 * 利用ffmpeg生成视频缩略图
* @author  作者  chenbowei E-mail:bowei_chan@163.com
* @date 创建时间：Aug 10, 2016 2:40:12 PM 
* @version 1.0
 */
public class VideoCoverGenerator {
    	//需要有ffmpeg.exe程序
	private static final String FFMPEG_EXE_PATH = "D:/ffmpeg.exe";
	
	public static String generateVideoCover(ResourceVo rv) {
		
		String videoRealPath = rv.getAbsolutePath();
		String videoRelativePath = rv.getRelative_path();
		String coverRealPath = rv.getThumb_path().substring(0,rv.getThumb_path().lastIndexOf(".")) + ".jpg";/*videoRealPath.substring(0, videoRealPath.lastIndexOf(".")) + ".jpg";*/
		String coverRelativePath = videoRelativePath.substring(0, videoRelativePath.lastIndexOf(".")) + ".jpg";
		
		List<String> command = new ArrayList<String>();
		command.add(FFMPEG_EXE_PATH);
		command.add("-ss");
		command.add("5");
		command.add("-i");
		command.add(videoRealPath);
		command.add("-y");
		command.add("-f");
		command.add("image2");
		command.add("-t");
		command.add("0.001");
		command.add("-s");
		command.add("150*150");
		command.add(coverRealPath);
		ProcessBuilder builder = new ProcessBuilder();
		builder.command(command);
		try {
			builder.start();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return coverRelativePath;
	}
}

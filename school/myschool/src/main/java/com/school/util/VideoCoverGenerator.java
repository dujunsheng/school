package com.school.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.school.vo.FileUploadVo;


/**
 * 
* @ClassName: VideoCoverGenerator
* @Description: 使用FFmpeg生成视频缩略图
* @author Catalyst
* @date 2016年4月22日
*
 */
public class VideoCoverGenerator {

	private static final String FFMPEG_EXE_PATH = "D:/ffmpeg/bin/ffmpeg.exe";
	
	public static String generateVideoCover(FileUploadVo vo) {
		
		String videoRealPath = vo.getRealPath() + "/" + vo.getFileName();
		String videoRelativePath = vo.getRelativePath();
		String coverRealPath = videoRealPath.substring(0, videoRealPath.lastIndexOf(".")) + ".jpg";
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
		command.add("480*272");
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

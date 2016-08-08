package com.school.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 利用ffmpeg实现将amr格式音频转为mp3
 * @Author <wuyiliang 757210697@qq.com>
 * @Date 2015年8月26日 下午10:28:49
 * @CopyRight 2015 TopView Inc
 * @version V1.0
 */
public class SimpleAudioChange {

	private static String FFMPEG_EXE_Path = "D:\\ffmpeg\\bin\\ffmpeg.exe"; //TODO 移动到配置文件中较好
	
//	/**
//	 * 使用jave将amr格式（实际上安卓发送的格式是mov）转为mp3格式
//	 * 
//	 * @param sourceAudio
//	 * @param targetRealPath
//	 * @return
//	 */
//	@Deprecated
//	public File changetoMp3WithJave(File sourceAudio, String targetRealPath) {
//		String targetFileName = sourceAudio.getName().replace(".amr", ".mp3"); // 目标文件名
//		File target = new File(targetRealPath + "\\" + targetFileName);
//		AudioAttributes audio = new AudioAttributes();
//		audio.setCodec("libmp3lame"); //设置编码格式
//		audio.setBitRate(new Integer(36000)); // 音频比率 MP3默认是1280000
//		audio.setChannels(new Integer(1)); //设置为单通道
//		audio.setSamplingRate(new Integer(44100)); //设置采样率
//		EncodingAttributes attrs = new EncodingAttributes();
//		attrs.setFormat("mp3"); //设置格式为mp3
//		attrs.setAudioAttributes(audio);
//		Encoder encoder = new Encoder();
//		try {
//			encoder.encode(sourceAudio, target, attrs); //进行格式转换
//		} catch (IllegalArgumentException e) {
//			System.out.print("参数违法：————");
//			e.printStackTrace();
//		} catch (InputFormatException e) {
//			System.out.print("不支持的音频格式:————");
//			e.printStackTrace();
//		} catch (EncoderException e) {
//			System.out.print("解码失败：————");
//			e.printStackTrace();
//		}
//		return target;
//	}
	
	/**
	 * 调用ffmpeg将amr音频转为mp3格式
	 * @param sourceAudio
	 * @param targetRealPath
	 * @return
	 */
	public static File changeToMp3WithFfmpeg(File sourceAudio, String targetRealPath) {
		String targetFileName = sourceAudio.getName().replace(".amr", ".mp3"); // 目标文件名
		File target = new File(targetRealPath + "\\" + targetFileName); // 目标文件
		List<String> commend = new ArrayList<String>();
		commend.add(FFMPEG_EXE_Path);
		commend.add("-i");
		commend.add(sourceAudio.getAbsolutePath());
		commend.add(target.getAbsolutePath());
		StringBuffer command = new StringBuffer();
		for(int i = 0; i < commend.size(); i++) {
			command.append(commend.get(i) + " ");
		}
		System.out.println("执行命令:" + command);
		
		ProcessBuilder builder = new ProcessBuilder(commend);
		try {
			builder.start();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return target;
	}
}

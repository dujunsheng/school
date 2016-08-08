package com.school.util;

/**
 * @Title: ThumbnailDirTranslator.java
 * @Package com.topview.school.util
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年5月22日 下午4:53:07
 * @version V1.0
 */
public class ThumbnailDirTranslator {
	/**
	 * @ClassName: ThumbnailDirTranslator
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年5月22日 下午4:53:07
	 */
	private static final String DEFAULT_PREVFIX = "thumb";
	private static final String FILE_SEPARATOR_1 = "/";
	private static final String FILE_SEPARATOR_2 = "\\";

	/**
	 * 
	 * @Title: getDir
	 * @Description: 获取原路径
	 * @param @param old_dir
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String getDir(String old_dir) {

		String separator = getSeparator(old_dir);
		return old_dir.substring(0, old_dir.lastIndexOf(separator)) + separator
				+ DEFAULT_PREVFIX + separator;
	}

	/**
	 * 
	 * @Title: translate
	 * @Description: 在原路径下加一个文件夹放缩略图
	 * @param @param old_dir
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String translate(String old_dir) {

		String separator = getSeparator(old_dir);
		return getDir(old_dir)
				+ old_dir.substring(old_dir.lastIndexOf(separator) + 1);
	}

	/**
	 * 
	 * @Title: getSeparator
	 * @Description: TODO
	 * @param @param old_dir
	 * @param @return
	 * @return String
	 * @throws
	 */
	private static String getSeparator(String old_dir) {

		String separator = null;
		if (old_dir.contains(FILE_SEPARATOR_1)) {
			separator = FILE_SEPARATOR_1;
		} else if (old_dir.contains(FILE_SEPARATOR_2)) {
			separator = FILE_SEPARATOR_2;
		}
		return separator;
	}

}

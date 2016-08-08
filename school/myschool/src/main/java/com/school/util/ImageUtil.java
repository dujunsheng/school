package com.school.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * @Title: ImageUtil.java
 * @Package com.topview.school.util
 * @Description: TODO
 * @author :cx
 * @date 2015年11月16日
 * @version V1.0
 */
public class ImageUtil {
			/**
			 * Logger for this class
			 */
			private static final Logger logger = Logger.getLogger(ImageUtil.class);
		
			
			
			public boolean isImage(String imageName){
				if(imageName==null){
					return false;
				}
				String suffix=this.getFileEnd(imageName);
				if(suffix==null||"".equals(suffix)){
					return false;
				}
				suffix=suffix.toLowerCase();
				ArrayList<String> suffixList=new ArrayList<String>();
				// ******************************************************************
				// ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG,
				// JPEG, WBMP, GIF, gif]
				// ******************************************************************
				suffixList.add("bmp");
				suffixList.add("jpg");
				suffixList.add("jpeg");
				suffixList.add("wbmp");
				suffixList.add("png");
				suffixList.add("gif");
				if(suffixList.contains(suffix)){
					return true;
				}
				return false;
			}
			
			/**
			 * 
			 * @Title: getImageEnd
			 * @Description: TODO
			 * @param @param imgFile
			 * @param @param types
			 * @param @return
			 * @return String
			 * @throws
			 */
			private String getFileEnd(String fileName) {
				if (logger.isDebugEnabled()) {
					logger.debug("getImageEnd(File, String) - start"); //$NON-NLS-1$
				}

				String suffix = null;
				// 获取图片后缀
				if (fileName.indexOf(".") > -1) {
					suffix = fileName.substring(
							fileName.lastIndexOf(".") + 1);
				}// 类型和图片后缀全部小写，然后判断后缀是否合法
				if (suffix == null) {
					logger.error("Sorry, the image suffix is illegal.");
				}

				if (logger.isDebugEnabled()) {
					logger.debug("getImageEnd(File, String) - end"); //$NON-NLS-1$
				}
				return suffix;
			}
}

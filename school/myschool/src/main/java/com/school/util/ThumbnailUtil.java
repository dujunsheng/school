package com.school.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

/**
 * @Title: ThumbnailUtil.java
 * @Package com.topview.school.util
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年5月22日 上午2:09:45
 * @version V1.0
 */
public class ThumbnailUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ThumbnailUtil.class);

	/**
	 * @ClassName: ThumbnailUtil
	 * @Description: 使用JDK原生态类生成图片缩略图和裁剪图片
	 * @author Sherlock-lee
	 * @date 2015年5月22日 上午2:09:46
	 */
	private static final String DEFAULT_PREVFIX = "thumb";
	private static final double DEFAULT_RACE = 0.3;
	private static final Boolean DEFAULT_FORCE = true;

	/**
	 * 
	 * @Title: thumbnailImage
	 * @Description: 按默认的比率生成缩略图
	 * @param @param imagePath
	 * @return void
	 * @throws
	 */
	public static void thumbnailImage(String imagePath) {
		if (logger.isDebugEnabled()) {
			logger.debug("thumbnailImage(String) - start"); //$NON-NLS-1$
		}

		thumbnailImage(imagePath, DEFAULT_RACE);

		if (logger.isDebugEnabled()) {
			logger.debug("thumbnailImage(String) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 
	 * @Title: thumbnailImage
	 * @Description: 按一定的比率生成缩略图
	 * @param @param imagePath
	 * @param @param d
	 * @return void
	 * @throws
	 */
	public static void thumbnailImage(String imagePath, double d) {
		if (logger.isDebugEnabled()) {
			logger.debug("thumbnailImage(String, double) - start"); //$NON-NLS-1$
		}

		File imgFile = new File(imagePath);
		Image img = null;
		int width = 1;
		int height = 1;
		try {
			img = ImageIO.read(imgFile);
		} catch (IOException e) {
			logger.error("thumbnailImage(String, double)", e); //$NON-NLS-1$

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(img != null){
			
			width = (int) (img.getWidth(null) * d);
			height = (int) (img.getHeight(null) * d);
		}
		thumbnailImage(imgFile, width, height, DEFAULT_PREVFIX, DEFAULT_FORCE);

		if (logger.isDebugEnabled()) {
			logger.debug("thumbnailImage(String, double) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * @Title: thumbnailImage
	 * @Description: 根据图片路径生成缩略图
	 * @param imagePath
	 *            原图片路径
	 * @param w
	 *            缩略图宽
	 * @param h
	 *            缩略图高
	 * @param prevfix
	 *            生成缩略图的前缀
	 * @param force
	 *            是否强制按照宽高生成缩略图(如果为false，则生成最佳比例缩略图)
	 */
	private static void thumbnailImage(File imgFile, int w, int h,
			String prevfix, boolean force) {
		if (logger.isDebugEnabled()) {
			logger.debug("thumbnailImage(File, int, int, String, boolean) - start"); //$NON-NLS-1$
		}

		if (imgFile.exists()) {
			try {
				// ******************************************************************
				// ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG,
				// JPEG, WBMP, GIF, gif]
				// ******************************************************************
				logger.debug("target image's size, width:{}, height:{}.");
				String types = Arrays.toString(ImageIO.getReaderFormatNames());
				String suffix = null;
				if ((suffix = getImageEnd(imgFile, types)) == null) {
					if (logger.isDebugEnabled()) {
						logger.debug("thumbnailImage(File, int, int, String, boolean) - end"); //$NON-NLS-1$
					}
					return;// 如果后缀不合法，终止生成
				}
				Image img = ImageIO.read(imgFile);
				BufferedImage bi = null;

				if (force) {
					bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
				} else {
					bi = getBetterImage(img, w, h);
				}
				Graphics g = bi.getGraphics();
				g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
				g.dispose();
				String p = imgFile.getPath();
				// ******************************************************************
				// 将缩略片保存在原目录的thumb目录下
				// ******************************************************************
				String new_dir = ThumbnailDirTranslator.getDir(p);
				File d = new File(new_dir);
				if (!d.exists()) {
					d.mkdir();
				}
				ImageIO.write(bi, suffix,
						new File(ThumbnailDirTranslator.translate(p)));
			} catch (IOException e) {
				logger.error(
						"thumbnailImage(File, int, int, String, boolean)", e); //$NON-NLS-1$

				logger.error("generate thumbnail image failed.");
			}
		} else {
			logger.warn("the image is not exist.");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("thumbnailImage(File, int, int, String, boolean) - end"); //$NON-NLS-1$
		}
	}

//	
//	@Test
//	public void test() {
//		
//		File imageFile = new File("C:/Users/lenovo/Desktop/post/123.jpg");
//		ThumbnailUtil.squareThumbnailGenerate(imageFile, 200);
////		ThumbnailUtil.thumbnailImage(iamgeFile, 200, 200, DEFAULT_PREVFIX, false);
//	}
	
	/**
	 * 根据原图生成一个方形的缩略图。
	 *  @param File imageFile 用于生成缩略图的原图
	 *  @param Int pixel  生成的方形缩略图的尺寸
 	 */
	public static void squareThumbnailGenerate(File imageFile, Integer pixel){
		if (logger.isDebugEnabled()) {
			logger.debug("thumbnailImage(File, int, int, String, boolean) - start"); //$NON-NLS-1$
		}
		if (imageFile.exists()) {
			try {
				// ******************************************************************
				// ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG,
				// JPEG, WBMP, GIF, gif]
				// ******************************************************************
				logger.debug("target image's size, width:{}, height:{}.");
				String types = Arrays.toString(ImageIO.getReaderFormatNames());
				String suffix = null;
				if ((suffix = getImageEnd(imageFile, types)) == null) {
					if (logger.isDebugEnabled()) {
						logger.debug("thumbnailImage(File, int, int, String, boolean) - end"); //$NON-NLS-1$
					}
					return;// 如果缀后不合法，终止生成
				}
				BufferedImage testImg = ImageIO.read(imageFile);	
				BufferedImage bi = null;
				BufferedImage bi2 = null;
				Graphics g = null;
				//对传入的图片是竖向还是横向进行判断
				if(testImg.getHeight()<testImg.getWidth()){
					bi = testImg.getSubimage(testImg.getWidth()/2-testImg.getHeight()/2, 0, testImg.getHeight(), testImg.getHeight());
					g = bi.getGraphics();
					g.drawImage(bi, 0, 0, testImg.getHeight(), testImg.getHeight(), Color.LIGHT_GRAY, null);
					bi2 =  new BufferedImage(pixel, pixel, BufferedImage.TYPE_INT_RGB);
					Graphics g2  = bi2.getGraphics();
					g2.drawImage(bi, 0, 0, pixel, pixel, Color.LIGHT_GRAY, null);
					g2.dispose();
					g.dispose();		
				}
				else if (testImg.getHeight()>testImg.getWidth()){ 
					bi = testImg.getSubimage(0, testImg.getHeight()/2-testImg.getWidth()/2, testImg.getWidth(), testImg.getWidth());
					g = bi.getGraphics();
					g.drawImage(bi, 0, 0, testImg.getWidth(), testImg.getWidth(), Color.LIGHT_GRAY, null);
					bi2 =  new BufferedImage(pixel, pixel, BufferedImage.TYPE_INT_RGB);
					Graphics g2  = bi2.getGraphics();
					g2.drawImage(bi, 0, 0, pixel, pixel, Color.LIGHT_GRAY, null);
					g2.dispose();
					g.dispose();		
				}
				else{
					System.out.println(123);
					bi2 =  new BufferedImage(pixel, pixel, BufferedImage.TYPE_INT_RGB);
					Graphics g2  = bi2.getGraphics();
					g2.drawImage(testImg, 0, 0, pixel, pixel, Color.LIGHT_GRAY, null);
					g2.dispose();
				}

				String p = imageFile.getPath();
				// ******************************************************************
				// 将缩略片保存在原目录的thumb目录下
				// ******************************************************************
				String new_dir = ThumbnailDirTranslator.getDir(p);
				File d = new File(new_dir);
				if (!d.exists()) {
					d.mkdir();
				}
				ImageIO.write(bi2, suffix,
						new File(ThumbnailDirTranslator.translate(p)));
			} catch (IOException e) {
				
				logger.error(
						"thumbnailImage(File, int, int, String, boolean)", e); //$NON-NLS-1$

				logger.error("generate thumbnail image failed.");
				e.printStackTrace();
			}
		} else {
			logger.warn("the image is not exist.");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("thumbnailImage(File, int, int, String, boolean) - end"); //$NON-NLS-1$
		}
	}
		

	/**
	 * 
	 * @Title: getBetterImage
	 * @Description: TODO
	 * @param @param img
	 * @param @param w
	 * @param @param h
	 * @param @return
	 * @return BufferedImage
	 * @throws
	 */
	private static BufferedImage getBetterImage(Image img, int w, int h) {
		if (logger.isDebugEnabled()) {
			logger.debug("getBetterImage(Image, int, int) - start"); //$NON-NLS-1$
		}

		// 根据原图与要求的缩略图比例，找到最合适的缩略图比例
		int width = img.getWidth(null);
		int height = img.getHeight(null);
		if ((width * 1.0) / w < (height * 1.0) / h) {
			if (width > w) {
				h = Integer.parseInt(new java.text.DecimalFormat("0")
						.format(height * w / (width * 1.0)));
				logger.debug("change image's height, width:{" + w
						+ "}, height:{" + h + "}.");
			}
		} else {
			if (height > h) {
				w = Integer.parseInt(new java.text.DecimalFormat("0")
						.format(width * h / (height * 1.0)));
				logger.debug("change image's height, width:{" + w
						+ "}, height:{" + h + "}.");
			}
		}
		BufferedImage returnBufferedImage = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_RGB);
		if (logger.isDebugEnabled()) {
			logger.debug("getBetterImage(Image, int, int) - end"); //$NON-NLS-1$
		}
		return returnBufferedImage;
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
	private static String getImageEnd(File imgFile, String types) {
		if (logger.isDebugEnabled()) {
			logger.debug("getImageEnd(File, String) - start"); //$NON-NLS-1$
		}

		String suffix = null;
		// 获取图片后缀
		if (imgFile.getName().indexOf(".") > -1) {
			suffix = imgFile.getName().substring(
					imgFile.getName().lastIndexOf(".") + 1);
		}// 类型和图片后缀全部小写，然后判断后缀是否合法
		if (suffix == null
				|| types.toLowerCase().indexOf(suffix.toLowerCase()) < 0) {
			logger.error("Sorry, the image suffix is illegal. the standard image suffix is {}."
					+ types);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getImageEnd(File, String) - end"); //$NON-NLS-1$
		}
		return suffix;
	}

}
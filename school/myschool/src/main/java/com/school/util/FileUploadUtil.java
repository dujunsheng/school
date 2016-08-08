package com.school.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.school.vo.FileUploadVo;


/**
 * @Description 简单的文件上传工具类
 * @Author <wuyiliang 757210697@qq.com>
 * @Date 2015年8月7日 下午1:29:50
 * @CopyRight 2015 TopView Inc
 * @version V1.0
 */
public class FileUploadUtil {

	private static String fileUploadPath = "upload"; // 相对路径的"父"文件夹

	/**
	 * 保存单个文件,返回文件保存的相对路径 
	 * 
	 * @param file
	 * @param path
	 *            文件夹名
	 * @param request
	 * @return
	 */
	public static FileUploadVo uploadFile(MultipartFile file, String path,
			HttpServletRequest request, boolean createFileName) {
		if (file.isEmpty()) {
			return null;
		}
		String projectName = request.getContextPath().substring(1); // 项目名：即
																	// "school"

		String realPath = request.getSession().getServletContext()
				.getRealPath(path);
		realPath = realPath.replace(projectName, fileUploadPath);// 设置文件存储的绝对路径
		String fileName = file.getOriginalFilename();
		if (createFileName) {
			fileName = createFileName(file);
		}
		File file2 = new File(realPath, fileName);
		if (!file2.exists()) {
			file2.mkdirs();
		}
		try {
			file.transferTo(file2); // 保存文件到绝对路径
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		FileUploadVo vo = new FileUploadVo();
		vo.setFileName(fileName);
		vo.setRealPath(realPath);
		vo.setRelativePath("/" + fileUploadPath + "/" + path + "/" + fileName);
		return vo;
	}
	
	
	public static String setThumbnailPath(String path,String fileName){
		if(NotEmptyString.isNotEmpty(new String[] {path,fileName})){
					return "/"+ fileUploadPath + "/" +path + "/thumb/" + fileName;
			}
		return "error";
	}

	/**
	 * 保存文件数组
	 * 
	 * @param files
	 * @param path
	 * @param request
	 * @return
	 */
	public static List<FileUploadVo> uploadFile(MultipartFile[] files,
			String path, HttpServletRequest request, boolean createFileName) {
		List<FileUploadVo> vos = new ArrayList<FileUploadVo>();
		for (MultipartFile file : files) {
			vos.add(uploadFile(file, path, request, createFileName));
		}
		return vos;
	}

	/**
	 * 根据系统时间生成文件名
	 * 
	 * @param file
	 * @return
	 */
	private static String createFileName(MultipartFile file) {
		String tempName = file.getOriginalFilename();
		int index = tempName.lastIndexOf(".");
		tempName = tempName.substring(index, tempName.length()); // 截取文件类型
		return System.currentTimeMillis() + tempName;
	}
}

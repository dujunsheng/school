package com.school.util;

/**
 * 
 * 项目名称：school  <br>
 * 类名称：NameSapceUtil  <br>
 * 类描述：  <br>
 * 创建人：luozhangjie  <br>
 * 创建时间：2015年3月26日 下午8:08:57  <br>
 * 修改人：luozhangjie<br>
 * 修改时间：2015年3月26日 下午8:08:57  <br>
 * 修改备注：  <br>
 * @version 1.0  <br>
 *
 */
public class NameSpaceUtil {

	private static final String PRE_NS = "com.school.mapper";
	
	public static String getNameSpace(String entityClassName){
		return PRE_NS + entityClassName.substring(entityClassName.lastIndexOf(".")) + "Mapper";
	}
	
}

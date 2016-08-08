package com.school.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 
 * 项目名称：baseframework-base <br>
 * 类名称：JSONUtil <br>
 * 类描述：封装json格式数据 <br>
 * 创建人：luozhangjie <br>
 * 创建时间：2015年3月3日 下午6:48:30 <br>
 * 修改人：luozhangjie<br>
 * 修改时间：2015年3月3日 下午6:48:30 <br>
 * 修改备注： <br>
 * 
 * @version 1.0 <br>
 *
 */
public class JSONUtil {

	/**
	 * 
	 * @param object
	 * @param filter
	 *            : 要过滤掉的属性
	 * @return [{"..." : "...", "..." : "..."}]
	 */
	public static JSONArray toArray(Object object, String[] filter) {
		if (filter == null || filter.length == 0) {
			return JSONArray.fromObject(object);
		} else {
			JsonConfig jc = new JsonConfig();
			jc.setExcludes(filter);
			return JSONArray.fromObject(object, jc);
		}
	}

	public static JSONArray toArray(Object object) {
		return toArray(object, null);
	}

	/**
	 * 
	 * @param object
	 * @param filter
	 *            : 要过滤掉的属性
	 * @return {"..." : "...", "..." : "..."}
	 */
	public static JSONObject toObject(Object object, String[] filter) {
		if (filter == null || filter.length == 0) {
			return JSONObject.fromObject(object);
		} else {
			JsonConfig jc = new JsonConfig();
			jc.setExcludes(filter);
			return JSONObject.fromObject(object, jc);
		}
	}

	public static JSONObject toObject(Object object) {
		return toObject(object, null);
	}

	/**
	 * 
	 * @param listKey
	 * @param listValue
	 * @param mapKey
	 * @param mapValue
	 * @param filter
	 *            : 要过滤掉的属性
	 * @return {"listKey" : [...], "mapKey" : {...}}
	 */
	public static JSONObject toObject(String listKey, List<Object> listValue,
			String mapKey, Map<String, Object> mapValue, String[] filter) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (filter == null || filter.length == 0) {
			result.put(listKey, toArray(listValue));
			result.put(mapKey, toObject(mapValue));
			return toObject(result);
		} else {
			result.put(listKey, toArray(listValue, filter));
			result.put(mapKey, toObject(mapValue, filter));
			return toObject(result);
		}
	}

	public static JSONObject toObject(List<Object> listValue,
			Map<String, Object> mapValue, String[] filter) {
		return toObject("list", listValue, "map", mapValue, filter);
	}

	/**
	 * 
	 * @Title: wrap
	 * @Description: TODO
	 * @param @param key
	 * @param @param value
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String wrap(String key, Object value) {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(key, value);

		return toObject(resultMap).toString();
	}
	
	@SuppressWarnings("rawtypes")
	public static Object toBean(String jsonString, Class beanClass) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		return JSONObject.toBean(jsonObject, beanClass);
	}

}

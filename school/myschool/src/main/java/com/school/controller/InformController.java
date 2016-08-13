package com.school.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.po.Inform;
import com.school.po.InformExample;
import com.school.service.impl.InformService;
import com.school.util.DateUtil;

@Controller
public class InformController {
    
    @Resource
    private InformService informService;
    
    /*
     * get请求到发布通知页
     */
    @RequestMapping(value="/inform/release.action",method=RequestMethod.GET)
    public String toRealeaseInform() {
	return "releaseinform";
    }

    /*
     * 发布通知,参数要depName部门名字,在隐藏域传值
     */
    @RequestMapping(value="/inform/release.action",method=RequestMethod.POST)
    public String releaseInform(Inform inform,HttpServletRequest request,Map<String,Object> map) throws UnsupportedEncodingException {
	String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
	String content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
	String depName = new String(request.getParameter("depName").getBytes("ISO-8859-1"),"UTF-8");
	int rank = Integer.parseInt(request.getParameter("rank"));
	
	inform.setRank(rank);
	inform.setPublishTime(new Date());
	inform.setText(content);
	inform.setTitle(title);
	inform.setDepName(depName);
	informService.releaseInform(inform);
	this.getAllinform(map);
	return "redirect:/inform/getall.action";
    }
    
    /*
     * get方法跳到修改界面
     */
    @RequestMapping(value="/inform/update.action",method=RequestMethod.GET)
    public String toUpdateInform(@RequestParam("informId") int informId,Map<String,Object> map) {
	Inform inform = informService.selectInformByPrimaryKey(informId);
	map.put("inform", inform);
	return "updateinform";
    }
    
    /*
     * 执行修改
     */
    @RequestMapping(value="/inform/update.action",method=RequestMethod.POST)
    public String updateInform(HttpServletRequest request,Inform inform,Map<String,Object> map) throws UnsupportedEncodingException {
	String content = request.getParameter("content");
	inform.setPublishTime(new Date());
	inform.setText(content);
	informService.updateInform(inform);
	this.getAllinform(map);
	return "redirect:/inform/getall.action";
    }
    
    /*
     * 根据informid查询inform，参数是 通知的id
     */
//    @ResponseBody
    @RequestMapping("/inform/get.action")
    public String getInform(@RequestParam("informId") int informId,Map<String,Object> map) {
	Inform inform = informService.selectInformByPrimaryKey(informId);
	map.put("inform", inform);
	return "informdetail";
//	return JSONObject.fromObject(inform).toString();
    }
    
    /*
     * 获取所有inform,默认按时间降序
     */
//    @ResponseBody
    @RequestMapping("/inform/getall.action")
    public String getAllinform(Map<String,Object> map) {
	InformExample example = new InformExample();
	example.setOrderByClause("publish_time desc");//降序
	List<Inform> informs = informService.getAllInforms(example);
 	map.put("inform", informs);
	return "inform";
// 	return JSONArray.fromObject(informs).toString();
    }
    
    /*
     * 按等级从高到低查询
     */
    @RequestMapping("/inform/getallbyrank.action")
    public String getInformsByTime(Map<String,Object> map) {
	InformExample example = new InformExample();
	example.setOrderByClause("rank desc");
	List<Inform> informs =  informService.getAllInformByRank(example);
	map.put("inform", informs);
	return "inform";
    }
    
    /*
     * 获取两天内发布的通知
     */
    @RequestMapping("/inform/getlastest.action")
    public String getInformLastest(Map<String,Object> map) {
	InformExample example = new InformExample();
	example.createCriteria().andPublishTimeBetween(DateUtil.getLasetestDate(2), new Date());
	List<Inform> informs = informService.getInformLastest(example);
	map.put("inform", informs);
	return "inform";
    }
    
    /*
     * 删除
     */
    @RequestMapping("/inform/delete.action")
    public String deleteInform(@RequestParam(value="informId",required=true) int informId,Map<String,Object> map) {
	informService.deleteInform(informId);
	return "redirect:/inform/getall.action";
    }
    
    /*
     * 模糊搜索
     */
    @RequestMapping("/inform/search.action")
    public String searchInform(@RequestParam("keyword")String keyword,Map<String,Object> map) throws UnsupportedEncodingException {
	keyword = new String(keyword.getBytes("ISO-8859-1"),"UTF-8");
	InformExample example = new InformExample();
	example.createCriteria().andTitleLike("%" + keyword + "%");
	List<Inform> informs = informService.searchByTitle(example);
	map.put("inform",informs);
	return "inform";
    }
    
}

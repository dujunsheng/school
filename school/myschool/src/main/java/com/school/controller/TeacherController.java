/**
 * 
 */
package com.school.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school.po.Teacher;
import com.school.service.impl.TeacherService;
import com.school.util.GetUrl;
import com.school.util.PageBean;
import com.school.util.PaginationContext;

/**
 * @author c116
 *
 */
@Controller
public class TeacherController {

	@Resource
	private TeacherService teacherService;
	
//	添加老师
	@RequestMapping("/insertTeacher")
	public ModelAndView insertTeacher(HttpServletRequest req, HttpServletResponse resp, Teacher teacher){
		int result = teacherService.insertSelective(teacher);
		if(result == 1){
			return findAllTeacher(req, resp);
		}else{
			ModelAndView modelAndView = new ModelAndView();
			String msg = "删除老师失败";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}
	}
	
//	查询所有老师
	@RequestMapping("findAllTeacher")
	public ModelAndView findAllTeacher(HttpServletRequest req, HttpServletResponse resp){
		PageBean<Teacher> pb = new PageBean<Teacher>();
		ModelAndView modelAndView = new ModelAndView();
		@SuppressWarnings("unchecked")
		List<Teacher> result = teacherService.selectByParameters((Map<String, Object>)req.getParameterMap());
		pb.setBeanList(result);
		pb.setPc(PaginationContext.getPageNum());
		pb.setPs(PaginationContext.getPageSize());
		pb.setUrl(GetUrl.getUrl(req));
		modelAndView.addObject("pb", pb);
		modelAndView.setViewName("/user/page");
		return modelAndView;
	}
	

}

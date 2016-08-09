/**
 * 
 */
package com.school.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school.po.Department;
import com.school.service.impl.DepartmentService;
import com.school.util.CommonUtils;
import com.school.util.GetUrl;
import com.school.util.PageBean;
import com.school.util.PaginationContext;

/**
 * @author c116
 *
 */
@Controller
public class DepartmentController {
	
	@Resource
	private DepartmentService departmentService;
	
//	添加部门
	@RequestMapping("/insertDepartment")
	public ModelAndView insertDepartmrnt(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView modelAndView = new ModelAndView();
		Department department = CommonUtils.toBean(req.getParameterMap(), Department.class);
		int result = departmentService.insertSelective(department);
		if(result ==1 ){
		
			return findAllDepartment(req, resp);
		}else{
			String msg = "添加部门失败";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;	
			}
	}

//	查询所有部门
	@RequestMapping("/findAllDepartment")
	public ModelAndView findAllDepartment(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView modelAndView = new ModelAndView();
		PageBean<Department> pb = departmentService.findAll();
		pb.setPc(PaginationContext.getPageNum());
		pb.setPs(PaginationContext.getPageSize());
		pb.setUrl(GetUrl.getUrl(req));
		modelAndView.addObject("pb", pb);
		modelAndView.setViewName("/user/page");
		return modelAndView;
		
	}
	
//	删除部门
	@RequestMapping("/deleteDepartment")
	public ModelAndView deleteDepartment(HttpServletRequest req, HttpServletResponse resp, String depId){
		ModelAndView modelAndView = new ModelAndView();
		int result = departmentService.deleteByPrimaryKey(depId);
		if(result ==1){
			return findAllDepartment(req, resp);
		}else{
			String msg = "删除部门失败";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}
	}
	
//	根据主键修改部门名字
	@RequestMapping("updateDepartment")
	public ModelAndView updateDepartment(HttpServletRequest req, HttpServletResponse resp, Department department){
		ModelAndView modelAndView = new ModelAndView();
		int result = departmentService.updateByPrimaryKeySelective(department);
		if(result ==1){
			return findAllDepartment(req, resp);
		}else{
			String msg = "修改部门失败";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}
	}
}

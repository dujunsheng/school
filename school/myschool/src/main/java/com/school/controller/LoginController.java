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

import com.school.po.User;
import com.school.service.impl.UserService;
import com.school.util.CommonUtils;

/**
 * @author c116
 *
 */
@Controller
public class LoginController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		User user = CommonUtils.toBean(req.getParameterMap(), User.class);
		User result = userService.selectByUidAndUpw(user);
		if(result != null){
			req.getSession().setAttribute("sessionUser", user);
			String msg = "成功登陆";
			String title = "测试登陆功能";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}
			String msg = "登陆失败";
			String title = "测试登陆功能";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;	
	}
}

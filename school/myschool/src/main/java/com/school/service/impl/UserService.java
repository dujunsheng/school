/**
 * 
 */
package com.school.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.mapper.UserMapper;
import com.school.po.User;
import com.school.service.base.impl.BaseServiceImpl;

/**
 * @author c116
 *
 */
@Service("UserServcie")
public class UserService extends BaseServiceImpl<User> {

	@Resource
	private UserMapper userMapper;
	
	public User selectByUidAndUpw(User user)throws Exception{
		return userMapper.selectByUidAndUpw(user);
	}
	
}

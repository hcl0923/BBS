package com.yc.biz;

import java.util.List;

import com.yc.bean.User;
import com.yc.dao.UserDAO;
/**
 * 用户的业务类
 * @author hp
 *
 */
public class UserBiz {
	UserDAO dao= new UserDAO() ;
	/**
	 * 用户注册
	 * @param u
	 * @return
	 * @throws Exception
	 */
	public int register(User u) throws Exception{
		return dao.add(u);
	}
	/**
	 * 用户登录
	 * @param u
	 * @return
	 * @throws Exception
	 */
	public User login(User u) throws Exception{
		List<User> list=dao.findByTrem(u);
		if(null!=list && list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}

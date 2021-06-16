package com.yc.dao;

import java.util.ArrayList;
import java.util.List;

import com.yc.bean.User;
import com.yc.commons.DbHelper;
/**
 * 用户操作类
 * @author hp
 *
 */
public class UserDAO implements BaseDao<User> {
	DbHelper db = new DbHelper();
	/**
	 * 用户注册
	 */
	@Override
	public int add(User t) throws Exception {
		String sql ="insert into tb_user values(null,?,MD5(?),?,now(),?)";
		return db.update(sql,t.getUname(),t.getUpass(),t.getHead(),t.getGender());
	}
	/**
	 * 查看用户信息
	 */
	@Override
	public List<User> findByTrem(User t) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select uid,uname,upass,head,regtime,gender from tb_user where 1=1 ");
		List<Object> params =null;
		if(null!=t) {
			params=new ArrayList<Object>();
			if(null!=t.getUid()){
				sb.append(" and uid=? ");
				params.add(t.getUid());
			}
			if(null!=t.getUname()){
				sb.append(" and uname =? ");
				params.add(t.getUname());
			}
			if(null!=t.getUpass()){
				sb.append(" and upass=MD5(?) ");
				params.add(t.getUpass());
			}
			if(null!=t.getGender()){
				sb. append(" and gender =? ");
				params.add(t.getGender());
			}
		}
		sb.append(" order by uid desc ");
		return db.findMutipl(sb.toString(),params,User.class);//将封装到user的list中
	}
	@Override
	public int update(User t) throws Exception {
		// TODO 自动生成的方法存根
		return 0;
	}
	@Override
	public int delete(User t) throws Exception {
		// TODO 自动生成的方法存根
		return 0;
	}
			
}

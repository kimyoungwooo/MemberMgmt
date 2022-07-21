package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.UserVo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession sqlsession;

	@Override
	public int create(UserVo user) {
		return this.sqlsession.insert("User.insertUser", user);
	}

	@Override
	public UserVo read(String userid) {
		return this.sqlsession.selectOne("User.selectUser",userid);
	}

	@Override
	public List<UserVo> readAll() {
		return this.sqlsession.selectList("User.seletUserAll", sqlsession);
	}

	@Override
	public int update(UserVo user) {
		return this.sqlsession.update("User.updateUser",user);
	}

	@Override
	public int delete(String userid) {
		return this.sqlsession.delete(userid);
	}

}

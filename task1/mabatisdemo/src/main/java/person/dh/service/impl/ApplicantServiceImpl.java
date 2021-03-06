package person.dh.service.impl;

import org.apache.ibatis.session.SqlSession;

import person.dh.dao.ApplicantDao;
import person.dh.domain.Applicant;
import person.dh.service.ApplicantService;
import person.dh.uitls.MybatisUtils;

public class ApplicantServiceImpl implements ApplicantService {

	public void add(Applicant applicant) {
		SqlSession session = MybatisUtils.openSession();
		try {
			//开启一个数据库会话
			ApplicantDao mapper = session.getMapper(ApplicantDao.class);
			//执行业务
			mapper.add(applicant);
			//提交并关闭会话
			MybatisUtils.commitAndClose(session);
		} catch (Exception e) {
			//发生异常，回滚并关闭会话
			MybatisUtils.rollbackAndClose(session);
			e.printStackTrace();
		}
	}

	public Applicant getApplicant(Integer id) {
		SqlSession session = MybatisUtils.openSession();
		try {
			//开启一个数据库会话
			ApplicantDao mapper = session.getMapper(ApplicantDao.class);
			//执行业务
			Applicant applicant = mapper.getApplicant(id);
			//提交并关闭会话
			MybatisUtils.commitAndClose(session);
			//返回获取的数据
			return applicant;
		} catch (Exception e) {
			//发生异常，回滚并关闭会话
			MybatisUtils.rollbackAndClose(session);
			e.printStackTrace();
		}
		return null;
	}

	public void update(Applicant applicant) {
		SqlSession session = MybatisUtils.openSession();
		try {
			//开启一个数据库会话
			ApplicantDao mapper = session.getMapper(ApplicantDao.class);
			//执行业务
			mapper.update(applicant);
			//提交并关闭会话
			MybatisUtils.commitAndClose(session);
		} catch (Exception e) {
			//发生异常，回滚并关闭会话
			MybatisUtils.rollbackAndClose(session);
			e.printStackTrace();
		}
	}

	public void delete(Applicant applicant) {
		SqlSession session = MybatisUtils.openSession();
		try {
			//开启一个数据库会话
			ApplicantDao mapper = session.getMapper(ApplicantDao.class);
			//执行业务
			mapper.delete(applicant.getId());
			//提交并关闭会话
			MybatisUtils.commitAndClose(session);
		} catch (Exception e) {
			//发生异常，回滚并关闭会话
			MybatisUtils.rollbackAndClose(session);
			e.printStackTrace();
		}
	}

}

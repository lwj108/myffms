package com.ffms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ffms.dao.OutcomeDao;
import com.ffms.entity.FfmsResult;
import com.ffms.entity.Outcome;
import com.ffms.service.OutcomeService;
@Service
@Transactional
public class OutcomeServiceImpl implements OutcomeService{

	@Autowired
	private OutcomeDao outcomeDao;
	
	/**
	 * ����֧��
	 */
	public FfmsResult loadOutcome() {
		FfmsResult result = new FfmsResult();
		List<Outcome> list = outcomeDao.findAll();
		
		result.setData(list);
		result.setStatus(0);
		result.setMsg("����֧���ɹ�");
		return result;
	}

	/**
	 * ɾ��֧��
	 */
	public FfmsResult deleteOutcome(int oid) {
		FfmsResult result = new FfmsResult();
		outcomeDao.delete(oid);
		result.setStatus(0);
		result.setMsg("ɾ��֧���ɹ�");
		return result;
	}

	/**
	 * �޸�֧��
	 */
	public FfmsResult update(int oid,String name, String otype, String oname,
			String money, String oway, String time) {
		FfmsResult result = new FfmsResult();
		Outcome outcome = new Outcome();
		outcome.setOid(oid);
		outcome.setName(name);
		outcome.setOtype(otype);
		outcome.setOname(oname);
		outcome.setMoney(money);
		outcome.setOway(oway);
		outcome.setTime(time);
		outcomeDao.update(outcome);
		result.setStatus(0);
		result.setMsg("�޸�֧���ɹ�");
		result.setData(outcome);
		return result;
	}

	/**
	 * ���֧��
	 */
	public FfmsResult create(String name, String otype, String oname,
			String money, String oway, String time) {
		FfmsResult result = new FfmsResult();
		Outcome outcome = new Outcome();
		outcome.setName(name);
		outcome.setOtype(otype);
		outcome.setOname(oname);
		outcome.setMoney(money);
		outcome.setOway(oway);
		outcome.setTime(time);
		outcomeDao.add(outcome);
		result.setStatus(0);
		result.setData("����֧���ɹ�");
		result.setData(name);
		return result;
	}

	/**
	 * �ϼ�֧��
	 */
	public FfmsResult sum() {
		FfmsResult result = new FfmsResult();
		 
		result.setStatus(0);
		result.setMsg("�ϼƽ��");
		result.setData(outcomeDao.sum());
		return result;
	}

	/**
	 * ����Ա����ѯ
	 */
	public FfmsResult findbyname(String name) {
		FfmsResult result = new FfmsResult();
		List<Outcome> list = outcomeDao.findbyname(name);
		if (list.size() > 0) {
			result.setStatus(0);
			result.setMsg("��ѯ�����");
			result.setData(list);
		} else {
			result.setStatus(1);
			result.setMsg("δ��ѯ�����");
		}
		
		return result;
	}

	/**
	 * ��ʱ���ѯ
	 */
	public FfmsResult findbytime(String starttime, String endtime) {
		FfmsResult result = new FfmsResult();
		List<Outcome> list = outcomeDao.findbytime(starttime, endtime);
		System.out.println(1);
		if (list.size() > 0) {
			result.setStatus(0);
			result.setMsg("��ѯ�����");
			result.setData(list);
		} else {
			result.setStatus(1);
			result.setMsg("δ��ѯ�����");
		}
		return result;
	}

	/**
	 * ���ݳ�Ա���ϼƽ��
	 */
	public FfmsResult sumbyname(String name) {
		FfmsResult result = new FfmsResult();

		result.setStatus(0);
		result.setMsg("���ݳ�Ա�ϼƽ��");
		result.setData(outcomeDao.sumbyname(name));
		return result;
	}

	/**
	 * ����ʱ��ϼƽ��
	 */
	public FfmsResult sumbytime(String starttime, String endtime) {
		FfmsResult result = new FfmsResult();

		result.setStatus(0);
		result.setMsg("����ʱ��ϼƽ��");
		result.setData(outcomeDao.sumbytime(starttime,endtime));
		return result;
	}

	/**
	 * �������Ͳ�ѯ
	 */
	public FfmsResult findbytype(String otype) {
		FfmsResult result = new FfmsResult();
		List<Outcome> list = outcomeDao.findbytype(otype);
		if (list.size() > 0) {
			result.setStatus(0);
			result.setMsg("��ѯ�����");
			result.setData(list);
		} else {
			result.setStatus(1);
			result.setMsg("δ��ѯ�����");
		}
		
		return result;
	}

	/**
	 * �������ͺϼƽ��
	 */
	public FfmsResult sumbytype(String otype) {
		FfmsResult result = new FfmsResult();

		result.setStatus(0);
		result.setMsg("���ݳ�Ա�ϼƽ��");
		result.setData(outcomeDao.sumbytype(otype));
		return result;
	}

}

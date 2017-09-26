package com.ffms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ffms.dao.IncomeDao;
import com.ffms.entity.FfmsResult;
import com.ffms.entity.Income;
import com.ffms.service.IncomeService;

@Service
@Transactional
public class IncomeServiceImpl implements IncomeService {

	@Autowired
	private IncomeDao incomeDao;

	/**
	 * ��������
	 */
	public FfmsResult loadIncome() {
		FfmsResult result = new FfmsResult();
		List<Income> list = incomeDao.findAll();
		
//		PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
//        List<Income> list2 = this.IncomeMap.getUserByNoAndEmail(list);
		
		result.setData(list);
		result.setStatus(0);
		result.setMsg("��������ɹ�");
		return result;

	}

	/**
	 * �����������ͽ��
	 */
	public FfmsResult loadtable() {
		FfmsResult result = new FfmsResult();
		List<Income> list = incomeDao.find();
		result.setData(list);
		result.setStatus(0);
		result.setMsg("�����������ͽ��ɹ�");
		return result;
	}

	/**
	 * ɾ������
	 */
	public FfmsResult deleteIncome(int iid) {
		FfmsResult result = new FfmsResult();
		incomeDao.delete(iid);
		result.setStatus(0);
		result.setMsg("ɾ������ɹ�");
		return result;
	}

	/**
	 * �޸�����
	 */
	public FfmsResult update(int iid,String name, String itype, String iname,
			String money, String iway, String time) {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
//		Date date = null;
//		try {
//			date = sdf.parse(time);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		FfmsResult result = new FfmsResult();
		Income income = new Income();
		income.setIid(iid);
		income.setName(name);
		income.setItype(itype);
		income.setIname(iname);
		income.setMoney(money);
		income.setIway(iway);
		income.setTime(time);
		incomeDao.update(income);

		result.setData(income);
		result.setStatus(0);
		result.setMsg("�޸�����ɹ�");
		return result;
	}

	/**
	 * �������
	 */
	public FfmsResult create(String name, String itype, String iname,
			String money, String iway, String time) {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
//		Date date = null ;
//		try {
//			date = sdf.parse(time);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		} 
		FfmsResult result = new FfmsResult();
		Income income = new Income();
		income.setName(name);
		income.setItype(itype);
		income.setIname(iname);
		income.setMoney(money);
		income.setIway(iway);
		income.setTime(time);
		incomeDao.add(income);
		result.setStatus(0);
		result.setData("��������ɹ�");
		result.setData(income);
		return result;
	}

	/**
	 * ����ϼ�
	 */
	public FfmsResult sum() {
		FfmsResult result = new FfmsResult();

		result.setStatus(0);
		result.setMsg("�ϼƽ��");
		result.setData(incomeDao.sum());
		return result;
	}

	/**
	 * ����Ա����ѯ
	 */
	public FfmsResult findbyname(String name) {
		FfmsResult result = new FfmsResult();
		List<Income> list = incomeDao.findbyname(name);
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
		result.setData(incomeDao.sumbyname(name));
		return result;
	}

	/**
	 * ��ʱ���ѯ
	 */
	public FfmsResult findbytime(String starttime,String endtime) {
		FfmsResult result = new FfmsResult();
		List<Income> list = incomeDao.findbytime(starttime, endtime);
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
	 * ����ʱ��ϼƽ��
	 */
	public FfmsResult sumbytime(String starttime, String endtime) {
		FfmsResult result = new FfmsResult();

		result.setStatus(0);
		result.setMsg("����ʱ��ϼƽ��");
		result.setData(incomeDao.sumbytime(starttime,endtime));
		return result;
	}

	/**
	 * �������Ͳ�ѯ
	 */
	public FfmsResult findbytype(String itype) {
		FfmsResult result = new FfmsResult();
		List<Income> list = incomeDao.findbytype(itype);
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
	public FfmsResult sumbytype(String itype) {
		FfmsResult result = new FfmsResult();

		result.setStatus(0);
		result.setMsg("�������ͺϼƽ��");
		result.setData(incomeDao.sumbytype(itype));
		return result;
	}

//	public PagedResult<Income> queryByPage(Integer pageNo, Integer pageSize) {
//		pageNo = pageNo == null?1:pageNo;
//		pageSize = pageSize == null?10:pageSize;
//		
//		PageHelper.startPage(pageNo,pageSize);  //startPage�Ǹ���������˵��Ҫ��ʼ��ҳ�ˡ���ҳ��������������
//		
//		return BeanUtil.toPagedResult(incomeDao.findAll());
//	}

	

}

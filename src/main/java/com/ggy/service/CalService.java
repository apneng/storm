package com.ggy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggy.dao.CalMapper;
import com.ggy.pojo.Cal;

@Service
public class CalService {
	@Autowired
	private CalMapper calMapper;

	/**判断日程是否存在
	 * @return
	 */
	public boolean isExist(String calid){
		Integer a = this.calMapper.isExist(calid);
		if(a==null || a < 1){
			return false;
		}
		return true;
		
	}

	public int insert(Cal cal) {
		// TODO Auto-generated method stub
		System.out.println(cal.toString());
		return this.calMapper.insert(cal);
	}

	public int update(Cal cal) {
		// TODO Auto-generated method stub
		return this.calMapper.updateByPrimaryKey(cal);
	}

}

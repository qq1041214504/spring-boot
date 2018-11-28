package cn.servcie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dao.TestMapper;
import cn.entity.TestTable;
import cn.servcie.TestService;
@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestMapper testMapper;
	@Override
	public List<TestTable> getAll() {
		// TODO Auto-generated method stub
		return testMapper.getAll();
	}
	@Override
	public boolean add(TestTable testTable) {
		if(testMapper.add(testTable)>0){
			return true;
		}
			return false;
	}
	

}

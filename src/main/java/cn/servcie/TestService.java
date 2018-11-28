package cn.servcie;

import java.util.List;

import cn.entity.TestTable;

public interface TestService {
	public List<TestTable> getAll();
	public boolean add(TestTable testTable);
}

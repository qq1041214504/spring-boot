package cn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.entity.TestTable;
@Mapper
public interface TestMapper {
		
		public List<TestTable> getAll();
		
		public int add(TestTable testTable);
}

package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer employeeid);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer employeeid);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    
    /**
     * 查询所有员工的部分信息
     * @param employee
     * @return
     */
    List<Employee> selectEmployee(Employee employee);
}
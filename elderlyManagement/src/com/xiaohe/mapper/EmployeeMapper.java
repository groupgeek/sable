package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Employee;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.UserCustom;

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
    
    
    /**
     * 查询员工信息
     * @param condition
     * @return
     */
    List<EmployeeCustom> selectAllEmployeeByCondition(EmployeeCustom condition);
    
    /**
     * 查询员工数量
     * @param condition
     * @return
     */
    Integer selectAllEmployeeSumByCondition(EmployeeCustom condition);
    
    /**
     * 查询员工的所有信息
     * @param id
     * @return
     */
    EmployeeCustom selectEmployeeInfoById(Integer id);
}
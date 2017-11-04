package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.CeoEmployee;
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
    
    /**
     * 根据管理员 的id查询到对应的分店下面的员工（根据冠利元id，分店的所有员工）
     * @param id
     * @return
     */
    List<EmployeeCustom> allBrancheEmployees(Integer id);
    
    /**
     * 根据传进来的员工扩展类修改员工信息
     * @param employeeCustom
     * @return
     */
    int updateByCustom(EmployeeCustom employeeCustom);

    /**
     * 通过id查询员工的全部信息
     * @param employeeid
     * @return
     */
    CeoEmployee selectEmployeeAll(Integer employeeid);

    /**
     * 通过分店id查询分店员工
     * @param branchid
     * @return
     */
    List<CeoEmployee> selectBranchEmployee();
}
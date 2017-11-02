package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Employee;
import com.xiaohe.bean.EmployeeCustom;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer employeeid);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer employeeid);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    

    /**
     * 根据管理员 的id查询到对应的分店下面的员工（根据冠利元id，分店的所有员工）
     * @param id
     * @return
     */
    List<EmployeeCustom> allBrancheEmployees(Integer id);
}
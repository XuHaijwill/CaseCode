package com.xhjc.spingbootdemo.mapper;

import com.xhjc.spingbootdemo.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @Author xhj
 * @Description //TODO
 * @Date 2019-07-02 10:21
 **/
@Mapper
public interface DepartmentMapper {
    @Insert("insert into department(dept_name) value(#{deptName})")
    public int insertDept(Department department);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Update("update department set dept_Name=#{deptName} where id=#{id}")
    public int updateDept(Department department);

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);
}

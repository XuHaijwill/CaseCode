package com.xhjc.spingbootdemo.bean;

/**
 * @Author xhj
 * @Description //TODO
 * @Date 2019-07-02 10:18
 **/
public class Department {
    private Integer id;
    private String deptName;

    public Department(){

    }

    public Department(Integer id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}

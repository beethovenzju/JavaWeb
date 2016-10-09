package com.employee.action;

import com.employee.domain.Department;
import com.employee.domain.PageBean;
import com.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 部门管理的Action类
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	private Department deparement = new Department();
	
	//注入部门管理的service类
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return deparement;
	}
	
	private Integer currPage = 1;

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	//提供一个查询的方法
	public String findAll(){
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//将pageBean存入值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//跳转到添加部门的页面的方法
	public String saveUI(){
		return "saveUI";
	}
	
	//添加部门的执行方法
	public String save(){
		departmentService.save(deparement);
		return "saveSuccess";
	}
	
	//编辑部门执行的方法
	public String edit(){
		deparement = departmentService.findById(deparement.getDid());
		return "editSuccess";
	}
	
	//修改部门的执行的方法
	public String update(){
		departmentService.update(deparement);
		return "updateSuccess";
	}
	
	//删除部门的执行方法
	public String delete(){
		deparement = departmentService.findById(deparement.getDid());
		departmentService.delete(deparement);
		return "deleteSuccess";
	}
}

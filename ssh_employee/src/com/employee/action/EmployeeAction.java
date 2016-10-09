package com.employee.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.employee.domain.Department;
import com.employee.domain.Employee;
import com.employee.domain.PageBean;
import com.employee.service.DepartmentService;
import com.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 员工管理的action类
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

	//模型驱动使用的对象
	private Employee employee = new Employee();
	
	//注入Service层的类
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//注入DepartmentAction层的类
	private DepartmentService departmentService;
	

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	//当前页数
	private int currPage = 1;
	
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	@Override
	public Employee getModel() {
		return employee;
	}
	
	/*
	 * 登陆执行的方法
	 */
	public String login(){
		System.out.println("longin执行了....");
		//调用业务层的方法
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null){
			this.addActionError("用户名或密码错误");
			return INPUT;
		}
		else{
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}

	//分页显示所有员工信息
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//跳转到添加员工页面执行的方法
	public String saveUI(){
		//查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	//保存员工的执行方法
	public String save(){
		Department depart =  departmentService.findById(employee.getDepartment().getDid());
		employee.setDepartment(depart);
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	//修改员工的执行方法
	public String edit(){
		//根据员工ID查询员工
		employee = employeeService.findById(employee.getEid());
		
		//查询所有部门
		List<Department> list = departmentService.findAll();
		
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	
	//修改员工执行的方法
	public String update(){
		Department depart =  departmentService.findById(employee.getDepartment().getDid());
		employee.setDepartment(depart);
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	//删除员工的执行方法
	public String delete(){
		//根据员工ID查询员工
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}

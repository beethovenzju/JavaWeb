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
 * Ա�������action��
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

	//ģ������ʹ�õĶ���
	private Employee employee = new Employee();
	
	//ע��Service�����
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//ע��DepartmentAction�����
	private DepartmentService departmentService;
	

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	//��ǰҳ��
	private int currPage = 1;
	
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	@Override
	public Employee getModel() {
		return employee;
	}
	
	/*
	 * ��½ִ�еķ���
	 */
	public String login(){
		System.out.println("longinִ����....");
		//����ҵ���ķ���
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null){
			this.addActionError("�û������������");
			return INPUT;
		}
		else{
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}

	//��ҳ��ʾ����Ա����Ϣ
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//��ת�����Ա��ҳ��ִ�еķ���
	public String saveUI(){
		//��ѯ���в���
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	//����Ա����ִ�з���
	public String save(){
		Department depart =  departmentService.findById(employee.getDepartment().getDid());
		employee.setDepartment(depart);
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	//�޸�Ա����ִ�з���
	public String edit(){
		//����Ա��ID��ѯԱ��
		employee = employeeService.findById(employee.getEid());
		
		//��ѯ���в���
		List<Department> list = departmentService.findAll();
		
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	
	//�޸�Ա��ִ�еķ���
	public String update(){
		Department depart =  departmentService.findById(employee.getDepartment().getDid());
		employee.setDepartment(depart);
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	//ɾ��Ա����ִ�з���
	public String delete(){
		//����Ա��ID��ѯԱ��
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}

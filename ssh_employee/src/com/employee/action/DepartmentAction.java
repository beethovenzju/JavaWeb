package com.employee.action;

import com.employee.domain.Department;
import com.employee.domain.PageBean;
import com.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * ���Ź����Action��
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	private Department deparement = new Department();
	
	//ע�벿�Ź����service��
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
	
	//�ṩһ����ѯ�ķ���
	public String findAll(){
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//��pageBean����ֵջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//��ת����Ӳ��ŵ�ҳ��ķ���
	public String saveUI(){
		return "saveUI";
	}
	
	//��Ӳ��ŵ�ִ�з���
	public String save(){
		departmentService.save(deparement);
		return "saveSuccess";
	}
	
	//�༭����ִ�еķ���
	public String edit(){
		deparement = departmentService.findById(deparement.getDid());
		return "editSuccess";
	}
	
	//�޸Ĳ��ŵ�ִ�еķ���
	public String update(){
		departmentService.update(deparement);
		return "updateSuccess";
	}
	
	//ɾ�����ŵ�ִ�з���
	public String delete(){
		deparement = departmentService.findById(deparement.getDid());
		departmentService.delete(deparement);
		return "deleteSuccess";
	}
}

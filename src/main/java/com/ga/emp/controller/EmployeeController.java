package com.ga.emp.controller;

import static com.ga.emp.constant.ResponseMessages.ADD_EMPLOYEE_SUCCESS;
import static com.ga.emp.constant.ResponseMessages.DELETE_EMPLOYEE_SUCCESS;
import static com.ga.emp.constant.ResponseMessages.FETCH_EMPLOYEE_SUCCESS;
import static com.ga.emp.constant.ResponseMessages.UPDATE_EMPLOYEE_SUCCESS;
import static com.ga.emp.constant.ResponseMessages.NO_USERS_FOUND;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ga.emp.Service.EmployeeService;
import com.ga.emp.model.EmployeeModel;
import com.ga.emp.model.ResponseBean;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	public ResponseBean addEmployee(@RequestBody EmployeeModel employeeModel) {
		EmployeeModel emp = employeeService.addEmp(employeeModel);
		return new ResponseBean(true, ADD_EMPLOYEE_SUCCESS, emp, null);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/fetch")
	public ResponseBean getEmployee() {
		Map<String, Object> emp = employeeService.getEmp();
		List<EmployeeModel> employees = (List<EmployeeModel>) emp.get("employees");
		return new ResponseBean(true, employees.isEmpty() ? NO_USERS_FOUND : FETCH_EMPLOYEE_SUCCESS, emp, null);

	}

	@GetMapping("/fetchById")
	public ResponseBean getEmployeeById(@RequestParam Long empId) {
		EmployeeModel emp = employeeService.getEmpById(empId);
		return new ResponseBean(true, FETCH_EMPLOYEE_SUCCESS, emp, null);
	}

	@PutMapping("/update")
	public ResponseBean updateEmployee(@RequestBody EmployeeModel employeeModel) {
		EmployeeModel emp = employeeService.updateEmployee(employeeModel);
		return new ResponseBean(true, UPDATE_EMPLOYEE_SUCCESS, emp, null);
	}

	@DeleteMapping("/remove")
	public ResponseBean deleteEmployee(@RequestParam Long empId) {
		employeeService.deleteEmployee(empId);
		return new ResponseBean(true, DELETE_EMPLOYEE_SUCCESS, null);
	}
}
package com.ga.emp.Service;

import java.util.List;
import java.util.Map;

import com.ga.emp.model.EmployeeModel;

public interface EmployeeService {

	EmployeeModel addEmp(EmployeeModel employeeModel);

	Map<String, Object> getEmp();

	EmployeeModel getEmpById(Long empId);

	EmployeeModel updateEmployee(EmployeeModel employeeModel);

	void deleteEmployee(Long empId);

}

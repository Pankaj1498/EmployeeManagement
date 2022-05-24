package com.ga.emp.serviceImpl;

import java.util.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ga.emp.Service.EmployeeService;
import com.ga.emp.model.EmployeeModel;
import com.ga.emp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeModel addEmp(EmployeeModel employeeModel) {
		employeeRepository.save(employeeModel);
		return employeeModel;
	}

	@Override
	public Map<String, Object> getEmp() {
		List<EmployeeModel> employeeModels = employeeRepository.findAll();
		Long empCount = getCountOfEntities();
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("employees", employeeModels);
		result.put("count", employeeModels.size() + "/" + empCount);
		return result;
	}

	@Override
	public EmployeeModel getEmpById(Long empId) {
		return employeeRepository.findById(empId).orElse(null);
	}

	@Override
	public EmployeeModel updateEmployee(EmployeeModel employeeModel) {
		EmployeeModel exisitingEmployee = employeeRepository.findById(employeeModel.getEmpId()).orElse(null);
		exisitingEmployee.setFirstName(employeeModel.getFirstName());
		exisitingEmployee.setLastName(employeeModel.getLastName());
		exisitingEmployee.setEmail(employeeModel.getEmail());
		exisitingEmployee.setRoles(employeeModel.getRoles());
		return employeeRepository.save(exisitingEmployee);

	}

	@Override
	public void deleteEmployee(Long empId) {
		try {
			if (nonNull(empId)) {
				employeeRepository.deleteById(empId);
			}
		} catch (EntityNotFoundException e) {
			System.out.println("Employee Not present");
		}

	}

	@Transactional(readOnly = true)
	public long getCountOfEntities() {
		long count = employeeRepository.count();
		return count;

	}
}

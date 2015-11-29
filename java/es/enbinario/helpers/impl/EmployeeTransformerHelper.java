package es.enbinario.helpers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.enbinario.helpers.EmployeeTransformerHelp;
import es.enbinario.model.Employee;
import es.enbinario.negocio.EmployeeDTO;

@Component
public class EmployeeTransformerHelper implements EmployeeTransformerHelp {

	public List<Employee> dtoToEntityList(List<EmployeeDTO> dtoList){
		List<Employee> employeeList = new ArrayList<>();
		
		for (EmployeeDTO employeeDto : dtoList) {
			employeeList.add(dtoToEntity(employeeDto));
		}
		
		return employeeList;
	}
	
	public List<EmployeeDTO> EntityToDtoList(List<Employee> list){
		List<EmployeeDTO> employeeDtoList = new ArrayList<>();
		
		for (Employee employee : list) {
			employeeDtoList.add(entityToDto(employee));
		}
		
		return employeeDtoList;
	}
	
	public Employee dtoToEntity(EmployeeDTO employeeDTO){
		Employee employee = null;
		if(employeeDTO != null){
			employee = new Employee();
			if(employeeDTO.getEmail() != null){
				employee.setEmail(employeeDTO.getEmail());
			}
			if(employeeDTO.getFirstName() != null){
				employee.setFirstName(employeeDTO.getFirstName());
			}
			employee.setId(new Long(employeeDTO.getId()));
			if(employeeDTO.getLastName() != null){
				employee.setLastName(employeeDTO.getLastName());
			}
			if(employeeDTO.getPhone() != null){
				employee.setPhone(employeeDTO.getPhone());
			}
			if(employeeDTO.getEmail() != null){
				employee.setEmail(employeeDTO.getEmail());
			}
		}
		return employee;
	}
	
	public EmployeeDTO entityToDto(Employee employee){
		EmployeeDTO employeeDTO = null;
		if(employee != null){
			employeeDTO = new EmployeeDTO();
			if(employee.getEmail() != null){
				employeeDTO.setEmail(employee.getEmail());
			}
			if(employee.getFirstName() != null){
				employeeDTO.setFirstName(employee.getFirstName());
			}
			employeeDTO.setId(new Long(employee.getId()));
			if(employee.getLastName() != null){
				employeeDTO.setLastName(employee.getLastName());
			}
			if(employee.getPhone() != null){
				employeeDTO.setPhone(employee.getPhone());
			}
			if(employee.getEmail() != null){
				employeeDTO.setEmail(employee.getEmail());
			}
		}
		return employeeDTO;
	}
}

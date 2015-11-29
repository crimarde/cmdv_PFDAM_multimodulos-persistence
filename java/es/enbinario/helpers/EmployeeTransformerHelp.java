package es.enbinario.helpers;

import java.util.List;

import es.enbinario.model.Employee;
import es.enbinario.negocio.EmployeeDTO;

public interface EmployeeTransformerHelp {
	public EmployeeDTO entityToDto(Employee employee);
	public Employee dtoToEntity(EmployeeDTO employeeDTO);	
	public List<EmployeeDTO> EntityToDtoList(List<Employee> list);
	public List<Employee> dtoToEntityList(List<EmployeeDTO> dtoList);
}
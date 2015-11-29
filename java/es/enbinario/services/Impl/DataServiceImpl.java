package es.enbinario.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.enbinario.dao.DataDAO;
import es.enbinario.helpers.EmployeeTransformerHelp;
import es.enbinario.model.Employee;
import es.enbinario.negocio.EmployeeDTO;
import es.enbinario.services.DataService;

@Service
@Transactional(readOnly=true)
public class DataServiceImpl implements DataService {
	
	@Autowired
	@Qualifier("dataDAOImpl")
	DataDAO dataDao;

	@Autowired
	private EmployeeTransformerHelp transformer;
	
	@Override
	@Transactional(readOnly=false)
	public long insertRow(Employee employee) {
		return dataDao.insertRow(employee);
	}

	@Override
	public List<EmployeeDTO> getList() {
		List<Employee> employeeList = new ArrayList<>();
		List<EmployeeDTO> employeeDtoList = new ArrayList<>();
		
		employeeList = dataDao.getList();
		employeeDtoList.addAll(transformer.EntityToDtoList(employeeList));
		
		return employeeDtoList;
	}

	@Override
	public EmployeeDTO getRowById(long id) {
		return  transformer.entityToDto(dataDao.getRowById(id));
	}

	@Override
	@Transactional(readOnly=false)
	public void updateRow(EmployeeDTO employeeDTO) {
		dataDao.updateRow(transformer.dtoToEntity(employeeDTO));
	}

	@Override
	@Transactional(readOnly=false)
	public long deleteRow(long id) {
		return dataDao.deleteRow(id);
	}
	
	@Override
	public boolean checkDuplicateInsert(EmployeeDTO empDTO) {
		// true si hay un duplicado
		return (dataDao.checkDuplicateInsert(transformer.dtoToEntity(empDTO)) != null) ? true : false ;
	}

}

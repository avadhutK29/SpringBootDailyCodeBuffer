package com.avadhut.service;

import java.util.List;

import com.avadhut.entity.Department;
/**
 * @author AVADHUT KUMBHAR
 *
 */
public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> getAllDepartments();

	public Department getDepartmentById(Long departmentId);

	public String deleteDepartment(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public String saveListOfDepartment(List<Department> departments);

	public Department findByDepartmentName(String dName);

	public Department findByDepartmentId(Long id);

	public Department getDemartmentByNameUsingNativeQuery(String name);

}

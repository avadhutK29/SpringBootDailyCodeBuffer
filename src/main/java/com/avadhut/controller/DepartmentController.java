package com.avadhut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avadhut.entity.Department;
import com.avadhut.repository.DepartmentRepository;
import com.avadhut.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private DepartmentRepository depRepo;

	@PostMapping("saveDepartment")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

	@PostMapping("saveListOfDepartment")
	public String saveListOfDepartment(@RequestBody List<Department> departments) {
		String msg = "";
		try {
			msg = departmentService.saveListOfDepartment(departments);
		} catch (Exception e) {
			System.out.println("Exception in saveListOfDepartment" + e);
			e.printStackTrace();
		}
		return msg;
	}

	@GetMapping("getAllDepartments")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	@GetMapping("getDepartmentById/{id}")
	public Department getDepartmentById(@PathVariable("id") Long departmentId) {
		return departmentService.getDepartmentById(departmentId);
	}

	@DeleteMapping("deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable("id") Long departmentId) {
		return departmentService.deleteDepartment(departmentId);
	}

	@PutMapping("updateDepartment/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId, department);
	}

	@GetMapping("getDepartmentByName/{dName}")
	public Department getDepartmentByName(@PathVariable String dName) {
		return departmentService.findByDepartmentName(dName);
	}

	@GetMapping("departmentById/{id}")
	public Department departmentById(@PathVariable Long id) {
		return departmentService.findByDepartmentId(id);
	}

	/**
	 * Method to demonstrate @Query Annotation to use native SQL
	 * @param name
	 * @return Department
	 */
	@GetMapping("getDemartmentByNameUsingNativeQuery/{name}")
	public Department getDemartmentByNameUsingNativeQuery(@PathVariable String name) {
		return departmentService.getDemartmentByNameUsingNativeQuery(name);
	}
}

package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.EmployerService;
import domain.Employee;
import domain.Employer;

@RestController
public class EmployerController {
	
	
	@Autowired
	private EmployerService employerService;

	
	@RequestMapping("/getEmployers")
	public List<Employer> getEmployers() {
		return employerService.getEmployers();
	}
	
	
	@RequestMapping("/deleteEmployer")
	public void deleteEmployer(@RequestParam int employerId) {
		employerService.deleteEmployer(employerId);
	}

	@RequestMapping(value="/addEmployer",method=RequestMethod.POST) 
	public ResponseEntity<Employer> addEmployer(@RequestBody Employer employer) {
		Employer returnEMployer =null;
		if(employer != null) {
			returnEMployer = employerService.addEmployer(employer);
		}
		return new ResponseEntity<Employer>(returnEMployer, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addEmployee/{employerId}",method=RequestMethod.POST)
	public void addEmployee(@RequestBody Employee employee, @PathVariable int employerId) {
		employerService.addEmployee(employee, employerId);
	}
	
	@RequestMapping("/getEmployeesByEmployer/{employerId}")
	public List<Employee> getEmployeesByEmployer(@PathVariable int employerId) {
		return employerService.getEmployeeByEmployer(employerId);
	}
	
	@RequestMapping("/getAllEmployees")
	public List<Employee> getEmployees() {
		return employerService.getAllEmployees();
	}
}

package service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import domain.Employee;
import domain.Employer;

@Service
public class EmployerService {
	
	private List<Employer> employers = new ArrayList<Employer>();

	public EmployerService() {
		
		Employer employer1 = new Employer();
		employer1.setCity("Noida");
		employer1.setName("hCentive");
		employer1.setId(0);
		List<Employee> employees1 = new ArrayList<Employee>();
		Employee employee1 = new Employee();
		employee1.setDob(new GregorianCalendar(1990,6,6).getTime());
		employee1.setFullName("Robert Woods");
		employee1.setSsn("89997987");
		employee1.setEmployerName(employer1.getName());
		employees1.add(employee1);
		Employee employee2 = new Employee();
		employee2.setDob(new GregorianCalendar(1970,2,6).getTime());
		employee2.setFullName("Kia Federer");
		employee2.setSsn("99917987");
		employee2.setEmployerName(employer1.getName());
		employees1.add(employee2);
		employer1.setEmployees(employees1);
		employers.add(employer1);
		
		Employer employer2 = new Employer();
		employer2.setCity("Mountain View");
		employer2.setName("Google");
		employer2.setId(1);
		List<Employee> employees3 = new ArrayList<Employee>();
		Employee employee3 = new Employee();
		employee3.setDob(new GregorianCalendar(1990,6,6).getTime());
		employee3.setFullName("Robert Woods");
		employee3.setSsn("89997987");
		employee3.setEmployerName(employer2.getName());
		employees3.add(employee3);
		employer2.setEmployees(employees3);
		employers.add(employer2);
		Employer employer3 = new Employer();
		employer3.setCity("Redmond");
		employer3.setName("Washington");
		employer3.setId(2);
		employers.add(employer3);
		Employer employer4 = new Employer();
		employer4.setCity("San Francisco");
		employer4.setName("Sales Force");
		employer4.setId(3);
		employers.add(employer4);
		Employer employer5 = new Employer();
		employer5.setCity("Seattle");
		employer5.setName("Amazon");
		employer5.setId(4);
		employers.add(employer5);
		Employer employer6 = new Employer();
		employer6.setCity("Cupertino");
		employer6.setName("Apple");
		employer6.setId(5);
		employers.add(employer6);
		System.out.println("Employer Service initiated");
	}
	
	public List<Employer> getEmployers() {
		return employers;
 	}
	
	public synchronized void deleteEmployer(int employerId) {
		Iterator<Employer> iterator = employers.iterator();
		while(iterator.hasNext()) {
			Employer empl = iterator.next();
			if(empl.getId() == employerId) {
				iterator.remove();
			}
			
		}
	}
	
	public synchronized Employer addEmployer(Employer employer) {
		employer.setId(employers.size());
		employers.add(employer);
		return employer;
	}
	
	public void addEmployee(Employee employee, int employerId) {
		if(this.employers != null && !this.employers.isEmpty()) {
			for(Employer employer : employers) {
				if(employer.getId() == employerId ) {
					if(employer.getEmployees() != null) {
						employer.getEmployees().add(employee);
					} else {
						List<Employee> employees = new ArrayList<Employee>();
						employees.add(employee);
						employer.setEmployees(employees);
					}
					break;
				}
			}
		}
	}
	
	public List<Employee> getEmployeeByEmployer(int id) {
		List<Employee> employees = new ArrayList<Employee>();
		if(this.employers != null && !this.employers.isEmpty()) {
			for(Employer employer : employers) {
				if(employer.getId() == id  && employer.getEmployees() != null && !employer.getEmployees().isEmpty() ) {
					for(Employee employee : employer.getEmployees()) {
						employees.add(employee);
					}
					break;
				}
			}
		}
		return employees;
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		if(this.employers != null && !this.employers.isEmpty()) {
			for(Employer employer : employers) {
				if(employer.getEmployees() != null && !employer.getEmployees().isEmpty()) {
					for(Employee employee : employer.getEmployees()) {
						employees.add(employee);
					}
				}
			}
		}
		return employees;
	}
	
}

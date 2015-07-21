package com.molavec.jpa.simple;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * This class uses JPA (eclipse provider) to build 
 * a Employee table, persist an employee into database,
 * find it, list all employees, update and remove the employee.
 * 
 * Check META-INF/persistence.xml to create a database in mysql.
 * 
 * Note: "eclipselink.ddl-generation" is used to create tables.
 * 
 * Commands Example:
 * 
 *  CREATE DATABASE jpa_test;
 *  CREATE USER 'jpa_user'@'localhost' IDENTIFIED BY 'jpa_pass'
 *  GRANT ALL ON jpa_test.* to 'jpa_user'@'localhost'
 *  
 * 
 * @author angel
 *
 */
public class EmployeeServiceTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("EmployeeService");
		EntityManager em = emf.createEntityManager();
		EmployeeService service = new EmployeeService(em);

		// create and persist an employee
		em.getTransaction().begin();
		Employee emp = service.createEmployee(158, "John Doe", 45000);
		em.getTransaction().commit();
		System.out.println("Persisted " + emp);

		// find a specific employee
		emp = service.findEmployee(158);
		System.out.println("Found " + emp);

		// find all employees
		List<Employee> emps = service.findAllEmployees();
		for (Employee e : emps)
			System.out.println("Found employee: " + e);

		// update the employee
		em.getTransaction().begin();
		emp = service.raiseEmployeeSalary(158, 1000);
		em.getTransaction().commit();
		System.out.println("Updated " + emp);

		// remove an employee
		em.getTransaction().begin();
		service.removeEmployee(158);
		em.getTransaction().commit();
		System.out.println("Removed Employee 158");

		// close the EM and EMF when done
		em.close();
		emf.close();
	}
}
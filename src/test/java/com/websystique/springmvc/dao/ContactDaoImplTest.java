package com.websystique.springmvc.dao;

import java.math.BigDecimal;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.websystique.springmvc.model.Contact;


public class ContactDaoImplTest /*extends EntityDaoImplTest**/{

	/*@Autowired
	ContactDao employeeDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Employee.xml"));
		return dataSet;
	}
	


	@Test
	public void findById(){
		Assert.assertNotNull(employeeDao.selectContact(1));
		Assert.assertNull(employeeDao.selectContact(3));
	}

	
	@Test
	public void saveEmployee(){
		employeeDao.insertContact(getSampleEmployee());
		Assert.assertEquals(employeeDao.selectAllContacts().size(), 3);
	}
	
	@Test
	public void deleteEmployeeBySsn(){
		employeeDao.deleteContact("11111");
		Assert.assertEquals(employeeDao.selectAllContacts().size(), 1);
	}
	
	@Test
	public void deleteEmployeeByInvalidSsn(){
		employeeDao.deleteContact("23423");
		Assert.assertEquals(employeeDao.selectAllContacts().size(), 2);
	}

	@Test
	public void selectAllContacts(){
		Assert.assertEquals(employeeDao.selectAllContacts().size(), 2);
	}
	
	@Test
	public void findEmployeeBySsn(){
		Assert.assertNotNull(employeeDao.selectContact("11111"));
		Assert.assertNull(employeeDao.selectContact("14545"));
	}

	public Employee getSampleEmployee(){
		Employee employee = new Employee();
		employee.setName("Karen");
		employee.setSsn("12345");
		employee.setSalary(new BigDecimal(10980));
		employee.setJoiningDate(new LocalDate());
		return employee;
	}
**/
}

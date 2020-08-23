package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.task.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        //System.out.println(companyDao.retrieveCompanyWhereThreeFirstLetterEquals(("Sof")).size());
        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testCompanyDaoRetrieveCompanyWhereThreeFirstLetterEquals() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        Company softCake = new Company("Soft cake");
        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        companyDao.save(softCake);
        int softCakeId = softCake.getId();

        List<Company> readCompany = companyDao.retrieveCompanyWhereThreeFirstLetterEquals("sof");

        //Then
        Assert.assertEquals(2, readCompany.size());

        //CleanUp
        companyDao.deleteById(softwareMachineId);
        companyDao.deleteById(dataMaestersId);
        companyDao.deleteById(greyMatterId);
        companyDao.deleteById(softCakeId);
    }

    @Test
    public void testEmployeeDaoRetrieveEmployeesWithLastNameEquals() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee clarkSmith = new Employee("Clark", "Smith");
        Employee gwenClarckson = new Employee("Gwen", "Clarckson");
        Employee emilyClarckson = new Employee("Emily", "Clarckson");


        //When
        employeeDao.save(johnSmith);
        int johnSmithId = johnSmith.getId();
        employeeDao.save(stephanieClarckson);
        int stephanieClarcksonId = stephanieClarckson.getId();
        employeeDao.save(lindaKovalsky);
        int lindaKovalskyId = lindaKovalsky.getId();
        employeeDao.save(clarkSmith);
        int clarkSmithId = clarkSmith.getId();
        employeeDao.save(gwenClarckson);
        int gwenClarcksonId = gwenClarckson.getId();
        employeeDao.save(emilyClarckson);
        int emilyClarcksonId = emilyClarckson.getId();

        List<Employee> readSmith = employeeDao.retrieveEmployeesWithLastNameEquals("Smith");
        List<Employee> readClarckson = employeeDao.retrieveEmployeesWithLastNameEquals("Clarckson");
        List<Employee> readKovalsky = employeeDao.retrieveEmployeesWithLastNameEquals("Kovalsky");
        List<Employee> readNovak = employeeDao.retrieveEmployeesWithLastNameEquals("Novak");

        //Then
        Assert.assertEquals(2, readSmith.size());
        Assert.assertEquals(3, readClarckson.size());
        Assert.assertEquals(1, readKovalsky.size());
        Assert.assertEquals(0, readNovak.size());

        //CleanUp
        employeeDao.deleteById(johnSmithId);
        employeeDao.deleteById(stephanieClarcksonId);
        employeeDao.deleteById(lindaKovalskyId);
        employeeDao.deleteById(clarkSmithId);
        employeeDao.deleteById(gwenClarcksonId);
        employeeDao.deleteById(emilyClarcksonId);
    }
}
package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFacadeTest {
    @Autowired
    SearchFacade searchFacade;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testFindCompanyByPartName(){
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

        List<Company> readCompany = searchFacade.findCompaniesByNameFragment("sof");
        List<Company> readCompany2 = searchFacade.findCompaniesByNameFragment("placek");
        List<Company> readCompany3 = searchFacade.findCompaniesByNameFragment("e");
        List<Company> readCompany4 = searchFacade.findCompaniesByNameFragment("ers");

        //Then
        Assert.assertEquals(2, readCompany.size());
        Assert.assertEquals(0, readCompany2.size());
        Assert.assertEquals(4, readCompany3.size());
        Assert.assertEquals(1, readCompany4.size());
        //CleanUp
        companyDao.deleteById(softwareMachineId);
        companyDao.deleteById(dataMaestersId);
        companyDao.deleteById(greyMatterId);
        companyDao.deleteById(softCakeId);
    }

    @Test
    public void testFindEmployeesByPartName(){
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

        List<Employee> readEmployees = searchFacade.findEmployeesByNameFragment("clar");
        List<Employee> readEmployees2 = searchFacade.findEmployeesByNameFragment("in");
        List<Employee> readEmployees3 = searchFacade.findEmployeesByNameFragment("kevin");
        List<Employee> readEmployees4 = searchFacade.findEmployeesByNameFragment("o");

        //Then
        Assert.assertEquals(4, readEmployees.size());
        Assert.assertEquals(1, readEmployees2.size());
        Assert.assertEquals(0, readEmployees3.size());
        Assert.assertEquals(5, readEmployees4.size());

        //CleanUp
        employeeDao.deleteById(johnSmithId);
        employeeDao.deleteById(stephanieClarcksonId);
        employeeDao.deleteById(lindaKovalskyId);
        employeeDao.deleteById(clarkSmithId);
        employeeDao.deleteById(gwenClarcksonId);
        employeeDao.deleteById(emilyClarcksonId);
    }
}
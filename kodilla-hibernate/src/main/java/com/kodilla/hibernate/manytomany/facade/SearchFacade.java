package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    public List<Company> findCompaniesByNameFragment(final String string){
        LOGGER.info("Searching companies by name fragment: \""+string+"\"");
        List<Company> companies = companyDao.retrieveCompaniesContainingStringInTheName(string);
        return companies;
    }

    public List<Employee> findEmployeesByNameFragment(final String string){
        LOGGER.info("Searching employees by name fragment: \""+string+"\"");
        List<Employee> employees = employeeDao.retrieveEmployeesContainingStringInTheName(string);
        return employees;
    }
}

package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
    private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public void saveData(Employee employee) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
    }

    @Override
    public List<Employee> getAllData() {
        Session session = factory.openSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();

        return employeeList;
    }

    @Override
    public void updateData(int empId, Employee employee) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee1 = (Employee) session.get(Employee.class, empId);
        if (employee1.getEmpId() == empId) {
            employee1.setEmpName(employee.getEmpName());
            employee1.setEmpAddress(employee.getEmpAddress());
            employee1.setEmpContactNumber(employee.getEmpContactNumber());
            employee1.setEmpSalary(employee.getEmpSalary());
            employee1.setEmpDob(employee.getEmpDob());
            session.update(employee1);
            transaction.commit();
        }
    }

    @Override
    public void deleteData(int empId) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee1 = (Employee) session.get(Employee.class, empId);
        if (employee1.getEmpId() == empId) {

            session.delete(employee1);
            transaction.commit();

        }
    }
}
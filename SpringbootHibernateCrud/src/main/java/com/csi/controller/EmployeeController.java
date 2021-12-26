package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeServiceImpl;
    @PostMapping("/savedata")
    public String savaData(@RequestBody Employee employee){
        employeeServiceImpl. saveData(employee);
        return "Data save Successfully";
    }
    @GetMapping("/getdata")
    public List<Employee> getAlldata(){

       return employeeServiceImpl.getAllData();


    }
    @PutMapping("/updatedata/{empId}")
public  String updataData(@PathVariable int empId,@RequestBody Employee employee){
        employeeServiceImpl.updateData(empId,employee );
        return "Update Data Successfully";
    }
    @DeleteMapping("/deletedata/{empId}")
    public  String deleteData(@PathVariable int empId){
         employeeServiceImpl.deleteData(empId);
         return "Delete Data Successfully";
    }
}

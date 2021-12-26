package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
   private int empId;
    private  String empName;
    private String empAddress;
    private  long empContactNumber;
    private  double empSalary;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date empDob;
}

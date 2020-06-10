package com.employee.employee.model;

import enums.Gender;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="employee",schema="postgres")
@Table(name="employee")

public class Employee {

    //private static final long serialversionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name="id",unique = true, nullable = false)
    private long id;
    @Column(name="idnp",unique = true, nullable = false)  
    private long idnp;

    private static long nextIdnp = 1;
    
    @Column(name="name",unique = false, nullable = false, length = 100)    
    private String name;
    @Column(name="surName",unique = false, nullable = false, length = 100)      
    private String surName;
    @Column(name="salary",unique = false, nullable = false, length = 100) 
    private double salary;
    @Column(name="hireDay",unique = false, nullable = false, length = 100) 
    private LocalDate hireDay;
    @Column(name="birthDay",unique = false, nullable = false, length = 100)     
    private LocalDate birthDay;
    @Column(name="gender",unique = false, nullable = false, length = 100)
    private Gender gender; 

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }


    public void setIdnp(long idnp) {
        this.idnp = idnp;
    }

    public long getIdnp() {
        return this.idnp;
    }

    public void setIdnp() {
        this.idnp = this.nextIdnp++;
    }

    public static long getNextIdnp() {
        return nextIdnp++;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    
    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSurName() {
        return this.surName;
    }

    
    public void setSalary(double salary) throws IllegalArgumentException {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salariul nu poate fi negativ");
        }
    }
    
    public double getSalary() {
        return this.salary;
    }

    
    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public LocalDate getHireDay() {
        return this.hireDay;
    }

    
    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getBirthDay() {
        return this.birthDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public Gender getGender() {
        return gender;
    }

    
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Employee) {
            Employee emp = (Employee) obj;
            return this.name == emp.getName() && this.surName == emp.getSurName()
                    && this.salary == emp.getSalary() && this.hireDay == emp.getHireDay()
                    && this.birthDay == emp.getBirthDay() && this.gender == emp.getGender();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Employee [name=" + this.name + "surname=" + this.surName + "salary=" + this.salary + "gender" + this.gender;
    }

}

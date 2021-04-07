package com.example.demo.Entityexamples;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "emptasks")
//@javax.persistence.IdClass(IdClassEmp.class)
public class EmployeeTask {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long compid; 
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="task_id")
	@JsonBackReference(value="user-person2")
//	@JsonIgnore
    private Tasks task;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="emp_id")
	@JsonBackReference(value="user-person")
	
   private Employee employee;
	
	public Tasks getTask() {
		return task;
	}
	public void setTask(Tasks task) {
		this.task = task;
	}
	public long getCompid() {
		return compid;
	}
	public void setCompid(long compid) {
		this.compid = compid;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
   
    

}

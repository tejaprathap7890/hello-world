package com.example.demo.Entityexamples;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="employee")
public class Employee {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empid;
    private String Fname;
    private String Lname;
    private Long Mobile;
 
	//@One(fetch = FetchType.EAGER, mappedBy = "empname")
  //  private List<Tasks> taskname;
    
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "employee",fetch = FetchType.EAGER)
    @JsonManagedReference(value="user-person")
    //@JsonIgnore
    // @Fetch(FetchMode.SELECT)
    private List<EmployeeTask> emptasks ;
    
	

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

//	public List<Tasks> getTaskname() {
//		return taskname;
//	}
//
//	public void setTaskname(List<Tasks> taskname) {
//		this.taskname = taskname;
//	}
	   public String getFname() {
			return Fname;
		}

		public void setFname(String fname) {
			Fname = fname;
		}

		public String getLname() {
			return Lname;
		}

		public void setLname(String lname) {
			Lname = lname;
		}

		public Long getMobile() {
			return Mobile;
		}

		public void setMobile(Long mobile) {
			Mobile = mobile;
		}
		public List<EmployeeTask> getEmptasks() {
			return emptasks;
		}

		public void setEmptasks(List<EmployeeTask> emptasks) {
			this.emptasks = emptasks;
		}

}
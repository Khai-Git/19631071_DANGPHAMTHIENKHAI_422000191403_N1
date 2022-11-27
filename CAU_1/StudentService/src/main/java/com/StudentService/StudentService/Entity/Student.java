package com.StudentService.StudentService.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentid")
	private String StudentID;
	@Column(name = "name")
	private String Name;
	@Column(name = "age")
	private int Age;
	@Id
	@Column(name = "mentorid")
	private String MentorID;
}

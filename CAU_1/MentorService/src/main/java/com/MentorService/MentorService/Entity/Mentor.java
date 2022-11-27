package com.MentorService.MentorService.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mentors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Mentor implements Serializable {
	@Id
	@Column(name = "weight")
	private String MentorID;
	@Column(name = "name")
	private String Name;
	@Column(name = "address")
	private String Address;
}

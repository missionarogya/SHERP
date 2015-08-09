package org.missionarogya.sherp.model.dao.object;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ROLE")
public class Role implements Serializable{
	@Id
	@Column(name = "MEMBER_ID", nullable = false)
	int memberId;
	@Column(name = "ROLE", nullable = false)
	String role;
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}

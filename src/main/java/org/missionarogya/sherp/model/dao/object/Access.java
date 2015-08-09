package org.missionarogya.sherp.model.dao.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ACCESS")
public class Access {
	@Id
	@Column(name = "ROLE", nullable = false)
	String role;
	@Column(name = "ACTION", nullable = false)
	String action;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
}

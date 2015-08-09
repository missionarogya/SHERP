package org.missionarogya.sherp.model.dao.object;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
@Entity
@Table(name="MEMBER")
@SecondaryTables({
    @SecondaryTable(name="ROLE", pkJoinColumns={
    @PrimaryKeyJoinColumn(name="MEMBER_ID", referencedColumnName="MEMBER_ID") }),
})
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MEMBER_ID", nullable = false)
	int memberId;
	@Column(name = "EMAILID", nullable = false)
	String emailId;
	@Column(table="ROLE",name="ROLE" , nullable = false)
	String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}

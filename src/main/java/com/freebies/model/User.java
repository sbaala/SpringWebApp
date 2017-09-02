package com.freebies.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Bala
 *
 */
@Entity
public class User extends BaseModel{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    private String userId;
    private String firstName;
    private String lastName;
    private LocalDateTime createTime;
	private LocalDateTime updateTime;
	private String updatedBy;
	private String password;
	private Integer loginAttempts;
	private String loginAccountStatus;
	private String pwdChangeReq; 
	private LocalDateTime lastLoginDate;
	private LocalDateTime lastLogoutDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getLoginAttempts() {
		return loginAttempts;
	}
	public void setLoginAttempts(Integer loginAttempts) {
		this.loginAttempts = loginAttempts;
	}
	public String getLoginAccountStatus() {
		return loginAccountStatus;
	}
	public void setLoginAccountStatus(String loginAccountStatus) {
		this.loginAccountStatus = loginAccountStatus;
	}
	public String getPwdChangeReq() {
		return pwdChangeReq;
	}
	public void setPwdChangeReq(String pwdChangeReq) {
		this.pwdChangeReq = pwdChangeReq;
	}
	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(LocalDateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public LocalDateTime getLastLogoutDate() {
		return lastLogoutDate;
	}
	public void setLastLogoutDate(LocalDateTime lastLogoutDate) {
		this.lastLogoutDate = lastLogoutDate;
	}
    
}

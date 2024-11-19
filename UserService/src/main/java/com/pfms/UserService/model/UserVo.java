package com.pfms.UserService.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_management")
@JsonDeserialize(as = UserVo.class)
public class UserVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "password")
	private String password;
	@Column(name = "phone_Num")
	private Long phoneNumber;
	@Column(name = "role_id_fk")
	private Long roleIdFk;
	@Column(name = "is_active")
	private Long isActive;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<UserRoleVo> roles = new HashSet<>();

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getRoleIdFk() {
		return roleIdFk;
	}

	public void setRoleIdFk(Long roleIdFk) {
		this.roleIdFk = roleIdFk;
	}

	public Long getIsActive() {
		return isActive;
	}

	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<UserRoleVo> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRoleVo> roles) {
		this.roles = roles;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

	public UserVo() {
		super();
	}

	public UserVo(String userName) {
		super();
		this.userName = userName;
	}

	public UserVo(String userName, String emailId, String password, Long phoneNumber, Long roleIdFk, Long isActive) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.roleIdFk = roleIdFk;
		this.isActive = isActive;
	}

	public UserVo(Long userId, String userName, String emailId, String password, Long phoneNumber, Long roleIdFk,
			Long isActive) {
		this(userName, emailId, password, phoneNumber, roleIdFk, isActive);
		this.userId = userId;
	}

	public UserVo(String username, String email, String password) {
		this.userName = username;
		this.emailId = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}

}

package com.pfms.UserService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_role") 
public class UserRoleVo {
	@Id
	@Column(name="role_id")
	private Long roleId;
	@Column(name="role_name")
	private String roleName;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;
	@Column(name="is_active")
	private Long isActive;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public ERole getName() {
		return name;
	}
	public void setName(ERole name) {
		this.name = name;
	}
	public Long getIsActive() {
		return isActive;
	}
	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}

	
	
	@Override
	public String toString() {
		return "UserRoleVo [roleId=" + roleId + ", roleName=" + roleName + ", name=" + name + ", isActive=" + isActive
				+ "]";
	}
	public UserRoleVo() {
		super();
	}
	public UserRoleVo(Long roleId, String roleName, ERole name, Long isActive) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.name = name;
		this.isActive = isActive;
	}

}

package com.pfms.UserService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfms.UserService.model.ERole;
import com.pfms.UserService.model.UserRoleVo;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleVo, Long> {
	Optional<UserRoleVo> findByName(ERole name);

}

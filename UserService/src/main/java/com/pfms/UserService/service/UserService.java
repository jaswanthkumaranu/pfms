package com.pfms.UserService.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pfms.UserService.model.UserVo;
import com.pfms.UserService.repository.UserRepository;
import com.pfms.UserService.utility.UserManagmentException;

import jakarta.transaction.Transactional;

@Service
public class UserService implements UserDetailsService {
	public static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired(required = true)
	private UserRepository userRepository;

	/*
	 * @Autowired private RestClientRest restClient;
	 */

	public List<UserVo> getAllUserDetailsUsers() {
		return userRepository.findAll();
	}

	@Cacheable(value = "movielibrary", key = "#id")
	public UserVo getUserById(Long id) throws Exception {
		Optional<UserVo> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new Exception("Can not find movie with id: " + id);
		} else {
			return user.get();
		}
	}

	public UserVo insertUserData(UserVo user) {
		user.setIsActive(1L);
		return userRepository.save(user);
	}

	@CachePut(value = "userlibrary", key = "#id")
	public UserVo updateUserData(UserVo user) throws Exception {
		if (user != null && user.getUserId() > 0) {
			return userRepository.save(user);
		} else {
			throw new Exception("Can not find user with id: ");
		}
	}

	@CacheEvict(value = "userlibrary", key = "#id")
	public UserVo deleteUserById(Long id) throws Exception {
		if (id > 0) {
			UserVo user = getUserById(id);
			if (user != null && !"".equalsIgnoreCase(user.getUserName())) {
				userRepository.deleteById(id);
				return user;
			}
		}
		throw new UserManagmentException("Can not delete User with id: " + id);

	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVo user = userRepository.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		
		return UserDetailsImpl.build(user);
	}
}

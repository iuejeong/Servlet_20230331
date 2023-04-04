package com.study.servlet.repository;

import com.study.servlet.entity.Role;

public interface RoleRepository {
	public Role findUserByRoleName(String roleName);
}

package com.nisal.service;

import com.nisal.domain.UserRole;
import com.nisal.model.User;
import com.nisal.payload.dto.UserDto;

import java.util.List;

public interface EmployeeService {

    UserDto createStoreEmployee(UserDto employee, Long storeId) throws Exception;
    UserDto createBranchEmployee(UserDto employee, Long branchId) throws Exception;
    User updateEmployee(Long employeeId, UserDto employeeDetails) throws Exception;
    void deleteEmployee(Long employeeId) throws Exception;
    List<UserDto> findStoreEmployees(Long storeId, UserRole role) throws Exception;
    List<UserDto> findBranchEmployees(Long branchId, UserRole role) throws Exception;

}

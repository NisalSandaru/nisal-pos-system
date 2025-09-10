package com.nisal.service;

import com.nisal.exceptions.UserException;
import com.nisal.payload.dto.UserDto;
import com.nisal.payload.response.AuthResponse;

public interface AuthService {

    AuthResponse signup(UserDto userDto) throws UserException;
    AuthResponse login(UserDto userDto) throws UserException;
}

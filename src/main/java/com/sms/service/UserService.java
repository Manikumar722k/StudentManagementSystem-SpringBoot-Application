package com.sms.service;

import com.sms.dto.UserDto;
import com.sms.entity.User;

public interface UserService {

	User save (UserDto userDto);
}

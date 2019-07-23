package tma.com.service;

import tma.com.dto.UserDTO;
import tma.com.model.User;

public interface IUserService {

	public User insert(UserDTO userDto);
}

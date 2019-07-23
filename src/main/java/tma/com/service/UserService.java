package tma.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.dto.UserDTO;
import tma.com.model.User;
import tma.com.repository.IUserRepository;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public User insert(UserDTO userDto) {
		// TODO Auto-generated method stub
		
		User user = new User(userDto.getUsername());
		return userRepository.save(user);
	}

}

package ru.gb.HWwith_an_asterisk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.HWwith_an_asterisk.model.User;
import ru.gb.HWwith_an_asterisk.repository.UserRepository;;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }
    public void updateById(int id, String firstName, String lastName){
        userRepository.updateById(id, firstName, lastName);
    }
}


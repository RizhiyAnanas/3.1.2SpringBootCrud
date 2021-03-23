package com.springboot.crud.SpringBootCrud.Service;




import com.springboot.crud.SpringBootCrud.model.Role;
import com.springboot.crud.SpringBootCrud.model.User;
import com.springboot.crud.SpringBootCrud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Service
@Transactional
public class ServiceImpl implements Service {


    private UserRepository userRepository;
    @Autowired
    public ServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User show(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void update(User user, Long id) {
        User updateUser= userRepository.findById(id).orElse(null);
        updateUser.setAge(user.getAge());
        updateUser.setEmail(user.getEmail());
        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        userRepository.saveAndFlush(updateUser);
    }
}

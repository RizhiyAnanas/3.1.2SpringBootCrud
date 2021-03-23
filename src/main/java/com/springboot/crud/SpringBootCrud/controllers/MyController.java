package com.springboot.crud.SpringBootCrud.controllers;

import com.springboot.crud.SpringBootCrud.Service.RoleService;
import com.springboot.crud.SpringBootCrud.Service.Service;
import com.springboot.crud.SpringBootCrud.model.Role;
import com.springboot.crud.SpringBootCrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("admin")
public class MyController {
    private final RoleService roleService;

    final private Service service;

    public MyController(Service service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }

    @GetMapping("/new")
    public String createNewUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "new";
    }


    @PostMapping()
    public String create(@ModelAttribute("user") User user, @RequestParam("role") String role){
        Set<Role> roles = new HashSet<>();
        if (role.equals("ROLE_ADMIN")){
                roles.add(roleService.getAllRoles().get(0));
        }else{
            roles.add(roleService.getAllRoles().get(1));
        }
        user.setRoles(roles);
        service.add(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", service.show(id));
        return "show";
    }


    @GetMapping
    public String showList(Model model){
        List<User> list = service.getList();
        model.addAttribute("users", list);
        return "users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", service.show(id));
        return "edit";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        service.deleteUser(id);
        return "redirect:/admin";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,@PathVariable("id") Long id ){
        service.update(user, id);
        return "redirect:/admin";
    }
}

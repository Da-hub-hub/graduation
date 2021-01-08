package com.epidemic.controller;
import com.epidemic.entity.Role;
import com.epidemic.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RequestMapping("role")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;
    @GetMapping("/findByName/{id}")
    public List<Role> findByName(@PathVariable int id){
        return roleService.findByName(id);
    }
}

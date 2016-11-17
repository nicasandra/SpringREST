package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import model.User;
import service.UserService;

import java.util.List;

/**
 * Created by nicasandra on 11/16/2016.
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable Integer id) {
        System.out.println(id);
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@RequestParam("id") Integer id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void saveUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }
}

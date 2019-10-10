package cn.itle.controller;

import cn.itle.pojo.TbUser;
import cn.itle.service.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddUserController {

    @Autowired
    private AddUserService service;

    @RequestMapping("/add")
    public String AddIndex(){
        return "add";
    }

    @RequestMapping("/addUserController")
    public String addUser(TbUser user) {
        if (service.addUser(user)) {
            return "redirect:/find/index";   //重定向
        }else {
            return "add";
        }
    }

}

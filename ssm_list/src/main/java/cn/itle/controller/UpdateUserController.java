package cn.itle.controller;

import cn.itle.pojo.TbUser;
import cn.itle.service.FindUserService;
import cn.itle.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UpdateUserController {
    @Autowired
    private UpdateService updateService;
    @Autowired
    private FindUserService findUserService;

    @RequestMapping("/findUserController")
    public String findUserController(HttpServletRequest request) {
        String id = request.getParameter("id");
        TbUser user = findUserService.findUserById(Integer.parseInt(id));
        request.setAttribute("user",user);
        return "update";
    }

    @RequestMapping("/updateUserController")
    public String update(TbUser user) {
        if (updateService.updateUser(user)) {
            return "redirect:/find/index";
        }
        return "list";
    }

}

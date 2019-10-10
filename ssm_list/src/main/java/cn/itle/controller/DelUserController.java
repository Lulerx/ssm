package cn.itle.controller;

import cn.itle.service.DelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DelUserController {
    @Autowired
    private DelUserService delUserService;

    /**
     * 删除单个信息
     * @param request
     * @return
     */
    @RequestMapping("/delUserController")
    public String delUser(HttpServletRequest request){
        String id = request.getParameter("id");
        delUserService.delUser(Integer.parseInt(id));
        return "redirect:/find/index";
    }

    /**
     * 删除多个用户
     * @param request
     * @return
     */
    @RequestMapping("/delSelectsController")
    public String delSelects(HttpServletRequest request) {
        String[] ids = request.getParameterValues("uid");
        delUserService.delSelects(ids);
        return "redirect:/find/index";
    }

}

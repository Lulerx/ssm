package cn.itle.controller;

import cn.itle.pojo.TbUser;
import cn.itle.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService service;

    @RequestMapping("/index")
    public String index(){
        return "login";
    }

    /*
        登录判断
     */
    @RequestMapping("/loginController")
    public String login(String username,String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        //校验验证码
        String verifycode = "1";
        verifycode = request.getParameter("verifycode");
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");    //确保验证码一次性
        if (!checkcode_server.equalsIgnoreCase(verifycode)){    //忽略大小写比较
            //验证码不正确
            session.setAttribute("login_msg","验证码不正确！");
            return "login";
        }
        //判断用户名和密码
        if (service.login(username,password)){
            TbUser user = new TbUser();
            user.setUsername(username);
            user.setPassword(password);
            session.setAttribute("user",user);
            return "index";
        }else {
            session.setAttribute("login_msg","用户名或密码不正确！");
            return "login";
        }
    }
}

package cn.itle.controller;

import cn.itle.pojo.PageBean;
import cn.itle.pojo.TbUser;
import cn.itle.service.FindLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class FindLimitController {
    @Autowired
    private FindLimitService findLimitService;

    @RequestMapping("/findLimitController")
    public String FindLimitController(HttpServletRequest request) {
        //接收参数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        //排除空指针异常
        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)){
            rows = "5";
        }

        Map<String, String[]> condition = request.getParameterMap();

        PageBean<TbUser> pageBean = findLimitService.findUserByPage(Integer.parseInt(currentPage), Integer.parseInt(rows), condition);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("condition",condition);

        return "list";
    }

}

package cn.itle.controller;

import cn.itle.pojo.TbUser;
import cn.itle.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 显示所有数据
 * 使用分页后，已作废
 */
@Controller
@RequestMapping("/find")
public class FindAllController {
    @Autowired
    private ListService service;

    @RequestMapping("/index")
    public String findAll(Model model) {
        List<TbUser> list = service.findAll();
        model.addAttribute("list",list);
        return "list";
    }
}

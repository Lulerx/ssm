package cn.itle.service.Impl;

import cn.itle.dao.TbUserMapper;
import cn.itle.pojo.TbUser;
import cn.itle.pojo.TbUserExample;
import cn.itle.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    TbUserMapper userMapper;

    /**
     * 登录判断
     * @param username
     * @param pwd
     * @return
     */
    public boolean login(String username, String pwd) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(pwd);

        List<TbUser> list = userMapper.selectByExample(example);
        System.out.println(list);
        if (list.size() > 0){
            return true;
        }
        return false;
    }
}

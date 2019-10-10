package cn.itle.service.Impl;

import cn.itle.dao.TbUserMapper;
import cn.itle.pojo.TbUser;
import cn.itle.service.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddUserServiceImpl implements AddUserService{

    @Autowired
    private TbUserMapper mapper;

    @Override
    public boolean addUser(TbUser user) {
        int count = mapper.insertSelective(user);
        if (count > 0) {
            return true;
        }else {
            return false;
        }
    }

}

package cn.itle.service.Impl;

import cn.itle.dao.TbUserMapper;
import cn.itle.pojo.TbUser;
import cn.itle.service.FindUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserServiceImpl implements FindUserService {
    @Autowired
    private TbUserMapper mapper;

    @Override
    public TbUser findUserById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }
}

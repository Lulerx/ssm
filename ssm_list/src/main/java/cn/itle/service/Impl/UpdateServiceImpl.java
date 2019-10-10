package cn.itle.service.Impl;

import cn.itle.dao.TbUserMapper;
import cn.itle.pojo.TbUser;
import cn.itle.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateServiceImpl implements UpdateService {
    @Autowired
    private TbUserMapper mapper;

    @Override
    public boolean updateUser(TbUser user) {
        int count = mapper.updateByPrimaryKeySelective(user);
        if (count > 0) {
            return true;
        }
        return false;
    }
}

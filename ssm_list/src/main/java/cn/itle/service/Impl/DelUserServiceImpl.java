package cn.itle.service.Impl;

import cn.itle.dao.TbUserMapper;
import cn.itle.service.DelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DelUserServiceImpl implements DelUserService {
    @Autowired
    private TbUserMapper mapper;

    @Override
    public boolean delUser(Integer id) {
        int i = mapper.deleteByPrimaryKey(id);
        if (i > 0 ) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delSelects(String[] ids) {
        for (String id : ids) {
            mapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
        return true;
    }
}

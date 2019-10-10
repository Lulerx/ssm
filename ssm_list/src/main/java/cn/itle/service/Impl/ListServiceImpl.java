package cn.itle.service.Impl;

import cn.itle.dao.TbUserMapper;
import cn.itle.pojo.TbUser;
import cn.itle.pojo.TbUserExample;
import cn.itle.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListServiceImpl implements ListService {
    @Autowired
    private TbUserMapper mapper;

    public List<TbUser> findAll() {
        TbUserExample example = new TbUserExample();
        List<TbUser> list = mapper.selectByExample(example);
        return list;
    }
}

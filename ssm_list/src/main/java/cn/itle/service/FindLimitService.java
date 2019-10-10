package cn.itle.service;

import cn.itle.pojo.PageBean;
import cn.itle.pojo.TbUser;

import java.util.List;
import java.util.Map;

public interface FindLimitService {

    public PageBean<TbUser> findUserByPage(int _currentPage, int _rows,Map<String, String[]> condition);

    public int findTotalCount (Map<String, String[]> conditon);

    public List<TbUser> findLimit (int start,int count,Map<String, String[]> conditon);
}

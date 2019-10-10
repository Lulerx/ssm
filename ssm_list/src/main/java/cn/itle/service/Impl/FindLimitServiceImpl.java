package cn.itle.service.Impl;

import cn.itle.dao.TbUserMapper;
import cn.itle.pojo.PageBean;
import cn.itle.pojo.TbUser;
import cn.itle.pojo.TbUserExample;
import cn.itle.service.FindLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class FindLimitServiceImpl implements FindLimitService {
    @Autowired
    private TbUserMapper mapper;

    /**
     * 分页查询
     * @param _currentPage
     * @param _rows
     * @param condition
     * @return
     */
    @Override
    public PageBean<TbUser> findUserByPage(int _currentPage, int _rows,Map<String, String[]> condition) {
        int currentPage = _currentPage;
        int rows = _rows;

        PageBean<TbUser> pageBean = new PageBean<TbUser>();

        int size = findTotalCount(condition);  //获取总记录数
        pageBean.setTotalCount(size);                       //设置总记录数

        //设置当前页数据
        int totalPage = (size % rows) == 0 ? size/rows : (size/rows) + 1;   //获取总页码
        pageBean.setTotalPage(totalPage);                   //设置总页码
        //判断当前页码
        if(currentPage <= 0){
            currentPage = 1;
        }
        if (currentPage > totalPage){
            currentPage = totalPage;
        }
        pageBean.setCurrentPage(currentPage);                //设置当前页码
        pageBean.setRows(rows);                 //设置每页显示条数
        //计算开始的索引
        int start = (currentPage - 1) * rows;
        List<TbUser> list = findLimit(start,rows,condition);    //分页查询
        pageBean.setList(list);

        return pageBean;
    }

    /**
     * 按条件查询。返回查询的记录条数
     * @param conditon
     * @return
     */
    @Override
    public int findTotalCount(Map<String, String[]> conditon) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        //遍历map
        Set<String> set = conditon.keySet();
        for (String key : set) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //根据key获取value
            String value = conditon.get(key)[0];
            if (value != null) {
                if ("name".equals(key)) {
                    criteria.andNameLike("%" + value + "%");
                }
                if ("address".equals(key)) {
                    criteria.andAddressLike("%" + value + "%");
                }
                if ("email".equals(key)) {
                    criteria.andEmailLike("%" + value + "%");
                }
            }
        }
        return mapper.selectByExample(example).size();
    }

    /**
     * 根据条件分页查询
     * @param conditon
     * @return
     */
    @Override
    public List<TbUser> findLimit(int start,int count,Map<String, String[]> conditon) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        //遍历map
        Set<String> set = conditon.keySet();
        for (String key : set) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //根据key获取value
            String value = conditon.get(key)[0];
            if (value != null) {
                if ("name".equals(key)) {
                    criteria.andNameLike("%" + value + "%");
                }
                if ("address".equals(key)) {
                    criteria.andAddressLike("%" + value + "%");
                }
                if ("email".equals(key)) {
                    criteria.andEmailLike("%" + value + "%");
                }
            }
        }
        example.setStart(start);
        example.setCount(count);
        return mapper.selectByExample(example);
    }
}

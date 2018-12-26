package com.hbd.service.impl;

import java.util.List;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
  
import com.hbd.dao.UserDao;  
import com.hbd.entity.User;  
import com.hbd.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //表示一个方法声明的目的是覆盖父类方法声明。如果一个方法是注释，该注释类型但不重写基类方法，编译器必须生成一个错误消息。  
    @Override
    public String addInfo(User addInfo) {
        if (userDao.insertSelective(addInfo) == 1) {
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public String delete(int id) {
        if (userDao.deleteByPrimaryKey(id) == 1) {
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public User findById(int id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public String update(User addInfo) {
        if (userDao.updateByPrimaryKeySelective(addInfo) == 1) {
            return "更新成功";
        }
        return "更新失败";
    }

    @Override
    public User login(User user) {
        return userDao.selectByUsernameAndPassword(user);
    }


    /**
     * 测试事务管理
     *
     * @param user
     * @return
     */
    @Override
    public void addUserTestTransaction(User user){
        try {
            System.out.println("方法开始");
            System.out.println("进入保存");
            userDao.insert(user);
            System.out.println("退出保存");
            System.out.println("进入异常");

        }catch (Exception e){
            throw new RuntimeException("自定义运行时异常。。。。。");
        }
    }

}  
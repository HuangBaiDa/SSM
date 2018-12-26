package com.hbd.controller;

import java.util.List;  
import java.util.UUID;  
import javax.servlet.http.HttpServletRequest;

import com.hbd.service.impl.UserServiceImpl;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;  
import com.hbd.entity.User;  
import com.hbd.service.UserService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  
public class UserController {  
    @Autowired  
    private UserService userService;

    @Autowired
    @Qualifier("userService2")
    private UserService userService2;

    Logger logger = Logger.getLogger(UserController.class);

    /*public UserService getUserService() {
        return userService;  
    }  
    public void setUserService(UserService userService) {  
        this.userService = userService;  
    }  */
      
    @SuppressWarnings("finally")  
    @RequestMapping("addInfo")  
    public String add(User user,HttpServletRequest request){  
        try {             
//          user.setId(UUID.randomUUID().toString());  
            System.out.println(user.getId() + ":::::" + user.getUsername() + ":::::" + user.getPassword());  
            String str = userService.addInfo(user);  
            System.out.println(str);  
            request.setAttribute("InfoMessage", str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            request.setAttribute("InfoMessage", "添加信息失败！具体异常信息：" + e.getMessage());  
        } finally {           
            return "result";  
        }  
    }  
      
    @RequestMapping("getAll")  
    public String getAddInfoAll(HttpServletRequest request){  
        try {             
            List<User> list = userService.getAll();  
            System.out.println("------User_list-----"+list.size());  
            request.setAttribute("addLists", list);  
            return "listAll";  
        } catch (Exception e) {  
            e.printStackTrace();  
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());  
            return "result";  
        }  
    }  
      
    @SuppressWarnings("finally")  
    @RequestMapping("del")  
    public String del(int id,HttpServletRequest request){  
        try {             
            String str = userService.delete(id);  
            request.setAttribute("InfoMessage", str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            request.setAttribute("InfoMessage", "删除信息失败！具体异常信息：" + e.getMessage());  
        } finally {           
            return "result";  
        }  
    }  
    @RequestMapping("modify")  
    public String modify(int id,HttpServletRequest request){  
        try {             
            User user = userService.findById(id);  
            request.setAttribute("add", user);  
            return "modify";  
        } catch (Exception e) {  
            e.printStackTrace();  
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());  
            return "result";  
        }  
    }  
    @SuppressWarnings("finally")  
    @RequestMapping("update")  
    public String update(User user,HttpServletRequest request){  
        try {             
            String str = userService.update(user);  
            request.setAttribute("InfoMessage", str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            request.setAttribute("InfoMessage", "更新信息失败！具体异常信息：" + e.getMessage());  
        } finally {           
            return "result";  
        }  
    }

    @RequestMapping("add")
    public String addJump(HttpServletRequest request){
        try {
            System.out.println("------新增----");
            return "add";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "新增页面跳转！具体异常信息：" + e.getMessage());
            return "result";
        }
    }

    @RequestMapping("login")  
    public String login(User user,HttpServletRequest request){  
        try {             
            System.out.println("------login--qian----"+user.getUsername()+","+user.getPassword()+".");  
            User loginUser = null;  
            loginUser=userService.login(user);  
            if(loginUser!=null){  
                request.setAttribute("loginUser", loginUser.getUsername());  
                return "index";  
            }else{  
                request.setAttribute("loginUser", "登录失败");  
                return "index";  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
            request.setAttribute("InfoMessage", "登录失败！具体异常信息：" + e.getMessage());  
            return "result";  
        }  
    }

    @RequestMapping("transaction")
    @ResponseBody
    public String TestTransaction(HttpServletRequest request){
        logger.info("使用日志-----------开始----------");
        try {
            User user1 = new User();
            user1.setUsername("张三");
            user1.setPassword("123");
            userService.addUserTestTransaction(user1);

            User user2 = new User();
            user2.setUsername("李四");
            user2.setPassword("123");
            userService2.addUserTestTransaction(user2);
            int j= 1/0;
        } catch (Exception e) {
            logger.error("更新信息失败,事务已回滚...",e);
        }
        logger.info("使用日志---------结束------------");
        return "success transaction!";
    }
}
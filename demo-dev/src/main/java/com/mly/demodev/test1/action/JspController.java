package com.mly.demodev.test1.action;

import com.mly.demodev.test1.bean.User;
import com.mly.demodev.test1.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Api(value = "jsp",description = "测试用户的权限")
@RequestMapping("/jsp")
public class JspController {
    @Autowired
    UserService service;

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value="/home",method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @ApiOperation("登录")
    @RequestMapping(value="/loginDo",method = RequestMethod.GET)
    public String loginDo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(service.findByName(username) != null){
            User u = service.findByName(username);
            if(password.equals(u.getPassword())){
                request.setAttribute("username",u.getUsername());
                response.getWriter().print("success");
            }
            else {
                response.getWriter().print("passworderror");

            }
        }else{
            response.getWriter().print("usernameerror");
        }
        return null;
    }

    @RequestMapping( value = "/register", method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @ApiOperation("注册")
    @RequestMapping(value="/registerDo",method = RequestMethod.PUT)
    public String register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("repassword");
        if(service.findByName(username)==null){
            if(password.equals(password2)){
                User u = new User();
                u.setUsername(username);
                u.setPassword(password);
                service.insert(u);
                response.getWriter().print("success");
            }
            else {
                response.getWriter().print("passworderror");
            }
        }else{
            response.getWriter().print("usernameerror");
        }
        return null;
    }
}

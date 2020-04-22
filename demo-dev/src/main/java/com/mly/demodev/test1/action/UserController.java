package com.mly.demodev.test1.action;

import java.util.List;

import javax.annotation.Resource;

import com.mly.demodev.test1.bean.User;
import com.mly.demodev.test1.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(value = "User",description = "用户接口")
public class UserController {

	@Resource
	private UserService userService;
	
	/* @RequestMapping("/say")
     public String say(){
         return "springboot-a"+userService;
     }

	@RequestMapping("/find")
	public User find(){
		User user =  userService.find(8);
		return user;
		*//*ModelAndView mav = new ModelAndView();
		mav.addObject("user","sadf");
		return "HelloWord"+"fasdf--"+user.getUsername()+"--"+user.getPassword();*//*
	}*/

	@RequestMapping(value="/findAll",method = RequestMethod.GET)
	@ApiOperation("获取用户列表")
	public List<User> findAll(){
		List<User> list = userService.findAll();
		return list;
	}

	@RequestMapping(value="/findByName/{name}",method = RequestMethod.GET)
	@ApiOperation("根据用户名判断用户是否存在")
	public User findByName(@PathVariable String name){
		User user =  userService.findByName(name);
		return user;
		/*ModelAndView mav = new ModelAndView();
		mav.addObject("user","sadf");
		return "HelloWord"+"fasdf--"+user.getUsername()+"--"+user.getPassword();*/
	}
	/*@RequestMapping("/create")
	public String create(){
	 	User user = new User();
	 	user.setUsername("mly");
	 	user.setPassword("mly0103");
	 	user.setAge(23);
	 	userService.insert(user);
	 	return "新增成功啦！！恭喜恭喜，给点红包吧，啦啦啦啦啦啦............";
	}

	@RequestMapping("/update")
	public String update(){
	 	User user = userService.find(7);
	 	user.setUsername("miaomiao");
	 	userService.update(user);
	 	return "修改成功！！！！";
	}
	@RequestMapping("/ajax")
	public String find1(){
		return "[''message':'123dfx']";
	}

	@RequestMapping("/test")
	public String test(){
	 	return "index";
	}*/

}

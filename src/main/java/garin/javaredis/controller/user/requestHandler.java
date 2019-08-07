package garin.javaredis.controller.user;

import garin.javaredis.model.User;
import garin.javaredis.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@ResponseBody
@Controller
@RequestMapping("/user")
public class requestHandler {
    @Autowired
    UserService userService;

    @GetMapping("/guser")
    public User get_auser(){
        User user=userService.queryUser(1);

        return user;
    }
    @GetMapping("/auser")
    public String add_auser(){
        User user=new User();
        user.setAge(12);
        user.setPassword("dasf");
        user.setUserName("dsajf");
        user.setUid(23);
        return "asd";
    }


//    @RequestMapping("9988")
//    @ResponseBody
//    @Cacheable
//    public String TmatherFuck(){
//        List list=redisTemplate.getClientList();
//        return list.size()+"";
//    }
}

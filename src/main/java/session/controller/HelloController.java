package session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class HelloController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Value("${server.port}")
    String port;
    @RequestMapping("/save/{name}")
    public String saveName(@PathVariable  String name, HttpSession session){
        session.setAttribute("name",name);

        return port;
    }

    @GetMapping("/get")
    public String getName(HttpSession session){
        return port +":"+session.getAttribute("name");
    }


}

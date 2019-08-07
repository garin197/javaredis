package garin.javaredis.services.user;

import garin.javaredis.dao.UserMapper;
import garin.javaredis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;

    @Cacheable(cacheNames = "User",key = "#user.uid")
    @Override
    public User queryUser(Integer uid) {
        return userMapper.findUserById(uid);
    }

    @CachePut(key = "#user.uid")
    @Override
    public int addUser(User user) {
        return userMapper.insertUser(user);
    }
}

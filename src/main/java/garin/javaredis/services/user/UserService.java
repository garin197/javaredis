package garin.javaredis.services.user;

import garin.javaredis.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    int addUser(User user);

    User queryUser(Integer uid);

}

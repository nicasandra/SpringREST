package service;

import model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nicasandra on 11/16/2016.
 */

@Service
public class UserService {

    static List<User> userList;

    @PostConstruct
    public void initList() {
        userList = new ArrayList<User>();
        userList.add(new User(0, "Popescu", 18));
        userList.add(new User(1, "Ionescu", 20));
        userList.add(new User(2, "Vasilescu", 45));
    }

    public User getUserById(Integer id) {
        Iterator<User> it = userList.listIterator();
        while (it.hasNext()) {
            User u = it.next();
            if (id.equals(u.getId())) {
                return u;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public void saveUser(User user) {
        userList.add(user);
    }

    public void deleteUser(Integer id) {
        Iterator<User> it = userList.listIterator();
        while (it.hasNext()) {
            User u = it.next();
            if (id.equals(u.getId())) {
                it.remove();
                break;
            }
        }
    }
}

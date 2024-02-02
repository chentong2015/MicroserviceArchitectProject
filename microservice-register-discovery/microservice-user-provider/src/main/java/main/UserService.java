package main;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<String> users;

    public UserService() {
        this.users = new ArrayList<>();
        this.users.add("user 1, test1");
        this.users.add("user 2, test2");
        this.users.add("user 3, test3");
    }

    public String getUserById(int id) {
        return this.users.get(id);
    }
}

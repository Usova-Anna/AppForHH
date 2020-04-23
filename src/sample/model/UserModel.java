package sample.model;

import sample.User;

public interface UserModel {

    void signUpUser(User user);
    Boolean checkUser(String user, String psw);
}

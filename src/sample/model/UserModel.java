package sample.model;

import sample.User;


/**
 * public интерфейс - это все, что надо знать внешнему миру о данном мудуле.
 * Все подробности реализации в package protected классах
 */
public interface UserModel {

    void signUpUser(User user);
    Boolean checkUser(String user, String psw);
}

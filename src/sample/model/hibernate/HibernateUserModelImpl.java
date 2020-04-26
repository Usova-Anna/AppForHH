package sample.model.hibernate;

import lombok.extern.slf4j.Slf4j;
import sample.User;
import sample.model.UserModel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Slf4j
class HibernateUserModelImpl implements UserModel {

    @Override
    public void signUpUser(User user) {
        throw new NotImplementedException();
    }

    @Override
    public Boolean checkUser(String user, String psw) {
        throw new NotImplementedException();
    }
}

package sample.model;

import sample.User;

class MockUserModelImpl implements UserModel {
    @Override
    public void signUpUser(User user) {
        System.out.println(String.valueOf(user));
    }

    @Override
    public Boolean checkUser(String user, String psw) {
        return true;
    }
}

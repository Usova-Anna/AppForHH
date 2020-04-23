package sample.model;

public class UserModelFactory {
    public static final boolean USING_SQL_DATABASE = false;

    public static UserModel getUM() {
        if (USING_SQL_DATABASE) return new DataBaseHandler();
        return new MockUserModel();
    }
}

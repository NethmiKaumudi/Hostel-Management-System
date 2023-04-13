package lk.ijse.hostelmanagementsystem.repository.custom.impl;

import lk.ijse.hostelmanagementsystem.entity.User;
import lk.ijse.hostelmanagementsystem.repository.custom.UserRepository;
import org.hibernate.Session;

public class UserRepositoryimpl implements UserRepository {
//    private static UserRepositoryimpl userRepositoryimpl;
    private Session session;
//
//    private UserRepositoryimpl() {
//
//    }
//
//    public static UserRepositoryimpl getInstance() {
//        return userRepositoryimpl == null ? userRepositoryimpl = new UserRepositoryimpl() : userRepositoryimpl;
//    }

    @Override
    public String Save(User entity) {
        return (String) session.save(entity);
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void update(User entity) {
         session.update(entity);
    }

    @Override
    public User get(String userName) {
        return session.get(User.class, userName);

    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}

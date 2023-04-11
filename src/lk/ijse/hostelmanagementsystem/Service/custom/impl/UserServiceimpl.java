package lk.ijse.hostelmanagementsystem.Service.custom.impl;

import lk.ijse.hostelmanagementsystem.Service.custom.UserService;
import lk.ijse.hostelmanagementsystem.dto.StudentDTO;
import lk.ijse.hostelmanagementsystem.dto.UserDTO;
import lk.ijse.hostelmanagementsystem.entity.User;
import lk.ijse.hostelmanagementsystem.repository.UserRepository;
import lk.ijse.hostelmanagementsystem.repository.impl.UserRepositoryimpl;
import lk.ijse.hostelmanagementsystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserServiceimpl implements UserService {
    private static UserServiceimpl userServiceimpl;
    UserRepository userRepository;
    private Session session;

    private UserServiceimpl() {
        userRepository= UserRepositoryimpl.getInstance();
    }

    public static UserServiceimpl getInstance() {
        return userServiceimpl == null ? userServiceimpl = new UserServiceimpl() : userServiceimpl;
    }

    @Override
    public String save(UserDTO userDTO) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            String save = userRepository.Save(userDTO.toEntity());
            transaction.commit();
            session.close();

            return save;


        } catch (Exception ex) {
            transaction.rollback();
            session.close();


            return null;
        }
    }
    public UserDTO get(String userName) {
        session = SessionFactoryConfig.getInstance().getSession();
        userRepository.setSession(session);
        User user = userRepository.get(userName);
        session.close();
        return user.toDto();
    }
    public boolean update(UserDTO userDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            userRepository.update(userDTO.toEntity());
            transaction.commit();
            session.close();

            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();

            return false;
        }
    }
}

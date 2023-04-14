package lk.ijse.hostelmanagementsystem.Service.custom.impl;

import lk.ijse.hostelmanagementsystem.Service.custom.UserService;
import lk.ijse.hostelmanagementsystem.dto.UserDTO;
import lk.ijse.hostelmanagementsystem.entity.User;
import lk.ijse.hostelmanagementsystem.repository.RepositoryFactory;
import lk.ijse.hostelmanagementsystem.repository.custom.UserRepository;
import lk.ijse.hostelmanagementsystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserServiceimpl implements UserService {

    private UserRepository userRepository = (UserRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.USERSREPOSITORY);

    private Session session;

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

        try {
            userRepository.setSession(session);
            User user = userRepository.get(userName);
            return user.toDto();
        } catch (NullPointerException e) {
            return null;
        } finally {
            session.close();
        }

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

package lk.ijse.hostelmanagementsystem.repository;

import lk.ijse.hostelmanagementsystem.repository.custom.impl.*;

public class RepositoryFactory {
    public static RepositoryFactory repositoryFactory;

    private RepositoryFactory() {

    }

    public static RepositoryFactory getRepositoryFactory() {
        if (repositoryFactory == null) {
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;

    }

    public SuperRepository getRepository(RepositoryTypes types) {
        switch (types) {
            case STUDENTREPOSITORY:
                return new StudentRepositoryimpl();
            case ROOMREPOSITORY:
                return new RoomRepositoryimpl();
            case USERSREPOSITORY:
                return new UserRepositoryimpl();
            case RESERVATIONREPOSITORY:
                return new ReservationRepositoryimpl();
            case PAYMENTREPOSITORY:
                return new PaymentRepositoryimpl();
            default:
                return null;
        }
    }

    public enum RepositoryTypes {
        STUDENTREPOSITORY, ROOMREPOSITORY, USERSREPOSITORY, RESERVATIONREPOSITORY, PAYMENTREPOSITORY
    }
}

package lk.ijse.hostelmanagementsystem.Service;

import lk.ijse.hostelmanagementsystem.Service.custom.DashboardService;
import lk.ijse.hostelmanagementsystem.Service.custom.impl.*;
import lk.ijse.hostelmanagementsystem.controller.DashBoardFormController;

public class ServiceFactory {
    public static ServiceFactory serviceFactory;

    private ServiceFactory() {

    }

    public static ServiceFactory getServiceFactory() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;

    }

    public enum ServiceTypes {
        DASHBOARDSERVICE,STUDENTSERVICE,ROOMSERVICE,USERSERVICE,QUERYSERVICE,RESERVATIONSERVICE
    }

    //Object creation logic for BO objects
    public SuperService getService(ServiceTypes types) {
        switch (types) {
            case DASHBOARDSERVICE:
                return new DashBoardServiceimpl();
            case STUDENTSERVICE:
                return new StudentServiceimpl();
            case ROOMSERVICE:
                return new RoomServiceimpl();
            case RESERVATIONSERVICE:
                return new ReservationServiceimpl();
            case USERSERVICE:
                return new UserServiceimpl();
            case QUERYSERVICE:
                return new QueryServiceimpl();

            default:
                return null;
        }
    }
}

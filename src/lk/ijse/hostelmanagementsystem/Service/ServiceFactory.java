package lk.ijse.hostelmanagementsystem.Service;

import lk.ijse.hostelmanagementsystem.Service.custom.DashboardService;
import lk.ijse.hostelmanagementsystem.Service.custom.impl.StudentServiceimpl;
import lk.ijse.hostelmanagementsystem.controller.DashBoardFormController;

public class ServiceFactory {
    public static ServiceFactory serviceFactory;

    private ServiceFactory() {

    }

    public static ServiceFactory getDaoFactory() {
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
                return new DashboardServiceimpl();
            case STUDENTSERVICE:
                return new StudentServiceimpl();
            case PAYMENT:
                return new PaymentDAOimpl();
            case PAYROLL:
                return new PayRollDAOimpl();
            case MATERIALSTOCK:
                return new MaterialStockDAOimpl();
            case SIGNUP:
                return new SignUpDAOimpl();

            default:
                return null;
        }
    }
}

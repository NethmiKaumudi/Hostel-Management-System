package lk.ijse.hostelmanagementsystem.Service.custom;

import lk.ijse.hostelmanagementsystem.Service.SuperService;

import java.io.IOException;

public interface DashboardService extends SuperService {
    Long getPendingPaymentCount();

    int getRegisteredStudent() throws IOException;

    int getRoomCount();
}

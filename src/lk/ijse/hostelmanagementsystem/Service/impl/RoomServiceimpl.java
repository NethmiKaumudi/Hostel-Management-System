package lk.ijse.hostelmanagementsystem.Service.impl;

public class RoomServiceimpl {
//
    private static RoomServiceimpl roomServiceimpl;
//    private Session session;
//    private  final RoomRepositoryimpl roomRepositoryimpl;

    private RoomServiceimpl(){

    }
    public static RoomServiceimpl getInstance(){
        return roomServiceimpl==null?roomServiceimpl=new RoomServiceimpl():roomServiceimpl;
    }
}

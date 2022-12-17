package id.grocery.tunas.utils;

public class GrpcResponseUtil {
    private static final String STATUS_FAILED = "FAILED";
    private static final String STATUS_SUCCESS = "SUCCESS";
    public static void throwIfFailed(String status, String message){
        if(STATUS_FAILED.equalsIgnoreCase(status)){
            throw new RuntimeException(message);
        }
    }
}

package http_handler;

public class HttpService {
    public void handleHttpCode(int code) {
        System.out.print(String.format("Handling %d http code: ", code));
        HttpStatus.findByHttpCode(code).getHandler().handle();
    }
}

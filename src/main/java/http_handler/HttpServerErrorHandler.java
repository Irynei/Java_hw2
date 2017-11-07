package http_handler;

public class HttpServerErrorHandler implements HttpHandle {
    @Override
    public void handle() {
        System.out.println("Server Error handling");
    }
}

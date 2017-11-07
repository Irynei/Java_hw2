package http_handler;

public class HttpClientErrorHandler implements HttpHandle {
    @Override
    public void handle() {
        System.out.println("Client Error handling");
    }
}

package http_handler;

public class HttpRedirectHandler implements HttpHandle {
    @Override
    public void handle() {
        System.out.println("Redirect handling");
    }
}

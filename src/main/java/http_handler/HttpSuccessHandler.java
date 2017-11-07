package http_handler;

public class HttpSuccessHandler implements HttpHandle {
    @Override
    public void handle() {
        System.out.println("Success handling");
    }
}

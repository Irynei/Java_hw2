package http_handler;

public class HttpInformationalHandler implements HttpHandle {
    @Override
    public void handle() {
        System.out.println("Informational handling");
    }
}

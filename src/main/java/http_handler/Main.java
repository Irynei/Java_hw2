package http_handler;

import org.fluttercode.datafactory.impl.DataFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        HttpService httpService = new HttpService();
        final DataFactory dataFactory = new DataFactory();
        while(true) {
            httpService.handleHttpCode(dataFactory.getNumberBetween(100, 600));
            Thread.sleep(1000);
        }
    }
}


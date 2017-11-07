package http_handler;

import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;

public class Main {
    @SneakyThrows
    public static void main(String[] args){
        HttpService httpService = new HttpService();
        final DataFactory dataFactory = new DataFactory();
        while(true) {
            httpService.handleHttpCode(dataFactory.getNumberBetween(100, 600));
            Thread.sleep(1000);
        }
    }
}


package http_handler;


import lombok.Getter;

@Getter
public enum HttpStatus {
    INFO(100, 199, "Informational", new HttpInformationalHandler()),
    SUCCESS(200, 299, "Success", new HttpSuccessHandler()),
    REDIRECTION(300, 399, "Redirection", new HttpRedirectHandler()),
    CLIENT_ERROR(400, 499, "Clent Error", new HttpClientErrorHandler()),
    SERVER_ERROR(500, 599, "Server Error", new HttpServerErrorHandler());

    private int minCode;
    private int maxCode;
    private String englishDesc;
    private HttpHandle handler;


    HttpStatus(int min, int max, String englishDesc, HttpHandle handler) {
        this.minCode = min;
        this.maxCode = max;
        this.englishDesc = englishDesc;
        this.handler = handler;
    }

    public static HttpStatus findByHttpCode(int httpCode) {
        HttpStatus[] statuses = values();
        for (HttpStatus status : statuses) {
            if (httpCode >= status.minCode && httpCode <= status.maxCode) {
                return status;
            }
        }
        throw new IllegalStateException(httpCode + " not supported");
    }

    @Override
    public String toString() {
        return englishDesc;
    }
}

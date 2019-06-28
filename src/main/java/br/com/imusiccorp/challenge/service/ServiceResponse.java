package br.com.imusiccorp.challenge.service;

/**
 * Data transfer object to services response.
 * @param <T> the data type.
 */
public class ServiceResponse<T extends Object> {

    private T data;
    private String message;
    private int status;

    /**
     * Empty constructor.
     */
    public ServiceResponse() {

    }

    /**
     * ServiceResponse's constructor with parameters.
     * @param data
     * @param message
     * @param status
     */
    public ServiceResponse(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

package armagadon.com.videoflakes.Model;

public class Response<T> {
    private T data;

    public void setItems(T data) {
        this.data = data;
    }

    public T getItems() {

        return data;
    }

}
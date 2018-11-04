package armagadon.com.videoflakes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GifVideo {

    @SerializedName("images") @Expose
    private GiphyImages images;

    public GiphyImages getImages() {
        return images;
    }

    public void setImages(GiphyImages images) {
        this.images = images;
    }
}


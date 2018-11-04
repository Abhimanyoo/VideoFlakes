package armagadon.com.videoflakes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GiphyResponse {
    @SerializedName("data") @Expose
    private List<GifVideo> giphyList;

        public List<GifVideo> getGiphyList() {
            return giphyList;
        }

        public void setGiphyList(List<GifVideo> giphyList) {
            this.giphyList = giphyList;
        }

}
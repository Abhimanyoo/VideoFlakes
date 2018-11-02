package armagadon.com.videoflakes.Model;

import java.util.List;

public class GifVideo {

  /*  public List<Giphy> results;

    public List<Giphy> getResults() {
        return results;
    }

}
class Giphy{*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getMp4Url() {
        return Mp4Url;
    }

    public void setMp4Url(String mp4Url) {
        Mp4Url = mp4Url;
    }

    public String id;
    public String thumbnailUrl;
    public String Mp4Url;
}


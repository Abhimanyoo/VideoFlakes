package armagadon.com.videoflakes.ViewModel;

import android.databinding.BaseObservable;

public class VideoUrlViewModel extends BaseObservable {

        private String VideoUrl;

        public VideoUrlViewModel(String VideoUrl) {
            this.VideoUrl = VideoUrl;
        }

        public String getVideoUrl() {
            return VideoUrl;
        }

        public void setVideoUrl(String VideoUrl) {
            this.VideoUrl = VideoUrl;
        }


    }


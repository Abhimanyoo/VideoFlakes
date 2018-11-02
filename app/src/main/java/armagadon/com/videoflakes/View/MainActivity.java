package armagadon.com.videoflakes.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.enums.LangType;
import com.giphy.sdk.core.models.enums.MediaType;
import com.giphy.sdk.core.models.enums.RatingType;
import com.giphy.sdk.core.network.api.CompletionHandler;
import com.giphy.sdk.core.network.api.GPHApi;
import com.giphy.sdk.core.network.api.GPHApiClient;
import com.giphy.sdk.core.network.response.ListMediaResponse;

import armagadon.com.videoflakes.Constants;
import armagadon.com.videoflakes.R;


public class MainActivity extends AppCompatActivity {

    GPHApi client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Giphy SDK
        client = new GPHApiClient(Constants.GiphyApiKey);
        GifSearch();
        Intent intent = new Intent(MainActivity.this, PlayVideo.class);
        startActivity(intent);
    }

    public void GifSearch(){
        /// Gif Search
        Log.v("giphy", "Entered");
        client.search("cats", MediaType.gif, 25, 0, RatingType.g, LangType.english, new CompletionHandler<ListMediaResponse>() {
            @Override
            public void onComplete(ListMediaResponse result, Throwable e) {
                if (result == null) {
                    // Do what you want to do with the error
                    Log.v("giphy", "ERROR value NULL");
                } else {
                    if (result.getData() != null) {
                        for (Media gif : result.getData()) {
                            String Mp4Url = gif.getImages().getOriginal().getMp4Url();
                            Log.v("giphy", gif.getId());
                            Log.v("giphy", Mp4Url);
                        }
                    } else {
                        Log.e("giphy error", "No results found");
                    }
                }
            }
        });
    }
}

package armagadon.com.videoflakes.View;

import android.content.ClipData;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import armagadon.com.videoflakes.Model.GifVideo;
import armagadon.com.videoflakes.R;
import armagadon.com.videoflakes.databinding.ItemBinding;
import armagadon.com.videoflakes.ViewModel.GifVideoViewModel;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.BindingHolder>  {

    private static final String TAG = "ItemAdapter";
    private List<GifVideo> items;
    private Context context;

    public ItemAdapter(Context context) {
        this.context = context;
        Log.d(TAG, "ItemAdapter: ");
        items = new ArrayList<>();
    }
    @NonNull
    @Override
    public ItemAdapter.BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item, parent, false);
        return new BindingHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.BindingHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + items.get(position));
        GifVideoViewModel itemViewModel = new GifVideoViewModel(items.get(position),context);
        holder.itemBinding.setViewModel(itemViewModel);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setData(List<GifVideo> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void clearItems() {
        items.clear();
        notifyDataSetChanged();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ItemBinding itemBinding;

        public BindingHolder(ItemBinding itemBinding) {
            super(itemBinding.cardView);
            this.itemBinding = itemBinding;
        }
    }
}

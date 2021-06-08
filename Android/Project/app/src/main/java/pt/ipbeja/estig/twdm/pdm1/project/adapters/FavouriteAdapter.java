package pt.ipbeja.estig.twdm.pdm1.project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.ipbeja.estig.twdm.pdm1.project.models.User;

//public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapterr.ViewHolder> {
//
//        private Context context;
//        private List<User> UserList;
//
//        public FavouriteAdapterr(Context context, List<User> userList) {
//            this.context = context;
//            this.userList = userList;
//        }
//
//
//        @NonNull
//        @Override
//        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(this.context).inflate(R.layout.list_item, parent, false);
//            return new ViewHolder(view);
//        }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Item item = this.userList.get(position);
//        holder.getTextViewTitle().setText(user.getTitle());
//        holder.getTextViewDescription().setText(item.getDescription());
//        holder.getCheckBoxDone().setChecked(item.isDone());
//        holder.getRoot().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DetailsActivity.startActivity(ItemsAdapter.this.context, item.getId());
//            }
//        });
//        holder.getCheckBoxDone().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                item.setDone(isChecked);
//                AppDatabase.getInstance(ItemsAdapter.this.context).getItemDao().update(item);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return this.itemList.size();
//    }
//
//    public void updateList(List<Item> newItems) {
//        this.itemList = newItems;
//        this.notifyDataSetChanged();
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private TextView textViewTitle;
        private ImageView imageViewCover;
        private CheckBox checkBoxFavourite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.root = itemView;
            this.textViewTitle = itemView.findViewById(R.id.textViewTitle);
            this.imageViewCover = itemView.findViewById(R.id.imageViewCover);
            this.checkBoxFavourite = itemView.findViewById(R.id.checkBoxFavourite);
        }

        public TextView getTextViewTitle() {
            return textViewTitle;
        }

        public ImageView getImageViewCover() {
            return imageViewCover;
        }

        public CheckBox getCheckBoxDone() {
            return checkBoxFavourite;
        }

        public View getRoot() {
            return root;
        }
    }
}

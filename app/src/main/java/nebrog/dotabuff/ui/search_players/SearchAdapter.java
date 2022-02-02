package nebrog.dotabuff.ui.search_players;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import nebrog.dotabuff.R;
import nebrog.dotabuff.data.models.SearchPOJO;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    List<SearchPOJO> search = new ArrayList<>();

    public void setSearches(List<SearchPOJO> searchPOJO) {
        search = searchPOJO;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_users, parent, false);
        SearchViewHolder pvh = new SearchViewHolder(v);
        Log.e("Pek", "5");

        return pvh;
    }


    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

        SearchPOJO searchPOJO = search.get(position);
        Glide
                .with(holder.avatar)
                .load(searchPOJO.avatar)
                .into(holder.avatar);
        holder.idUsers.setText("ID " + searchPOJO.id.toString());
        holder.name.setText(searchPOJO.name);
        if(searchPOJO.lastMatch!=null){
            holder.lastGame.setText(searchPOJO.lastMatch.toString());
        }
        else{
            holder.lastGame.setText("Нет данных о последнем матче");
        }
        Log.e("Pek", "6");

    }



    @Override
    public int getItemCount() {
        return search.size();
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView name;
        TextView idUsers;
        TextView lastGame;


        SearchViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.name);
            idUsers = itemView.findViewById(R.id.idUsers);
            lastGame = itemView.findViewById(R.id.lastGame);
        }
    }
}

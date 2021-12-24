package nebrog.dotabuff;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import Fragment.FragmentAllHeroes;
import Fragment.FragmentUsers;
//import nebrog.dotabuff.network.DotaAPI;
//import nebrog.dotabuff.network.DotaAdapter;
//import nebrog.dotabuff.network.DotaHeroesPOJO;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//import search.Search_Activity;

public class SortActivity extends AppCompatActivity {
    BottomNavigationView.OnItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.allHeroes:
                    loadFragment(FragmentAllHeroes.newInstance());
                    return true;
                case R.id.searchUsers:
                    loadFragment(FragmentUsers.newInstance());
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_view, fragment);
        ft.commit();
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sort_activity);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(mOnNavigationItemSelectedListener);
//        Button nextActivity = findViewById(R.id.searchUsers);
//        View.OnClickListener listenerNext = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SortActivity.this,Search_Activity.class);
//                startActivity(intent);
//            }
//        };
//        nextActivity.setOnClickListener(listenerNext);
//        Button load = findViewById(R.id.button);
//        View.OnClickListener listener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadData();
//            }
//        };
//        load.setOnClickListener(listener);
//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        recyclerView.setAdapter(da);
//
//
//
//    }
//
//    private void loadData() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.opendota.com/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        DotaAPI dotaAPI = retrofit.create(DotaAPI.class);
//        Call<List<DotaHeroesPOJO>> call = dotaAPI.loadHeroes();
//
//        call.enqueue(new HeroCallback());
//    }
//
//    private class HeroCallback implements Callback<List<DotaHeroesPOJO>> {
//        @Override
//        public void onResponse(Call<List<DotaHeroesPOJO>> call, Response<List<DotaHeroesPOJO>> response) {
//            if (response.isSuccessful()) {
//                List<DotaHeroesPOJO> heroes = response.body();
//                da.setHeroes(heroes);
//                Log.e("KekPek", heroes.toString());
//            } else {
//                Log.e("KekPek", response.errorBody().toString());
//            }
//        }
//
//        @Override
//        public void onFailure(Call<List<DotaHeroesPOJO>> call, Throwable t) {
//            Log.e("KekPek", t.getMessage(), t);
//        }
//    }

    }
}

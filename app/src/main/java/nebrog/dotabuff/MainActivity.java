package nebrog.dotabuff;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import nebrog.dotabuff.heroes.FragmentAllHeroes;
import fragment.FragmentUsers;
//import nebrog.dotabuff.network.DotaAPI;
//import nebrog.dotabuff.network.DotaAdapter;
//import nebrog.dotabuff.network.DotaHeroesPOJO;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//import search.Search_Activity;

public class MainActivity extends AppCompatActivity {
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
        setContentView(R.layout.main_activity);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(mOnNavigationItemSelectedListener);


    }
}

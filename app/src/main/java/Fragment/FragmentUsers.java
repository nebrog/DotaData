package Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import nebrog.dotabuff.R;

public class FragmentUsers extends Fragment {
        public FragmentUsers() {
        }

        public static FragmentUsers newInstance() {
            return new FragmentUsers();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_users, container, false);
        }
}

package xin.xiaoa.listen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragmentSearch extends Fragment {

    private Context context;
    private View view;

    @SuppressLint("ValidFragment")

    public FragmentSearch(Context context) {
        this.context = context;
    }

    public FragmentSearch() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);

        return view;
    }

}


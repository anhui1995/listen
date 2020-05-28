package xin.xiaoa.listen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragmentUser extends Fragment {

    private Context context;
    private View view;

    @SuppressLint("ValidFragment")
    public FragmentUser(Context context) {
        this.context = context;
    }

    public FragmentUser() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user, container, false);

        return view;
    }

}

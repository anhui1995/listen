package xin.xiaoa.listen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.Random;

public class FragmentList extends Fragment {

    private Context context;
    private View view;

   // private CircleProgress cnp_citcleNumberProgress;

    @SuppressLint("ValidFragment")
    public FragmentList(Context context) {
        this.context = context;
    }

    public FragmentList() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);

//        cnp_citcleNumberProgress = view.findViewById(R.id.cnp_citcle);
//        cnp_citcleNumberProgress.setProgress(50);


//            <xin.xiaoa.listen.CircleProgress
//        android:id="@+id/cnp_citcle"
//        android:layout_width="match_parent"
//        android:layout_height="300dp"
//
//        android:layout_margin="20dp"/>

        final MainPlayerButton circle=view.findViewById(R.id.win_home);
//        circle.setPercent(10);
//       // circle.setCustomText("呵呵");
//        circle.setProgessColor(getResources().getColor(R.color.blue));
//        final Random random=new Random();
//        circle.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                circle.setPercent(random.nextInt(100));
//            }
//        });

        return view;
    }

}


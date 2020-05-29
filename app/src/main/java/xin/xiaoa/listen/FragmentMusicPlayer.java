package xin.xiaoa.listen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentMusicPlayer  extends Fragment {

    private Context context;
    private View view;

    private TextView tvMainPlayerSong;
    private TextView tvMainPlayerLrc;

    private TextView tvMainPlayerImage;

    private String strSongName = "";
    private String strLrc = "";
    private String strImage = "";
    @SuppressLint("ValidFragment")
    public FragmentMusicPlayer(Context context,String strImage,String strSongName,String strFirstLrc) {
        this.context = context;
        this.strImage = strImage;
        this.strSongName = strSongName;
        this.strLrc = strFirstLrc;

    }

    public void setTextViewLrc(String strLrc){
        tvMainPlayerLrc.setText(strLrc);
    }

    public FragmentMusicPlayer() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_player, container, false);

        tvMainPlayerSong = view.findViewById(R.id.main_player_song);
        tvMainPlayerLrc = view.findViewById(R.id.main_player_lrc);
        tvMainPlayerImage = view.findViewById(R.id.main_player_image);

        tvMainPlayerSong.setText(strSongName);
        tvMainPlayerLrc.setText(strLrc);
        tvMainPlayerImage.setText(strImage);
        return view;
    }

}

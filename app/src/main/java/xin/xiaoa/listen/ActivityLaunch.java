package xin.xiaoa.listen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ActivityLaunch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);


        Intent intent = new Intent();
        intent.setClass(ActivityLaunch.this, ActivityMain.class);
        startActivity(intent);

    }
}

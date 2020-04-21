package android.stack.speak;

import android.os.Bundle;
import android.stack.router_annotation.Route;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author zhangchaozhou
 */
@Route("/SpeakActivity")
public class SpeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak);
    }
}

package android.stack.activityrouterproject;

import android.os.Bundle;
import android.stack.router_annotation.Route;
import android.stack.router_api.Router;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author zhangchaozhou
 */
@Route("/MainActivity")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void listen(View view) {
        Router.getInstance(this).startActivity("/SpeakActivity");
    }

    public void speak(View view) {
        Router.getInstance(this).startActivity("/ListenActivity");
    }
}

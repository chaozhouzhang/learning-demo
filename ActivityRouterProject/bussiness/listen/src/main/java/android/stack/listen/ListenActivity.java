package android.stack.listen;

import android.os.Bundle;
import android.stack.router_annotation.Route;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author zhangchaozhou
 */
@Route("/ListenActivity")
public class ListenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);
    }
}

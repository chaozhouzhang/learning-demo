package android.stack.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author zhangchaozhou
 */
public class MainActivity extends AppCompatActivity  implements ServiceConnection {
    private String TAG = MainActivity.class.getSimpleName();

    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.btn_bind_remote_service);

    }

    IRemoteService iRemoteService;


    public void bindRemoteService(View view) {

        Intent intent = new Intent(this, RemoteService.class);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    public void executeRemoteServiceMethod(View view) {
        try {
            System.out.println("获取远程服务数值：" + iRemoteService.getValue());
            mButton.setText(System.currentTimeMillis() + ":" + iRemoteService.getValue());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * Called when the connection with the service is established
     */
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        // Following the example above for an AIDL interface,
        // this gets an instance of the IRemoteInterface, which we can use to call on the service
        iRemoteService = IRemoteService.Stub.asInterface(service);
        mButton.setText("绑定成功");
    }

    /**
     * Called when the connection with the service disconnects unexpectedly
     */
    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.e(TAG, "Service has unexpectedly disconnected");
        iRemoteService = null;
    }
}

package androidstack.viewbinding

import android.os.Bundle
import androidstack.viewbinding.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //获取绑定类实例
        binding = ActivityMainBinding.inflate(layoutInflater)
        //通过绑定类获取布局后，传给setContentView设置内容视图
        setContentView(binding.root)
        //通过绑定类获取对应的ID视图，进行操作
        binding.tvHelloWorld.text = "视图绑定"
    }
}
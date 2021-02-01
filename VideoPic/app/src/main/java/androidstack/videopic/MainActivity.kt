package androidstack.videopic

import android.content.ClipData
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val REQUEST_CODE_IMAGE = 1001
        const val CHOOSE_PIC_LIMIT = 6
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_choose_pic.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_choose_pic -> {
                val intent = Intent()
                intent.type = "image/*"
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                intent.action = Intent.ACTION_GET_CONTENT
                startActivityForResult(
                    Intent.createChooser(intent, "Select Picture"),
                    REQUEST_CODE_IMAGE
                )
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val uri: Uri
        val fileList: MutableList<String> = ArrayList()
        if (requestCode === REQUEST_CODE_IMAGE && data != null) {
            val imageNames: ClipData? = data.clipData
            if (imageNames != null) {
                if (imageNames.itemCount> CHOOSE_PIC_LIMIT){
                    Toast.makeText(this, "選擇超過限制", Toast.LENGTH_LONG).show()
                    return
                }
                Toast.makeText(this, "多選", Toast.LENGTH_LONG).show()
                for (i in 0 until imageNames.itemCount) {
                    val imageUri: Uri = imageNames.getItemAt(i).uri
                    fileList.add(imageUri.toString())
                    println(imageUri)
                }
                uri = imageNames.getItemAt(0).uri
                iv_pic.setImageURI(uri)
            } else {
                Toast.makeText(this, "單選", Toast.LENGTH_LONG).show()
                uri = data.data!!
                fileList.add(uri.toString())
                iv_pic.setImageURI(uri)
            }
        } else {
            Toast.makeText(this, "沒有選擇", Toast.LENGTH_LONG).show()
        }
    }
}

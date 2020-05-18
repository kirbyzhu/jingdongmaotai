package tv.huan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import tv.huan.myapplication.service.AccessibilityServiceJD
import tv.huan.myapplication.utils.goSettingForAccessibility
import tv.huan.myapplication.utils.isAccessibilityServiceON
import tv.huan.myapplication.utils.loge

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loge("MainActivity onCreate ")
        go_accessibility.setOnClickListener {
            goSettingForAccessibility(this)
        }

    }

    override fun onResume() {
        super.onResume()

        val isOn = isAccessibilityServiceON(this, AccessibilityServiceJD::class.java.name)

        loge("AccessibilityService is $isOn")

        if(isOn){
            accessibilityState.text = resources.getString(R.string.accessibility_on)
            go_accessibility.visibility = View.INVISIBLE
        }else{
            go_accessibility.visibility = View.VISIBLE
            accessibilityState.text = resources.getString(R.string.accessibility_off)
        }

    }
}

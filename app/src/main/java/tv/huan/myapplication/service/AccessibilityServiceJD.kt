package tv.huan.myapplication.service

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import tv.huan.myapplication.utils.loge

class AccessibilityServiceJD : AccessibilityService() {
    override fun onInterrupt() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        loge("event : $event")
        if(event == null) return
        jingDongMaiTai(event)
    }



    private fun jingDongMaiTai(event: AccessibilityEvent){
        val nodeInfo = event.source
        for (index in 0 until nodeInfo.childCount){
            val indexNodeInfo = nodeInfo.getChild(index)
            loge("text : ${indexNodeInfo.text}")
            if("立即抢购" == indexNodeInfo.text){
                indexNodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK)
            }

            if("提交订单" == indexNodeInfo.text){
                indexNodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK)
            }
        }
    }
}

package com.aistra.hailalt.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.aistra.hailalt.HailApp.Companion.app
import com.aistra.hailalt.utils.HShizuku.setAppRestricted
import com.aistra.hailalt.utils.HTarget

class UnsuspendedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == ACTION_PACKAGE_UNSUSPENDED_MANUALLY) runCatching {
            if (HTarget.P) setAppRestricted(
                intent.getStringExtra(Intent.EXTRA_PACKAGE_NAME)!!,
                false
            )
            app.setAutoFreezeService()
        }
    }

    companion object {
        private const val ACTION_PACKAGE_UNSUSPENDED_MANUALLY =
            "android.intent.action.PACKAGE_UNSUSPENDED_MANUALLY"
    }
}
package com.aistra.hailalt.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.aistra.hailalt.app.AppManager
import com.aistra.hailalt.app.HailData

class FrozenWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        inputData.getString(HailData.KEY_PACKAGE)?.let {
            AppManager.setAppFrozen(it, inputData.getBoolean(HailData.KEY_FROZEN, true))
            return Result.success()
        }
        return Result.failure()
    }
}
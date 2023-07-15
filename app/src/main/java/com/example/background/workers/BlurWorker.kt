package com.example.background.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class BlurWorker(context: Context,parameters: WorkerParameters) : Worker(context,parameters) {
    override fun doWork(): Result {

        val appContext = applicationContext
        makeStatusNotification("Bluring the image",appContext)
    }
}
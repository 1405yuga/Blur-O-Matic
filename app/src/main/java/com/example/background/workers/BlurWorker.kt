package com.example.background.workers

import android.content.Context
import android.graphics.BitmapFactory
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.background.R

class BlurWorker(context: Context, parameters: WorkerParameters) : Worker(context, parameters) {
    override fun doWork(): Result {

        val appContext = applicationContext
        makeStatusNotification("Bluring the image", appContext)

        val picture = BitmapFactory
            .decodeResource(appContext.resources, R.drawable.android_cupcake)
        val output = blurBitmap(picture,appContext)
        val outputUri = writeBitmapToFile(appContext,output)
        makeStatusNotification("Output is $outputUri",appContext)

    }
}
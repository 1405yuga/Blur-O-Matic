package com.example.background.workers

import android.content.Context
import android.graphics.BitmapFactory
import android.text.TextUtils
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.background.KEY_IMAGE_URI
import com.example.background.R
private const val TAG = "Blur Worker"

class BlurWorker(context: Context, parameters: WorkerParameters) : Worker(context, parameters) {
    override fun doWork(): Result {

        val appContext = applicationContext

        val resourceUri = inputData.getString(KEY_IMAGE_URI)

        return try {
            makeStatusNotification("Bluring the image", appContext)
            //val picture = BitmapFactory
            //    .decodeResource(appContext.resources, R.drawable.android_cupcake)


            if(TextUtils.isEmpty(resourceUri)){
                Log.e(TAG,"invalid input uri")
                throw IllegalArgumentException("invalid input uri")
            }

            val output = blurBitmap(picture,appContext)
            val outputUri = writeBitmapToFile(appContext,output)
            makeStatusNotification("Output is $outputUri",appContext)

            Result.success()
        }catch(throwable : Throwable){
            Log.e(TAG,"Error applying in bluring")
            Result.failure()
        }




    }
}
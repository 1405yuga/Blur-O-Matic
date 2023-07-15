package com.example.background.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

//  Worker which saves the image permanently
class SaveImageToFileWorker(context: Context, parameters: WorkerParameters) : Worker(context, parameters) {
    override fun doWork(): Result {
        TODO("Not yet implemented")
    }
}
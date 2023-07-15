package com.example.background.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters


//    a Worker which cleans up temp files
class CleanUpWorker(context: Context,parameters: WorkerParameters) : Worker(context,parameters){
    override fun doWork(): Result {
        TODO("Not yet implemented")
    }
}
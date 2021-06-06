package com.example.vocab
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import java.util.*




    class NotificationService : Service() {

        val NOTIFICATION_CHANNEL_ID = "10001"
        private val default_notification_channel_id = "default"
        var timer: Timer? = null
        var timerTask: TimerTask? = null
        var TAG = "Timers"
        var Your_X_SECS: Long = 36000000

        override fun onBind(arg0: Intent?): IBinder? {
            return null
        }

        override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
            Log.e(TAG, "onStartCommand")
            super.onStartCommand(intent, flags, startId)
                startTimer()



            return START_STICKY
        }

        override fun onCreate() {
        }

        override fun onDestroy() {
            Log.e(TAG, "onDestroy")
            stopTimerTask()
            super.onDestroy()
        }

        val handler: Handler = Handler()

        private fun startTimer() {
            timer = Timer()
            initializeTimerTask()
            timer!!.schedule(timerTask, 3600000, Your_X_SECS)
        }

        private fun stopTimerTask() {
            if (timer != null) {
                timer!!.cancel()
                timer = null
            }
        }

        private fun initializeTimerTask() {
            timerTask = object : TimerTask() {
                override fun run() {
                    handler.post(Runnable { createNotification() })
                }
            }
        }

        private fun createNotification() {
            val intentRemind = Intent(applicationContext, NotificationActivity::class.java)
            val intentTransitionRemind = PendingIntent.getActivity(this,1,intentRemind, PendingIntent.FLAG_UPDATE_CURRENT)

            val mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val mBuilder = NotificationCompat.Builder(applicationContext, default_notification_channel_id)
            mBuilder.setContentTitle("Are you remembering these?")
            mBuilder.setContentText("Words are waiting! Check it out!")
            mBuilder.setSmallIcon(R.drawable.ic_launcher_background)
            mBuilder.addAction(R.drawable.ic_launcher_foreground, "Show Me!", intentTransitionRemind)
            mBuilder.setAutoCancel(true)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val importance = NotificationManager.IMPORTANCE_HIGH
                val notificationChannel = NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    "NOTIFICATION_CHANNEL_NAME",
                    importance
                )
                mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID)
                mNotificationManager.createNotificationChannel(notificationChannel)
            }
            mNotificationManager.notify(System.currentTimeMillis().toInt(), mBuilder.build())
        }
    }

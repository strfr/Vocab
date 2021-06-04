package com.example.vocab

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_notification.*


class NotificationActivity : AppCompatActivity() {
    /*private val CHANNEL_1_ID = "channel1"
    private var notificationManager: NotificationManagerCompat? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        val word: String? = intent.getStringExtra("word")
        val status: String? = intent.getStringExtra("status")
        Log.e("qwe", word.toString())
        Log.e("asd", status.toString())
        startService(Intent(this, NotificationService::class.java))

            val intent = Intent(this@NotificationActivity, MainActivity::class.java)
            overridePendingTransition(0, 0)
            startActivity(intent)

        }


        /*notificationManager = NotificationManagerCompat.from(this);
        createNotificationChannels()

        testButton.setOnClickListener {
            //sendOnChannel1()
            val intent = Intent(this, NotificationActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)


            // button
            val broadcastIntent = Intent(this, NotificationReceiver::class.java)
            broadcastIntent.putExtra("toastMessage", message)
            // button
            val actionIntent = PendingIntent.getBroadcast(
                this,
                0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT
            )

            val intentt = Intent(this@NotificationActivity, NotificationActivity::class.java)
            intentt.putExtra("qwe",title)
            val word = "merhaba"
            intentt.putExtra("word",word)
            val intentTransition = PendingIntent.getActivity(this,0,intentt, PendingIntent.FLAG_UPDATE_CURRENT)

            val builder = NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_article_24)
                .setContentTitle("My notification")
                .setContentText("Hello World!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                // Set the intent that will fire when the user taps the notification
                .addAction(R.drawable.ic_baseline_article_24, "Memorized", intentTransition)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(1, builder.build())
            }
        }*/
    }

    /*private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel1 = NotificationChannel(
                CHANNEL_1_ID,
                "Channel 1",
                NotificationManager.IMPORTANCE_LOW
            )
            channel1.description = "This is Channel 1"

            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager.createNotificationChannel(channel1)
        }
    }*/

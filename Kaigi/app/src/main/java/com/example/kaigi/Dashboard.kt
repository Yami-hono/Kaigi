package com.example.kaigi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.common.collect.ImmutableSet.builder
import org.jitsi.meet.sdk.JitsiMeet
import org.jitsi.meet.sdk.JitsiMeetActivity
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import org.json.JSONObject.NULL
import java.net.MalformedURLException
import java.net.URL
import java.util.stream.DoubleStream.builder

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        var code=findViewById<EditText?>(R.id.codebox)
        var joinbtn=findViewById<Button>(R.id.join)
        var sharebtn= findViewById<Button>(R.id.share)


        var serverCode: URL

        try {
            serverCode=URL("https://meet.jit.si")


        } catch (e: MalformedURLException) {
            e.printStackTrace()
            throw RuntimeException("Invalid server URL!")
        }

        var defaultOptions: JitsiMeetConferenceOptions?= JitsiMeetConferenceOptions.Builder().setServerURL(serverCode)
                .setAudioMuted(true)
                .setVideoMuted(true)
                .setAudioOnly(false)
                .setWelcomePageEnabled(false)
                .build()

        JitsiMeet.setDefaultConferenceOptions(defaultOptions)


        joinbtn.setOnClickListener{

            if(code.length()>0)
            {
                var options = JitsiMeetConferenceOptions.Builder()
                        .setRoom(code.text.toString())
                        .build()

                JitsiMeetActivity.launch(this, options)
            }

        }




    }

}
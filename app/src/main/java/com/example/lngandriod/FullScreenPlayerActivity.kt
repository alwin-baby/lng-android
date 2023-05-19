package com.example.lngandriod

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerControlView
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSource

class FullScreenPlayerActivity : FragmentActivity() {
    var data:String?=null
    var text:TextView?=null
    var exoPlayer:ExoPlayer?=null
    private var playerView: PlayerView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_player)
        data = intent.getStringExtra("Url")
        setViews()
        initializePlayer()
    }

    private fun setViews() {
        text = findViewById(R.id.webview)
        playerView = findViewById(R.id.ExoPlayerView)
    }

    private fun initializePlayer() {
        exoPlayer = ExoPlayer.Builder(this) // <- context
            .build()

        data?.let { Log.e("CalledUrl", it) }
        playerView?.player = exoPlayer
        val mediaItem: MediaItem? = data?.let { MediaItem.fromUri(it) }
        if (mediaItem != null) {
            exoPlayer?.setMediaItem(mediaItem)
        }
        exoPlayer?.playWhenReady = true
        exoPlayer?.prepare()
        exoPlayer?.play()

    }


}
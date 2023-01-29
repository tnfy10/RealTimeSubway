package xyz.myeoru.realtimesubway.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import xyz.myeoru.realtimesubway.databinding.ActivityMainBinding
import xyz.myeoru.realtimesubway.presentation.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener {
            viewModel.startReceiveStationInfoJob("부천")
        }

        binding.stopBtn.setOnClickListener {
            viewModel.stopReceiveStationInfoJob()
        }
    }
}

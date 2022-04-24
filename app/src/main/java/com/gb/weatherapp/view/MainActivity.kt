package com.gb.weatherapp.view

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.gb.weatherapp.R
import com.gb.weatherapp.view.experiments.ThreadsFragment
import com.gb.weatherapp.databinding.MainActivityBinding
import com.gb.weatherapp.view.experiments.MainBroadcastReceiver
import com.gb.weatherapp.view.main.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    private val receiver = MainBroadcastReceiver()

//    private lateinit var binding: MainActivityWebviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
//        binding = MainActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.ok.setOnClickListener(clickListener)
        savedInstanceState?.let {
            // TODO
        } ?: run {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitAllowingStateLoss()
        }

        registerReceiver(receiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_screen_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_threads -> {
                supportFragmentManager.apply {
                    beginTransaction()
                        .add(R.id.container, ThreadsFragment.newInstance())
                        .addToBackStack("")
                        .commitAllowingStateLoss()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }

    /*private var clickListener: View.OnClickListener = object : View.OnClickListener {
        @RequiresApi(Build.VERSION_CODES.N)
        override fun onClick(v: View?) {
            try {
                val uri = URL(binding.url.text.toString())
                val handler = Handler() //Запоминаем основной поток
                Thread {
                    var urlConnection: HttpsURLConnection? = null
                    try {
                        urlConnection = uri.openConnection() as HttpsURLConnection
                        urlConnection.requestMethod = "GET" //установка метода получения данных — GET
                        urlConnection.readTimeout = 10000 //установка таймаута — 10 000 миллисекунд
                        val reader =
                            BufferedReader(InputStreamReader(urlConnection.inputStream)) //читаем данные в поток
                        val result = getLines(reader) // Возвращаемся к основному потоку
                        handler.post {
//                            binding.webview.loadData(result, "text/html; charset=utf-8", "utf-8")
                            binding.webview.loadDataWithBaseURL(null, result, "text/html; charset=utf-8", "utf-8", null)
                        }
                    } catch (e: Exception) {
                        Log.e("", "Fail connection", e)
                        e.printStackTrace()
                    } finally {
                        urlConnection?.disconnect()
                    }
                }.start()
            } catch (e: MalformedURLException) {
                Log.e("", "Fail URI", e)
                e.printStackTrace()
            }
        }
        @RequiresApi(Build.VERSION_CODES.N)
        private fun getLines(reader: BufferedReader): String {
            return reader.lines().collect(Collectors.joining("\n"))
        }
    }*/
}

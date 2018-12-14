package com.example.kotlin.databiding

import android.databinding.DataBindingUtil
import android.databinding.ObservableBoolean
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.databiding.databinding.ActivityMainBinding
import com.example.kotlin.databiding.models.Book
import java.util.*
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    var loading:ObservableBoolean= ObservableBoolean(true)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.loading=loading
        loadBook()
    }
    fun loadBook(){
        thread {

            Thread.sleep(3000)
            runOnUiThread{
                binding.book=builBook()
                loading.set(false)
            }

        }

    }
    fun builBook(): Book=Book().apply { name="Android para Dummies"
    img="https://miracomohacerlo.com/wp-content/uploads/2017/09/Android-1.jpg"
    date= Date()
    category=2

    }
}

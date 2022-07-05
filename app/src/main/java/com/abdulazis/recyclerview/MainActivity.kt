package com.abdulazis.recyclerview

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.abdulazis.recyclerview.adapter.AdapterFilm
import com.abdulazis.recyclerview.databinding.ActivityMainBinding
import com.abdulazis.recyclerview.model.Film

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listFilem = ArrayList<Film>()
        listFilem.add(Film("AVENGER ENDGAME",R.drawable.avanger,"22 April 2019","Fantasi","Anthony Rosseo","181 Menit"))
        listFilem.add(Film("AVATAR",R.drawable.avatar,"10 Desember 2019","Fantasi","James Cameron","161 Menit"))
        listFilem.add(Film("TRAIN TO BUSAN",R.drawable.trian,"13 Mei 2016","Horor","Yeon Sang-ho","118 Menit"))
        listFilem.add(Film("MALAFICENT",R.drawable.malaficent,"28 Mei 2014","Fantasi","Robert Stromberg","92 Menit"))
        listFilem.add(Film("TITANIC",R.drawable.titanic,"5 Januari 1998","Romance","James Cameron","194 Menit"))
        listFilem.add(Film("THE NUN",R.drawable.nun,"04 September 2018","HOROR","Corin Hardy","96 Menit"))
        listFilem.add(Film("ALADDIN",R.drawable.aldin,"8 Mei 2019","Komedi","Guy Ritchie","128 Menit"))
        listFilem.add(Film("BEAUTY AND THE BEAST",R.drawable.beast,"23 Februari 2017","Romance","Bill Cordon ","129 Menit"))
        listFilem.add(Film("DILLAN 1990",R.drawable.dilan,"25 Januari 2018","Romance","Fajar Bustomi","110 Menit"))
        listFilem.add(Film("HABIBI DAN AINUN",R.drawable.habibi,"20 Desember 2012","Romance","Fauzan Rizal","118 Menit"))

        binding.list.adapter = AdapterFilm(this,listFilem, object : AdapterFilm.OnClickListener{
            override fun detailData(item: Film?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_film)

                    val image = this.findViewById<ImageView>(R.id.image_filem)
                    val nama = this.findViewById<TextView>(R.id.txtNamaFilem)

                    val tglrilis = this.findViewById<TextView>(R.id.txttglrilis)
                    val genre = this.findViewById<TextView>(R.id.txtgenre)
                    val sutradara = this.findViewById<TextView>(R.id.txtsutradara)
                    val durasi = this.findViewById<TextView>(R.id.txtdurasi)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    tglrilis.text = "${item?.tglrilis}"
                    genre.text = "${item?.genre}"
                    sutradara.text = "${item?.sutradara}"
                    durasi.text = "${item?.durasi}"
                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }

        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectesMode: Int) {
        when (selectesMode) {
            R.id.myprofil -> {
                val intent = Intent (this,Profile::class.java)
                startActivity(intent)
            }
        }
    }
}
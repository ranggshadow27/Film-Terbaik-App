package com.ranggatitoprayogo.filmterbaik
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ranggatitoprayogo.filmterbaik.adapter.AdapterFilm
import com.ranggatitoprayogo.filmterbaik.databinding.ActivityMainBinding
import com.ranggatitoprayogo.filmterbaik.model.Film

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listFilm = ArrayList<Film>()
        listFilm.add(Film("The Lord Of The Rings : The Fellowship Of The Ring",R.drawable.fellowship_of_therings, "Action, Adventure, Drama", "6 February 2002", "Peter Jackson", "8.8/10"))
        listFilm.add(Film("The Lord Of The Rings : The Two Towers",R.drawable.the_two_towers, "Action, Adventure, Drama", "15 January 2003", "Peter Jackson", "8.8/10"))
        listFilm.add(Film("The Lord Of The Rings : The Return of the King",R.drawable.return_of_the_king, "Action, Adventure, Drama", "14 Januray 2004", "Peter Jackson", "9.0/10"))
        listFilm.add(Film("The Hobbit : An Unexpected Journey",R.drawable.unexpected_journey, "Adventure, Fantasy", "14 December 2012", "Peter Jackson", "7.8/10"))
        listFilm.add(Film("The Hobbit : The Desolation of Smaug",R.drawable.desolation_of_smaug, "Adventure, Fantasy", "13 December 2013", "Peter Jackson", "7.8/10"))
        listFilm.add(Film("The Hobbit : The Battle of Five Armies",R.drawable.battle_of_five_armies, "Adventure, Fantasy", "17 December 2014", "Peter Jackson", "7.4/10"))
        listFilm.add(Film("Raya and the Last Dragon",R.drawable.raya_and_tl_dragon, "Adventure, Animation, Fantasy", "3 March 2021", "Don Hall, Paul Briggs, Carlos Lopez Estrada", "7.3/10"))
        listFilm.add(Film("Hotel Transylvania : Summer Vacation",R.drawable.hotel_trans_summer_vacation, "Adventure, Animation, Comedy", "13 July 2018", "Genndy Tartakovsky", "6.3/10"))
        listFilm.add(Film("Transformers : Revenge of the Fallen",R.drawable.revenge_of_the_fallen, "Action, Adventure, Fantasy", "24 June 2009", "Michael Bay", "5.9/10"))
        listFilm.add(Film("Transformers : Dark of the Moon",R.drawable.dark_of_the_moon, "Action, Adventure, Fantasy", "5 August 2011", "Michael Bay", "6.2/10"))
        listFilm.add(Film("Transformers : Age Of Extinction",R.drawable.age_of_extinction, "Action, Adventure, Fantasy", "5 June 2014", "Michael Bay", "5.6/10"))
        listFilm.add(Film("Transformers : The Last Knight",R.drawable.last_knight, "Action, Adventure, Fantasy", "21 June 2017", "Michael Bay", "5.2/10"))

        binding.list.adapter = AdapterFilm(this, listFilm, object : AdapterFilm.OnClickListener{
            override fun detailData(item: Film?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_info_film)

                    val image = this.findViewById<ImageView>(R.id.txt_judulfilm)
                    val nama = this.findViewById<TextView>(R.id.txt_judulfilm)
                    val posisi = this.findViewById<TextView>(R.id.txt_genre)
                    val tinggi = this.findViewById<TextView>(R.id.txt_tahunrilis)
                    val tempatlahir = this.findViewById<TextView>(R.id.txt_director)
                    val tgllahir = this.findViewById<TextView>(R.id.txt_rating)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.genre}"
                    tinggi.text = "${item?.tahun}"
                    tempatlahir.text = "${item?.director}"
                    tgllahir.text = "${item?.rating}"

                    btn.setOnClickListener{
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

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.myprofile -> {
                val intent = Intent(this, MyProfile::class.java)
                startActivity(intent)
            }
        }
    }
}












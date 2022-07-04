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
        listFilm.add(Film("Albedo",R.drawable.fellowship_of_therings, "Mondstandt", "1.6m", "Unknown?", "20 May"))
        listFilm.add(Film("Xiao",R.drawable.the_two_towers, "Liyue Adepti", "1.6m", "Unknown?", "20 May"))
        listFilm.add(Film("Kaedahara Kazuha",R.drawable.unexpected_journey, "Inazuma", "1.7m", "Inazuma", "20 May"))
        listFilm.add(Film("Kujou Sara",R.drawable.desolation_of_smaug, "Inazuma", "1.8m", "Inazuma", "20 May"))
        listFilm.add(Film("Sangonomiya Kokomi",R.drawable.battle_of_five_armies, "Inazuma", "1.6m", "Watatsumi Island", "20 May"))
        listFilm.add(Film("Yelan",R.drawable.raya_and_tl_dragon, "Liyue", "1.9m", "Liyue", "20 May"))

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












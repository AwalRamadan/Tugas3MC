package com.example.tugas4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugas4.databinding.ActivityContenBinding

class ContenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namaMenu = intent.getStringExtra("nama")
        val deskripsiMenu = intent.getStringExtra("deskripsi")
        val gambarMenu = intent.getIntExtra("gambar", 0)
        val bahanMenu = intent.getStringExtra("bahan")
        val langkahMenu = intent.getStringExtra("langkah")
        val videoUrl = intent.getStringExtra("videoUrl")

        binding.tvNama.text = namaMenu
        binding.tvDeskripsi.text = deskripsiMenu
        binding.imageMenu.setImageResource(gambarMenu)

        binding.tvBahan.text = bahanMenu ?: "Bahan tidak tersedia"
        binding.tvLangkah.text = langkahMenu ?: "Langkah tidak tersedia"

        binding.textkeconten.text = when (namaMenu){
            "Kopi SEO Regal" -> "Tonton cara membuat Kopi SEO Regal di sini!"
            "Kopi Susu" -> "Lihat tutorial membuat Kopi Susu!"
            "Kopi Hitam" -> "Pelajari cara menyeduh Kopi Hitam yang sempurna!"
            else ->"Klik tombol di bawah untuk menonton tutorial lengkap!"
        }


        binding.btnKembali.setOnClickListener{
            if (!videoUrl.isNullOrEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

                intent.setPackage("com.google.android.youtube")

                if (intent.resolveActivity(packageManager) == null) {
                    intent.setPackage(null)
                }
                startActivity(intent)
            }else {
                binding.btnKembali.text = "Video Tidak Tersedia"
            }
        }
    }
}
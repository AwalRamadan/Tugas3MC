package com.example.tugas4

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tugas4.databinding.ActivityItemMenuBinding
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val menuList: List<MenuItem>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(val binding: ActivityItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding =
            ActivityItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = menuList[position]
        with(holder.binding) {
            imageMenu.setImageResource(item.gambar)
            NamaMenu.text = item.nama
            Deskripsi.text = item.deskripsi

            Detail.setOnClickListener {
                val (bahan, langkah, videoUrl) = when (item.nama) {
                    "Kopi SEO Regal" -> Triple(
                        "• Kopi\n• Biskuit Regal\n• Susu\n• Gula",
                        "1. Campurkan kopi dan susu\n2. Tambahkan gula\n3. Hancurkan biskuit regal dan aduk",
                        "https://www.youtube.com/watch?v=xyz123"
                    )
                    "Kopi Susu" -> Triple(
                        "• Kopi\n• Susu\n• Gula",
                        "1. Seduh kopi\n2. Tambahkan susu dan gula\n3. Aduk hingga merata",
                        "https://www.youtube.com/watch?v=abc456"
                    )
                    "Kopi Hitam" -> Triple(
                        "• Kopi bubuk\n• Air panas",
                        "1. Seduh kopi dengan air panas\n2. Aduk dan sajikan",
                        "https://www.youtube.com/watch?v=def789"
                    )
                    else -> Triple("", "", "")
                }

                val intent = Intent(holder.itemView.context, ContenActivity::class.java).apply {
                    putExtra("nama", item.nama)
                    putExtra("gambar", item.gambar)
                    putExtra("deskripsi", item.deskripsi)
                    putExtra("bahan", bahan)
                    putExtra("langkah", langkah)
                    putExtra("videoUrl", videoUrl)
                }

                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = menuList.size
}

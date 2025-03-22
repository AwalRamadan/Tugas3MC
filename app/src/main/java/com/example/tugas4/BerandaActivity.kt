    package com.example.tugas4

    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import androidx.recyclerview.widget.LinearLayoutManager
    import com.example.tugas4.databinding.ActivityBerandaBinding


    class BerandaActivity : AppCompatActivity() {
        private lateinit var binding: ActivityBerandaBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityBerandaBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val menuList = listOf(
                MenuItem("Kopi SEO Regal", "Kopi dengan biskuit regal yang creamy", R.drawable.kopi_regal),
                MenuItem("Kopi Susu", "Kopi susu dengan rasa klasik", R.drawable.kopi_susu_gulaaren),
                MenuItem("Kopi Hitam", "Kopi hitam pekat tanpa tambahan", R.drawable.kopi_butterscotch_sea),
                MenuItem("Es Kopi Coklat", "Kombinasi kopi dan coklat yang nikmat", R.drawable.es_kopi_latte)
            )
            binding.recyclerViewMenu.layoutManager = LinearLayoutManager(this)
            binding.recyclerViewMenu.adapter = MenuAdapter(menuList)
        }
    }
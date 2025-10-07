package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onClick(cat: CatModel) {
                showSelectionDialog(cat)   // ✅ cuma satu, ga dobel
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        //Instantiate ItemTouchHelper for the swipe to delete callback and
//attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BalineseJavanese,
                    "Luna",
                    "Loves sleeping on the keyboard",
                    "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "Simba",
                    "King of the sofa jungle",
                    "https://cdn2.thecatapi.com/images/OTY4ODkwNQ.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Mochi",
                    "Food lover",
                    "https://cdn2.thecatapi.com/images/1fj.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Oliver",
                    "Curious and playful",
                    "https://cdn2.thecatapi.com/images/4fe.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Chloe",
                    "Queen of cuteness",
                    "https://cdn2.thecatapi.com/images/ai9.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.AmericanCurl,
                    "Leo",
                    "Chases everything",
                    "https://cdn2.thecatapi.com/images/c9c.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.ExoticShorthair,
                    "Mimi",
                    "Silent observer",
                    "https://cdn2.thecatapi.com/images/ab1.jpg"
                )
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}

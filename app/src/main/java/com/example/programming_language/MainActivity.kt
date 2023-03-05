package com.example.programming_language

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.programming_language.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Language>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvLanguages.setHasFixedSize(true)

        list.addAll(getListLanguage())
        showRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun getListLanguage(): ArrayList<Language> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listLanguage = ArrayList<Language>()

        for (i in dataName.indices) {
            val language = Language(dataName[i], dataDesc[i], dataPhoto.getResourceId(i, -1))
            listLanguage.add(language)
        }
        return listLanguage
    }

    private fun showRecyclerView() {
        binding.rvLanguages.layoutManager = LinearLayoutManager(this)
        val listLanguageAdapter = ListLanguageAdapter(list) {
            moveDetailActivity(it)
        }
        binding.rvLanguages.adapter = listLanguageAdapter
    }

    private fun moveDetailActivity(language: Language) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_LANGUAGE, language)
        startActivity(intent)
    }
    fun moveAboutActivity(){
        val intent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(intent)
    }

    fun setMode(selectedMode: Int) {
        when (selectedMode){
            R.id.about_page -> {
                moveAboutActivity()
            }
        }
    }
}
package com.example.demo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R.id.SprogressBar
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.FileAsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import jxl.Cell
import jxl.Sheet
import jxl.Workbook
import jxl.WorkbookSettings
import jxl.read.biff.BiffException
import java.io.File
import java.io.IOException


class StationsActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: StationsAdapter
    lateinit var client: AsyncHttpClient
    lateinit var nameS : MutableList<String>
     lateinit var progressBar : ProgressBar
    lateinit var sync : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stations)

        recyclerView = findViewById(R.id.listOfStations)
        progressBar = findViewById(R.id.SprogressBar)
        sync = findViewById(R.id.Ssync)

        val URL: String =
            "https://github.com/mdhafizur/new/blob/master/Test.xls?raw=true"

        nameS = ArrayList()


        this.client = AsyncHttpClient()
        progressBar.visibility = View.VISIBLE
        sync.visibility = View.VISIBLE
        this.client.get(URL, object : FileAsyncHttpResponseHandler(this) {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, file: File?) {

                progressBar.visibility = View.GONE
                sync.visibility = View.GONE

                Toast.makeText(this@StationsActivity, "File Synced", Toast.LENGTH_SHORT).show()

                val ws = WorkbookSettings()
                ws.setGCDisabled(true)
                if (file != null) {
                    //text.setText("Success, DO something with the file.");
                    /* wait.setVisibility(View.GONE)
                     progressBar.setVisibility(View.GONE)*/
                    try {
                        var workbook = Workbook.getWorkbook(file)
                        val sheet: Sheet = workbook.getSheet(0)
                        val row: Array<Cell> = sheet.getRow(3)
                        nameS.add(row[0].getContents())
                        nameS.add(row[1].getContents())
                        nameS.add(row[2].getContents())
                        val r: Array<Cell> = sheet.getRow(6)
                        nameS.add(r[0].getContents())
                        nameS.add(r[1].getContents())



                        showData()
                        Log.d("TAG", "onSuccess: "+ nameS)

                    } catch (e: IOException) {
                        e.printStackTrace()
                    } catch (e: BiffException) {
                        e.printStackTrace()
                    }
                }

            }


            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                throwable: Throwable?,
                file: File?
            ) {
                progressBar.visibility = View.GONE
                sync.visibility = View.GONE
                Toast.makeText(this@StationsActivity, "Download Failed", Toast.LENGTH_SHORT)
                    .show()



            }


        })   //End of asynctask



    }
    fun showData(){
        recyclerView = findViewById(R.id.listOfStations)
        adapter = StationsAdapter(this, nameS)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }












    fun goBack(view: View) {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }

    fun stationInfo(view: View) {
        val intent = Intent(applicationContext, ParametersActivity::class.java)
        startActivity(intent)
    }

    fun stationLocation(view: View) {
        val intent = Intent(applicationContext, StationsMapsActivity::class.java)
        startActivity(intent)
    }
}
package com.example.demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stations)

        val URL: String =
            "https://github.com/mdhafizur/eetsbApp/blob/master/app/src/main/assets/Test.xlsx"

        recyclerView = findViewById(R.id.listOfData)
        adapter = StationsAdapter(this)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = adapter






        client = AsyncHttpClient()
        client.get(URL, object : FileAsyncHttpResponseHandler(this) {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, file: File?) {


                Toast.makeText(this@StationsActivity, "File Downloaded", Toast.LENGTH_SHORT).show()
                val ws = WorkbookSettings()
                ws.setGCDisabled(true)
                if (file != null) {
                    //text.setText("Success, DO something with the file.");
                    /* wait.setVisibility(View.GONE)
                     progressBar.setVisibility(View.GONE)*/
                    try {
                        var workbook = Workbook.getWorkbook(file)
                        val sheet: Sheet = workbook!!.getSheet(0)
                        //Cell[] row = sheet.getRow(1);
                        //text.setText(row[0].getContents());
                        /* for (i in 0 until sheet.getRows()) {
                             val row: Array<Cell> = sheet.getRow(i)
                             storyTitle.add(row[0].getContents())
                             storyContent.add(row[1].getContents())
                             thumbImages.add(row[2].getContents())
                         }
                         showData()*/
                        var nameS: Cell = sheet.getCell(0, 0)
                        println(nameS)
                        println("Hafiz")
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

                Toast.makeText(this@StationsActivity, "Download Failed", Toast.LENGTH_SHORT)
                    .show()
                TODO("Not yet implemented")
            }


        })   //End of asynctask


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
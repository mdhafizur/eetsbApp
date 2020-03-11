package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_stations.*
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileInputStream
import java.io.IOException


class StationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stations)


        val a = readFromExcel("C:\\Users\\Hafiz\\Exercism\\java\\KotTest\\src\\Test.xlsx")
        val textView = findViewById<TextView>(R.id.batteryT)
        println(a)
        textView.text = a



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

    @Throws(IOException::class)
    fun readFromExcel(file: String): CharSequence {

        val myExcelBook = XSSFWorkbook(FileInputStream(file))
        val myExcelSheet = myExcelBook.getSheet("Test")
        val row = myExcelSheet.getRow(6)

        if (row.getCell(1).cellType == XSSFCell.CELL_TYPE_NUMERIC) {
            var batteryLevel: Number = row.getCell(1).numericCellValue
            /*   return batteryLevel*/
            /*println("DOB :$birthdate")*/
            return batteryLevel.toString()


        }

        myExcelBook.close()
        return "Error"
    }


}

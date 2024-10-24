package com.apellido.nombre.chats

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate


class MainActivity : AppCompatActivity() {
    private val xValues: List<String> = mutableListOf("Maths", "Science", "English", "IT")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val barChart = findViewById<BarChart>(R.id.chart)
        barChart.axisRight.setDrawLabels(false)

        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(0f, 45f))
        entries.add(BarEntry(1f, 80f))
        entries.add(BarEntry(2f, 65f))
        entries.add(BarEntry(3f, 38f))

        val yAxis = barChart.axisLeft
        yAxis.axisMaximum = 0f
        yAxis.axisMaximum = 100f
        yAxis.axisLineWidth = 2f
        yAxis.axisLineColor = Color.BLACK
        yAxis.labelCount = 10

        val dataSet = BarDataSet(entries, "Subjects")
        dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)

        val barData = BarData(dataSet)
        barChart.data = barData

        barChart.description.isEnabled = false
        barChart.invalidate()

        barChart.xAxis.valueFormatter = IndexAxisValueFormatter(xValues)
        barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        barChart.xAxis.granularity = 1f
        barChart.xAxis.isGranularityEnabled = true
    }
}
          
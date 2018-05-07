/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ggpack;

import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



/**
 * Klasa <code>DrawPanel</code> generuje wykres wraz z tytułem,opisem osi,
 * skalą na osiach oraz legendą opisującą przebiegi.
 * 
 * @author Jacek Sobiecki
 * @author Piotr Szubert
 */
public class DrawPanel {
   
   public DrawPanel() {
 }
   
 /**
  * Tworzy wykres i ustala jego parametry( np. kolor, opisy osi...).
  * @param dataset przedstawia opis funkcji w postaci (x,y)
  * @return wykres
  */
 private static JFreeChart createChart(XYDataset dataset){
 JFreeChart chart = ChartFactory.createXYLineChart(
 "Wykres Geogebry", "Pulsacja [rad]",
 "Wartosc [1]", dataset, PlotOrientation.VERTICAL,
 true, false, false);
 chart.setBackgroundPaint(Color.lightGray);

 XYPlot plot = (XYPlot) chart.getPlot();
 plot.setBackgroundPaint(Color.white);
 plot.setDomainGridlinePaint(Color.black);
 plot.setRangeGridlinePaint(Color.black);

 return chart;
 }
 
 /**
  * Tworzy obiekt przedstawiający opis funkcji w układzie kartezjańskim.
  * @return obiekt przedstawiający opis funkcji w postaci (x,y)
  */
 private static XYDataset createDataset() {
 XYSeries s1 = new XYSeries("GeoGebra");
 int step =(int)Data.kat;
 Data.kat=0;
 Data.min=Data.calculate();
 Data.max=Data.calculate();
 
 for (int i = 0; i < step-1 ; i++) {
 Data.kat+=0.01745329;
 double x = Data.kat;
 double y = Data.calculate();
 s1.add(x, y);
 double y1=Data.calculate();
 double y2=Data.calculate();
 Data.max=Math.max(y1,Data.max);
 Data.min=Math.min(y2,Data.min);  
 }
 XYSeriesCollection dataset = new XYSeriesCollection();
 dataset.addSeries(s1);
 return dataset;
 }

 /**
  * Tworzy obiekt przechowujący wykres.
  * @return obiekt przechowujący wykres
  */
 public static JPanel createWoPanel() {
 JFreeChart chart = createChart(createDataset());
 return new ChartPanel(chart);
 }
}




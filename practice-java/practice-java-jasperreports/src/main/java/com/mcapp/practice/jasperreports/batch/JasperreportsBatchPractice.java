package com.mcapp.practice.jasperreports.batch;

import java.net.URL;
import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JasperreportsBatchPractice {
	public static void main(String[] args) throws Exception {
		HashMap<String, Object> reportParameters = new HashMap<String, Object>();
		reportParameters.put("Name", "Marco Chan");
		JREmptyDataSource jrEmptyDataSource = new JREmptyDataSource(1);

		URL url = JasperreportsBatchPractice.class.getResource("/UserProfileReport.jasper");
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(url);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportParameters, jrEmptyDataSource);

		JasperViewer jasperViewer = new JasperViewer(jasperPrint);
		jasperViewer.setVisible(true);
	}
}

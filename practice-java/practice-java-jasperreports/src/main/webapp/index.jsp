<%@ page language="java" %>
<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="net.sf.jasperreports.engine.export.*" %>
<%@ page import="net.sf.jasperreports.engine.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%
	HashMap<String, Object> reportParameters = new HashMap<String, Object>();
	reportParameters.put("Name", "Marco Chan");
	JREmptyDataSource jrEmptyDataSource = new JREmptyDataSource(1);

	InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("UserProfileReport.jasper"); 
	JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportParameters, jrEmptyDataSource);
	
	OutputStream outputStream = response.getOutputStream();
	response.setContentType("application/pdf");
	JRExporter jrExporter = new JRPdfExporter();
	jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
	
	try {
		jrExporter.exportReport();
	} catch (JRException e) {
		throw new ServletException(e);
	} finally {
		if (outputStream != null) {
			try {
				outputStream.close();
			} catch (IOException ex) {
			}
		}
	}
%>

package com.diginepal.schoolmgmt.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diginepal.schoolmgmt.entities.Marks;
import com.diginepal.schoolmgmt.repo.MarksRepo;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/report")
public class ReportRestController {
	
	@Autowired
	private MarksRepo marksRepo;
	
	@GetMapping(value="/pdf/exam/{examid}/student/{studentid}")
	public void pdf(@PathVariable int examid, @PathVariable int studentid, HttpServletResponse response) 
	{
		try {
			List<Marks> markslist=marksRepo.findByExamIdAndStudentId(examid, studentid);
			JasperReport report=JasperCompileManager.compileReport("D:\\marks.jrxml");
			JRDataSource datasource = new JREmptyDataSource();
			Map<String, Object> parameters=new HashMap<String, Object>();
			parameters.put("school", "This is schoolname");
			JasperPrint jasperPrint=JasperFillManager.fillReport(report, parameters,datasource);
			JasperExportManager.exportReportToPdfFile(jasperPrint,"D:\\marks_sheet.pdf");
			
			
			
			/*ServletOutputStream servletOutputStream=response.getOutputStream();
			
			//get data from database
			List<Marks> list = marksRepo.findByExamIdAndStudentId(examid, studentid);
			
			//create jasper supportive collection
			//JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(list);
			
			
			//set collection as parameter
			
			
			//parameters.put("ds", ds);
			
			System.out.println(parameters);
			//pass parameter to jasper
			//JasperReport report=(JasperReport) JRLoader.loadObject("D:/marks.jasper");
			
			
			System.out.println("jasper print found");
			
			byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
			response.getOutputStream().write(bytes);
			response.setContentType("application/pdf");
			servletOutputStream.flush();
			servletOutputStream.close();*/
		}
		catch (Exception e) {
			System.out.println("exception found");
			System.out.println(e);
		}
	}
	
	


}

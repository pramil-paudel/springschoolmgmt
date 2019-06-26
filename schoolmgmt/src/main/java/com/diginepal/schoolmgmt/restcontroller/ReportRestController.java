package com.diginepal.schoolmgmt.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diginepal.schoolmgmt.entities.Marks;
import com.diginepal.schoolmgmt.repo.GradesheetRepo;
import com.diginepal.schoolmgmt.repo.MarksRepo;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/report")
public class ReportRestController {
	
	@Autowired
	private MarksRepo marksRepo;
	
	@Autowired GradesheetRepo gradesheetRepo;
	
	@PostMapping(value="/pdf/exam/{examid}/student/{studentid}")
	public void pdf(@PathVariable int examid, @PathVariable int studentid,HttpServletResponse response) 
	{
		try {
			ServletOutputStream servletOutputStream=response.getOutputStream();
		List<Marks> markslist=marksRepo.findByExamIdAndStudentId(examid, studentid);
		String result="PASSED";
		Double passmarks_th, passmarks_pr, obtmarks_th, obtmarks_pr;
		Double obt_total=0.00;
		Double subjects_total=0.00;
		
		for(Marks marks:markslist) {
			passmarks_th=marks.getSubjects().getPassmarks_th();
			passmarks_pr=marks.getSubjects().getPassmarks_pr();
			
			obtmarks_th=marks.getThmarks();
			obtmarks_pr=marks.getPrmarks();
			
			
			
			if(obtmarks_th<passmarks_th || obtmarks_pr<passmarks_pr) {
				result="FAILED";
			}
			subjects_total=marks.getSubjects().getFullmarks_pr()+marks.getSubjects().getFullmarks_th();
			obt_total=obtmarks_th+obtmarks_pr;
		}
		
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(markslist);
			JasperReport report=JasperCompileManager.compileReport("/opt/tomcat/webapps/reports/school");
			Map<String, Object> parameters=new HashMap<String, Object>();
			parameters.put("schoolname", "SUNRISE BOARDING SCHOOL");
			parameters.put("schooladdress", "ChapaliGhumti, Budhanilkantha");
			
			Double percentage_total=(obt_total/subjects_total)*100;
			String finalgrade=gradesheetRepo.findGradeByMarks(percentage_total).getGrade();
			parameters.put("finalgrade", finalgrade);
			parameters.put("result", result);
			parameters.put("ds", ds);
			JasperPrint jasperPrint=JasperFillManager.fillReport(report, parameters,ds);
			//JasperExportManager.exportReportToPdfFile(jasperPrint,"D:\\marks_sheet.pdf");
			byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
			response.getOutputStream().write(bytes);
			response.setContentType("application/pdf");
			servletOutputStream.flush();
			servletOutputStream.close();
		}
		catch (Exception e) {
			System.out.println("exception found");
			System.out.println(e);
		}
		
	}
	
	


}

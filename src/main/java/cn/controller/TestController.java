package cn.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.entity.TestTable;
import cn.servcie.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService testService;
	
	@RequestMapping("select")
		public String select(Model model){
		model.addAttribute("list", testService.getAll());
			return "index";
		}
	
	@RequestMapping("add.html")
	public String add(TestTable testTable,@RequestParam("file") MultipartFile mut,HttpServletRequest request) throws IllegalStateException, IOException{
		String path = request.getSession().getServletContext().getRealPath("/updat");
		String name =mut.getOriginalFilename();
		if (!mut.isEmpty()) {
			File file = new File(path,name);
			mut.transferTo(file);
			testTable.setFileName(name);
		}
		if (testService.add(testTable)) {
			return "index";
		}
		
		
		return "sdffs";
	}
	
	@RequestMapping("poi.json")
	@ResponseBody
	public Object poi() throws IOException{
		HashMap<String , String> map =new HashMap<String, String>();
		List<TestTable> list = testService.getAll();
		try{
		HSSFWorkbook wb  = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("getAll");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("id");
		row.createCell(1).setCellValue("name");
		row.createCell(2).setCellValue("fileName");
		for (int i = 0; i < list.size(); i++) {
			TestTable testTable = list.get(i);
			row = sheet.createRow(i+1);
			row.createCell(0).setCellValue(testTable.getId());
			row.createCell(1).setCellValue(testTable.getName());
			row.createCell(2).setCellValue(testTable.getFileName());
		}
		FileOutputStream fos = new FileOutputStream("c:\\getAll.xls");
		wb.write(fos);
		fos.close();
		map.put("message", "true");
		}catch(Exception e){
			e.printStackTrace();
			map.put("message", "false");
		}
		return map;
	}
}

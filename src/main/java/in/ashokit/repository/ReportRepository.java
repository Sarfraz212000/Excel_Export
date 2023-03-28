 package in.ashokit.repository;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.BookEntity;

@Service
public class ReportRepository {
	
	@Autowired
	private BookRepository repo;
	
	
	public void genrateExcel(HttpServletResponse response) throws IOException
	{
		// read the data from db table
		List<BookEntity> findAll = repo.findAll();
		
		// craeting  excel
		HSSFWorkbook Workbook= new HSSFWorkbook();
		HSSFSheet sheet = Workbook.createSheet("Book information");
		HSSFRow row = sheet.createRow(0);
		
		
		row.createCell(0).setCellValue("bookid");
		row.createCell(1).setCellValue("bookName");
		row.createCell(3).setCellValue("bookprice");
		
		int rowIndex=1;
		//getting the data 
		for(BookEntity book:findAll)
		{
			HSSFRow dataRow = sheet.createRow(rowIndex);
			dataRow.createCell(0).setCellValue(book.getBookid());
			dataRow.createCell(1).setCellValue(book.getBookName());
			dataRow.createCell(3).setCellValue(book.getBookPrice());
			rowIndex++;
		}
		//storing the data in excel
		ServletOutputStream outputStream = response.getOutputStream();
		Workbook.write(outputStream);
		Workbook.close();
		outputStream.close();
		
	}

}

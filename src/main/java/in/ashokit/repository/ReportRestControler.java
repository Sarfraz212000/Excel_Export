package in.ashokit.repository;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportRestControler {

	
	@Autowired
	private ReportRepository repository;
	
	@GetMapping("/excel")
	public void genrateExcel(HttpServletResponse response) throws IOException
	{
		response.setContentType("application/octet-stream");
		
		String headerkey="content-disposition";
		String headerValue="attchement;filename=book.xls";
		
		response.setHeader(headerkey, headerValue);
		
		repository.genrateExcel(response);
		
	}
}

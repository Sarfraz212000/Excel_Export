package in.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;



@Data
@Entity
public class BookEntity {
	@Id
	private Integer bookid;
	private String bookName;
	private Double bookPrice;
	

}

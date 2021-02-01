package hu.ponte.hr.services;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;

import hu.ponte.hr.controller.ImageMeta;
import hu.ponte.hr.mapper.ImageMapper;


public class ImageStoreImpl implements ImageStore {


	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	   
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    	this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
	   
	
	@Override
	 public void insertImage(MultipartFile file){
	      String SQL = "INSERT INTO images " +
					"(imageId, imageName, mimeType, imageSize, digitalSign) VALUES (?, ?, ?, ?, ?)" ;
	      jdbcTemplateObject.update(SQL, 2, file.getName(), file.getContentType(), file.getSize(), "dd");
	      System.out.println("Updated Record with ID = " + "1" );
	      return;
	   }


	@Override
	public ImageMeta getImage(String id) {
		  String SQL = "select * from images where id = ? ";
	     ImageMeta im = jdbcTemplateObject.queryForObject(
	 	         SQL, new Object[]{id}, new ImageMapper());
	      return im;
	}
		
}

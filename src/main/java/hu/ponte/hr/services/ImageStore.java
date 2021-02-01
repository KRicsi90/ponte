package hu.ponte.hr.services;


import javax.sql.DataSource;

import org.springframework.web.multipart.MultipartFile;

import hu.ponte.hr.controller.ImageMeta;


public interface ImageStore {
	void insertImage(MultipartFile file);
	ImageMeta getImage(String id);
	public void setDataSource(DataSource ds);

}

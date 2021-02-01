package hu.ponte.hr.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import hu.ponte.hr.controller.ImageMeta;

public class ImageMapper implements RowMapper<ImageMeta> {
   public ImageMeta mapRow(ResultSet rs, int rowNum) throws SQLException {
      ImageMeta imageMeta = new ImageMeta();
      return imageMeta;
   }
}
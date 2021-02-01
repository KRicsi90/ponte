DROP TABLE IF EXISTS images;

 create table images (
  imageId INTEGER NOT NULL,
  imageName VARCHAR(100) NOT NULL,
  mimeType VARCHAR(100) NOT NULL,
  imageSize INTEGER,
  digitalSign VARCHAR(1000) NOT NULL,
  PRIMARY KEY (imageId)
  );
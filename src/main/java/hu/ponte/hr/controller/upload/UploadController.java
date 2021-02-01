package hu.ponte.hr.controller.upload;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import hu.ponte.hr.services.ImageStoreImpl;
@Component
@RequestMapping("api/file")
public class UploadController
{
	ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	ImageStoreImpl imageStore = con.getBean("ImageStoreImpl",ImageStoreImpl.class);

    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    public String handleFormUpload(@RequestParam("file") MultipartFile file) {
    	imageStore.insertImage(file);
        return "ok";
    }
}

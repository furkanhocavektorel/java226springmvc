package com.vektorel.firstproject.util;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
@Configuration
public class MultiPart {



    public String multipartToUrl(MultipartFile file){
        Cloudinary cloudinary= new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name","de7jjkp9g",
                        "api_key","941968759529494",
                        "api_secret","XECh9rYDStZTK8JI1lHZO3j9OdM"));
        try {
            Map<?,?> cloudinaryResponse =
                    cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
            String url =(String) cloudinaryResponse.get("url");
            return url;

        }catch (IOException e){
            System.out.println("****** HATA ALDIK ********");
            e.printStackTrace();
            return null;
        }

    }



}

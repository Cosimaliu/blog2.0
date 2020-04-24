package com.lrm.util;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * public method
 */
public class MYUtils {
    /**
     * 图片上传
     */
    public static String upimg(MultipartFile file){
        if(file.isEmpty()){
            System.out.println("文件空！！");
        }
        String fileName = file.getOriginalFilename();//文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));//后缀名
        String filePath = "D:\\java\\blog\\src\\main\\resources\\static\\images\\";
        fileName = UUID.randomUUID() + suffixName;//新文件名
        File dest = new File(filePath + fileName);
        //首先创建父类文件夹
        if(!dest.getParentFile().exists()){
            //为什么用mkdirs()呢？因为这个方法可以在不知道偶没有父类文件夹的情况下，创建文件夹，而mkdir（）必须在有父类的文件夹下创建文件
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        }catch (IOException e){
            e.printStackTrace();
        }
        String fileName1 = "/images/" + fileName;
        return fileName1;
    }
}

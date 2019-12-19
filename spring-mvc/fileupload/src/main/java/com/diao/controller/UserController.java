package com.diao.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author: Chenzhidiao
 * @date: 2019/12/18 15:11
 * @description:
 * @version: 1.0
 */
@Controller
public class UserController {
    @RequestMapping("/fileUpLoad1")
    public String fileUpLoad1(HttpServletRequest request) throws Exception {
        System.out.println("传统文件上传！");

        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断目录是否存在，不存在则创建
        File file = new File(path);
        System.out.println(file);
        if (!file.exists()) {
            System.out.println("目录不存在");
            file.mkdirs();
        } else {
            System.out.println("目录已存在");
        }
        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            //判断item对象是否是上传文件项
            if (item.isFormField()) {
                //普通表单项
            } else {
                //上传文件项
                //获取到文件名称
                String fieldName = item.getName();
                //将文件名设置唯一，避免上传相同文件时覆盖
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fieldName = uuid + "_" + fieldName;
                //完成文件上传
                item.write(new File(path, fieldName));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    @RequestMapping("/fileUpLoad2")
    public String fileUpLoad2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("SpringMVC文件上传！");
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断目录是否存在，不存在则创建
        File file = new File(path);
        System.out.println(file);
        if (!file.exists()) {
            System.out.println("目录不存在");
            file.mkdirs();
        } else {
            System.out.println("目录已存在");
        }
        String filename = upload.getOriginalFilename();
        //将文件名设置唯一，避免上传相同文件时覆盖
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //完成文件上传
        upload.transferTo(new File(path,filename));
        return "success";
    }
    @RequestMapping("/fileUpLoad3")
    public String fileUpLoad3( MultipartFile upload) throws Exception{

        //定义上传文件服务器路径
        String path = "http://localhost:9090/fileuploadserver/uploads";
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        //将文件名设置唯一，避免上传相同文件时覆盖
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //创建客户端对象
        Client client = Client.create();
        //和图片服务器连接
        WebResource webResource = client.resource(path + "/" + filename);
        //上传文件
        webResource.put(upload.getBytes());

        return "success";
    }
}

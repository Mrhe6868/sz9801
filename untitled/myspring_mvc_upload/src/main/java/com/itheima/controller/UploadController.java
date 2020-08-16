package com.itheima.controller;


import com.itheima.UploadUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("test")
public class UploadController {
    /**
     * 文件
     * @param multipartFile
     * 描述 域对象
     * @param desc
     * @return
     */
    @RequestMapping("upload")
    public String upload(MultipartFile multipartFile, String desc, HttpSession session){
        System.out.println("收到了请求吧");
        /*1,服务器要做的事 是准备文件夹
        (通过制定方法获取抽象路径  通过路径创建文件对象)
        接受文件 存储文件
        *
        * */
        System.out.println("图片的描述是");
        String realPath = session.getServletContext().getRealPath("/file" + UploadUtils.getDir());
        //获取文件对象
        File file = new File(realPath);
        if (!file.exists()) {
           file.mkdirs();
        }
        //获取浏览器传过来的文件
        String filename = multipartFile.getOriginalFilename();
        //通过别的方法修改文件名
        String uuidName = UploadUtils.getUUIDName(filename);
        //存储
        try {
            multipartFile.transferTo(new File(uuidName));
            System.out.println("存储成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("存储失败");
        }

        return "success";
    }

}

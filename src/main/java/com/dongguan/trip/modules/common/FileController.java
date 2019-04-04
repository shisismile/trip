package com.dongguan.trip.modules.common;

import com.dongguan.trip.common.utils.R;
import com.dongguan.trip.modules.buz.entity.AdvertiseEntity;
import com.dongguan.trip.modules.buz.service.AdvertiseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


@Controller
@RequestMapping("file")
@Slf4j
public class FileController {
    @Resource
    private AdvertiseService advertiseService;

    @Value("${upload.filepath}")
    private String filePath;

    /**
     * 上传图片的视图
     * @return
     */
    @GetMapping("upload.html")
    public String toUpload() {
        return "upload";
    }

    /**
     * 上传文件
     * @param file
     * @param fileName
     * @return
     */
    @RequestMapping("doUpload.html")
    public @ResponseBody
    R upload(@RequestParam("file") MultipartFile file, @RequestParam("file_name") String fileName) {
        try {
            String filename = file.getOriginalFilename();
            String subfix = filename.substring(filename.lastIndexOf(".") + 1);
            String path = filePath + File.separator + fileName + "." + subfix;
            File newFile = new File(path);
            file.transferTo(newFile);
            return R.ok(new HashMap<String, Object>() {{
                put("filepath", path);
            }});
        } catch (IOException e) {
            return R.error();
        }
    }

    /**
     * 列举出所有的文件
     * @return
     */
    @RequestMapping("list.html")
    @ResponseBody
    public R list() {
        File file = new File(filePath);
        String[] list = file.list();
        return R.ok(new HashMap<String, Object>() {{
            put("fileList", list);
        }});
    }

    /**
     * 下载文件
     * @param request
     * @param filename
     * @return
     */
    @RequestMapping("download.html")
    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename) {
        try {
            File file = new File(filePath, filename);
            HttpHeaders headers = new HttpHeaders();//http头信息
            String downloadFileName = new String(filename.getBytes("UTF-8"), "UTF-8");//设置编码
            headers.setContentDispositionFormData("attachment", downloadFileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return null;
        } catch (IOException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    /**
     * 显示图片
     * @param request
     * @param response
     * @param fileName
     */
    @RequestMapping("image.html")
    public void getFileWebPath(HttpServletRequest request, HttpServletResponse response,@RequestParam("file_name") String fileName){
        if(fileName.endsWith(".jpg")||fileName.endsWith(".gif")||fileName.endsWith(".png")){
            File file=new File(filePath,fileName);
            try {
                FileInputStream inputStream = new FileInputStream(file);
                int i = inputStream.available();
                //byte数组用于存放图片字节数据
                byte[] buff = new byte[i];
                inputStream.read(buff);
                //记得关闭输入流
                inputStream.close();
                //设置发送到客户端的响应内容类型
                response.setContentType("image/png");
                OutputStream out = new BufferedOutputStream(response.getOutputStream());
                out.write(buff);
                out.flush();
                //关闭响应输出流
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}

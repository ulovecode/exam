package com.ulovecode.modules.controller;

import com.ulovecode.common.utils.R;
import com.ulovecode.config.PhotoConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/fileupload")
@Slf4j
public class FileUpLoadContoller {

    @Resource
    PhotoConfig photoConfig;

    @RequestMapping(value = "/img")
    public R upload(Optional<MultipartFile> file) {
        if (file.isPresent()) {
            MultipartFile multipartFile = file.get();
            String originalFilename = multipartFile.getOriginalFilename();
            String path = photoConfig.getFullPath() + originalFilename;
            File filepath = new File(path);
            try {
                multipartFile.transferTo(filepath);
            } catch (IOException e) {
                e.printStackTrace();
                return R.error("上传文件出错误了");
            }
            return R.ok("file", photoConfig.getAccessPath() + originalFilename);
        }
        return R.error("空文件,无法上传");
    }


//    @RequestMapping(value = "/batch", method = RequestMethod.POST)
//    public  R batchUpload(HttpServletRequest request) {
//        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
//        MultipartFile file = null;
//        BufferedOutputStream stream = null;
//        String path ;
//        for (int i = 0; i < files.size(); ++i) {
//            file = files.get(i);
//            if (!file.isEmpty()) {
//                try {
//                    byte[] bytes = file.getBytes();
//                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
//                    stream.write(bytes);
//                    stream.close();
//                } catch (Exception e) {
//                    stream = null;
//                    return "You failed to upload " + i + " => " + e.getMessage();
//                }
//            } else {
//                return "You failed to upload " + i + " because the file was empty.";
//            }
//        }
//        return "upload successful";
//    }
}

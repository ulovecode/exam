package com.ulovecode.modules.student.controller;

import com.ulovecode.common.utils.R;
import com.ulovecode.config.FileConfig;
import com.ulovecode.config.PhotoConfig;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fileupload")
@Slf4j
@Api("上传图片接口")
@ApiResponses({@ApiResponse(code = 0, message = "正常码"), @ApiResponse(code = 500, message = "服务器处理错误")})
public class FileUpLoadController {

    @Resource
    private PhotoConfig photoConfig;
//    @Resource
//    private FileConfig fileConfig;

    @ApiOperation("单个图片上传接口")
    @PostMapping(value = "/img",consumes = "multipart/*",headers = "content-type="+MediaType.MULTIPART_FORM_DATA_VALUE)
    public R upload(@RequestParam("file") @ApiParam(value = "上传的文件",required = true) MultipartFile multipartFile) {
        if (!multipartFile.isEmpty()) {
            String originalFilename = multipartFile.getOriginalFilename();
            String path = photoConfig.getFullPath() + originalFilename;
            File MultipartFilepath = new File(path);
            try {
                multipartFile.transferTo(MultipartFilepath);
            } catch (IOException e) {
                e.printStackTrace();
                return R.error("上传文件出错误了");
            }
            return R.ok("file", photoConfig.getAccessPath() + originalFilename);
        }
        return R.error("空文件,无法上传");
    }


//    @RequestMapping(value = "/batch", method = RequestMethod.POST)
//    public R batchUpload(HttpServletRequest request) {
//        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
//        MultipartFile file = null;
//        BufferedOutputStream stream = null;
//        String path;
//        for (int i = 0; i < files.size(); ++i) {
//            file = files.get(i);
//            if (!file.isEmpty()) {
//                try {
//                    byte[] bytes = file.getBytes();
//                    stream = new BufferedOutputStream(new FileOutputStream(new File(fileConfig.getFullPath()+file.getOriginalFilename())));
//                    stream.write(bytes);
//                    stream.close();
//                } catch (Exception e) {
//                    stream = null;
//
//                    return   R.error("You failed to upload " + i + " => " + e.getMessage());
//                }
//            } else {
//                return   R.error("You failed to upload " + i + " because the file was empty.");
//            }
//        }
//        return R.ok("upload successful");
//    }
}

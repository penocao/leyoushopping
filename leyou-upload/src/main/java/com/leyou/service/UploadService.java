package com.leyou.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.web.UploadController;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

/**
 * author:  niceyoo
 * blog:    https://cnblogs.com/niceyoo
 * desc:
 */
@Service
public class UploadService {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    /**
     * 支持的文件类型
     */
    private static final List<String> suffixes = Arrays.asList("image/png", "image/jpeg");

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    /**
     * 上传
     * @param file
     * @return
     */
    public String upload(MultipartFile file){

        try{
            String originalFilename = file.getOriginalFilename();
            // 1、图片信息校验
            // 1)校验文件类型
            String type = file.getContentType();
            if (!suffixes.contains(type)) {
                logger.info("上传失败，文件类型不匹配：{}", type);
                return null;
            }
            // 2)校验图片内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null) {
                logger.info("上传失败，文件内容不符合要求");
                return null;
            }
            // 2、保存图片
            // 2.1、生成保存目录
//            File dir = new File("D:\\heima\\image");
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
            // 2.2、保存图片
            String ext = StringUtils.substringAfter(originalFilename, ".");
            StorePath storePath = this.fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), ext, null);
            // 2.3、拼接图片地址
            return "http://image.leyou.com/" + storePath.getFullPath();

        } catch (Exception e) {
            return null;
        }
    }

}

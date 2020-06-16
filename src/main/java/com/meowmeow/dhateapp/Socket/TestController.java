package com.meowmeow.dhateapp.Socket;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@RestController
@CrossOrigin("*")
public class TestController {
    public ByteBuffer store;
    @GetMapping(value = "/testing123",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] test() throws IOException {
        /*
        ByteArrayInputStream bis = new ByteArrayInputStream(store.array());
        BufferedImage bImage2 = ImageIO.read(bis);
        ImageIO.write(bImage2, "jpg", new File("/Users/hexo/Desktop/Test/output.jpg") );
        */
        return store.array();
    }
}

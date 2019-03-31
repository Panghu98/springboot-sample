package com.example.demo.service;

import java.io.File;
import java.util.List;

/**
 * @author panghu
 * @Title: MailService
 * @ProjectName demo
 * @Description: TODO
 * @date 19-2-17 下午10:20
 */
public interface MailService {
    /**
     * 测试
     *
     * @param to
     * @param title
     * @param content
     */
    void sendSimpleMail(String to, String title, String content);

    /**
     * @param to
     * @param title
     * @param content
     * @param fileList
     */
    public void sendAttachmentsMail(String to, String title, String content, List<File> fileList);
}

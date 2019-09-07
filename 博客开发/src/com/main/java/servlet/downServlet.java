package com.main.java.servlet;

import com.main.java.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 下载pdf的servlet，
 *      实现的步骤 ：
 *           1.发送过来的请求会携带文件名的参数，获取请求参数
 *           2.使用字节输入流加载文件到内存
 *           3.设置response的响应头，之后点击文件以以附件形式打开，会提示下载
 *           4.将输入流的数据写到输出流中
 */
@WebServlet("/DownServlet")
public class downServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         *  1.获取请求参数，文件的名称
         */
        String filename = request.getParameter("filename");

        /**
         *  2.使用字节输入流加载文件进内存
         */
        //找到文件的服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //用字节流关联，读进内存
        FileInputStream fis = new FileInputStream(realPath);

        /**
         * 3.设置response的响应头
         */
        //设置响应头类型 content-type
        //根据文件的名称获取文件的mime类型
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        //3.2设置打开的方式，以附件形式打开
        String agent = request.getHeader("user-agent");
        //用工具类获取文件的名字，并显示在下载提示框中
        filename = DownLoadUtils.getFileName(agent,filename);
        response.setHeader("content-disposition","attachment;filename="+filename);

        /**
         * 4.将输入流数据写到输出流中
         */
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8 * 5];
        int len;
        while((len = fis.read(buff)) != -1){
            //没有读到文件的末尾
            //继续输出到末尾
            sos.write(buff,0,len);
        }

        //输入流关掉，释放资源
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

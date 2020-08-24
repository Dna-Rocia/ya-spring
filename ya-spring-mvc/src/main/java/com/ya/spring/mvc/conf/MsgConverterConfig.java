package com.ya.spring.mvc.conf;

import com.ya.spring.mvc.model.Demo;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @Description  消息转换器
 * @Author ROCIA
 * @Date 2020/8/24
 */
public class MsgConverterConfig extends AbstractHttpMessageConverter {

    public MsgConverterConfig() {
        super(new MediaType("application","x-ya", Charset.defaultCharset())); //自定义了一个媒体类型
    }

    /**
     * HttpMessageConverter只处理Demo对象
     *
     */
    @Override
    protected boolean supports(Class clazz) {
        boolean flag = false;
        flag = Demo.class.isAssignableFrom(clazz);

        return flag;
    }


    /**
     *  处理请求的数据。代码表明处理是由“-”隔开的数据，并转化为Object
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(inputMessage.getBody(),Charset.defaultCharset());
        String[] arr = temp.split("-");
        return new Demo(new Long(arr[0]),arr[1]);
    }

    /**
     * 处理如何输出数据到response中
     * @param o
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello:"+((Demo)o).getId()+"-"+((Demo)o).getName();
        outputMessage.getBody().write(out.getBytes());
    }



}

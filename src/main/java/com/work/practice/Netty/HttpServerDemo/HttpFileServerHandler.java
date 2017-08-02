package work.wk.Netty.HttpServerDemo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelProgressiveFuture;
import io.netty.channel.ChannelProgressiveFutureListener;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpMethod.CONNECT;
import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.*;
import static io.netty.handler.codec.http.HttpUtil.isKeepAlive;
import static io.netty.handler.codec.http.HttpUtil.setContentLength;

/**
 * Created by wangkai43 on 2017/7/16.
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<HttpRequest> {

    private final String url ;
    public HttpFileServerHandler(String url){
        this.url = url;

    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest) throws Exception {
   /*     if(!httpRequest.getDecoderResult().isSuccess()){
            sendError(channelHandlerContext,BAD_REQUEST);
            return;
        }
        if(httpRequest.getMethod()!= GET){
            sendError(channelHandlerContext,METHOD_NOT_ALLOWED);
            return;
        }
        final String uri = httpRequest.getUri();
        final String path = sanitilizeUrl(uri);
        if(path == null){
            sendError(channelHandlerContext,FORBIDDEN);
            return;
        }
        File file = new File(path);
        if(file.isHidden() || !file.exists()){
            sendErroe(channelHandlerContext,NOT_FOUND);
            return;
        }
        if(!file.isFile()){
            senError(ctx,FORBIDDEN);
            return;
        }
        RandomAccessFile  randomAccessFile = null;
        try{
            randomAccessFile = new RandomAccessFile(file,"r");//以只读方式打开文件

        }catch (FileNotFoundException e){
            sendError(channelHandlerContext ,NOT_FOUND);
            return;
        }

        long filelength = randomAccessFile.length();

        HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1,OK);
        setContentLength(response,filelength);
        setContentTypeHeader(response,file);
        if(isKeepAlive(httpRequest)){
            response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
        }
        sendFileFuture.addListener(new ChannelProgressiveFutureListener(){

            @Override
            public void operationComplete(ChannelProgressiveFuture channelProgressiveFuture) throws Exception {

            }

            @Override
            public void operationProgressed(ChannelProgressiveFuture channelProgressiveFuture, long l, long l1) throws Exception {

            }
        });*/
    }
}

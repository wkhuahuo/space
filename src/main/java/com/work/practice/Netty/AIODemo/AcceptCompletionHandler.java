package work.wk.Netty.AIODemo;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by wangkai43 on 2017/7/9.
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServiceHandler> {

    @Override
    public void completed(AsynchronousSocketChannel result, AsyncTimeServiceHandler attachment) {
        attachment.assc.accept(attachment,this);
        ByteBuffer byteb = ByteBuffer.allocate(1024);
        result.read(byteb,byteb,new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServiceHandler attachment) {
        exc.printStackTrace();
        attachment.cdl.countDown();
    }
}

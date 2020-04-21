package android.stack.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 */
public class Server {

    /**
     * 服务器端入口函数
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            //I. 创建服务器套接字, 并监听端口

            //1. 创建服务器套接字 , 只需要指定端口即可 , 不需要指定 IP 地址
            //      其 IP 地址就是本机的 IP 地址 , 如果机器有多个 IP 地址
            //      如果没有指定 IP 地址 , 那么会监听所有的 IP 地址的指定端口号
            ServerSocket serverSocket = new ServerSocket(8000);

            //2. 获取服务器端 IP 地址
            InetAddress inetAddress = serverSocket.getInetAddress();

            //3. 获取服务器端口号
            int localPort = serverSocket.getLocalPort();

            System.out.println("服务器开启\nIP 地址 : " + inetAddress + " , 端口号 : " + localPort);


            //II. 等待客户端连接, 注意此处是无限循环连接

            while (true) {
                //1. 收到一个客户端连接请求 , 获取 客户端 Socket 连接
                Socket clientSocket = serverSocket.accept();

                //2. 将 Socket 连接传入 ClientHandler 线程 , 异步处理与客户端交互操作
                ClientHandler clientHandler = new ClientHandler(clientSocket);

                //3. 启动 与客户端 Socket 交互处理 异步线程
                clientHandler.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 异步线程 , 处理单个客户端连接
     * 如果多个客户端连接 , 就需要创建多个该类, 同时处理多个客户端连接
     */
    public static class ClientHandler extends Thread {

        //1. 客户端 Socket 连接
        private Socket clientSocket;

        //2. 循环控制变量
        private boolean loopFlag = true;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            super.run();

            //I. 获取客户端相关信息

            //1. 获取客户端的 IP 地址
            InetAddress inetAddress = clientSocket.getInetAddress();

            //2. 获取客户端的端口号
            int port = clientSocket.getPort();

            //3. 打印客户端的信息
            System.out.println("客户端信息 : \nIP 地址 : " + inetAddress + " , 端口号 : " + port);


            try {

                //II. 创建与客户端交互的输入输出流

                //1. 获取客户端 Socket 输出流 , 用于向客户端发送数据
                OutputStream os = clientSocket.getOutputStream();

                //2. 创建打印流 , 用于向客户端输出数据
                PrintStream ps = new PrintStream(os);

                //3. 获取客户端 Socket 输入流 , 用于接收客户端数据
                InputStream is = clientSocket.getInputStream();

                //4. 获取客户端的字符输入流 , 该输入流可以阻塞等待客户端输入
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                //III. 循环处理与客户端交互的信息

                while (loopFlag) {

                    //1. 等待客户端输入
                    String string = br.readLine();

                    //2. 处理客户端输入
                    if ("quit".equals(string)) {
                        //如果客户端发送退出, 那么停止循环, 将该信息在送回客户端
                        loopFlag = false;
                        //将信息发送到客户端
                        ps.println("quit");
                    } else {
                        //将信息打印到控制台
                        System.out.println(string);
                        //将发送成功信息返回给客户端
                        ps.println("我是服务端，已接收发送信息：" + string + ", 大小 " + string.length() + " 字节");
                    }

                }

                //IV. 关闭相关资源
                ps.close();
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    //如果出现异常 , 将该 Socket 关闭
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("客户端退出 : \nIP 地址 : " + inetAddress + " , 端口号 : " + port);

        }
    }

}


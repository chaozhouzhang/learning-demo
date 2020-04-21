package android.stack.socket;
import java.io.*;
import java.net.*;

/**
 * 客户端
 */
public class Client {

    /**
     * 客户端入口函数
     * @param args
     */
    public static void main(String[] args){

        try {
            //I. 连接

            //1. 创建 Socket 对象
            Socket socket = new Socket();
            //2. 设置 Socket 的超时时间
            socket.setSoTimeout(5000);

            //3. 创建连接的端点 , 该端点包括 IP 地址和端口号
            InetSocketAddress inetSocketAddress =
                    new InetSocketAddress(
                            Inet4Address.getLocalHost(),   //本机IP地址
                            8000                      //端口号
                    );

            //4.. 连接服务器端点 , 并设置超时时间
            socket.connect(inetSocketAddress, 5000);

            //5. 如果连接成功会继续执行下面的操作, 如果失败会根据失败情况抛出异常


            //II. 获取 Socket 连接两个端点的属性, IP 地址和端口号

            //1. 获取服务器 IP 地址
            InetAddress serverAddress = socket.getInetAddress();
            //2. 获取服务器端口号
            int serverPort = socket.getPort();

            //3. 获取客户端 IP 地址
            InetAddress clientAddress = socket.getLocalAddress();
            //4. 获取客户端端口号
            int clientPort = socket.getLocalPort();


            System.out.println("服务器连接成功\n服务器地址 : " + serverAddress +
                    " , 服务器端口号 : " + serverAddress +
                    "\n客户端地址 : " + clientAddress + " , 客户端端口号 : " + clientPort);

            //向服务器端发送数据
            sendToServer(socket);

            //III. 关闭 Socket 连接
            socket.close();
            System.out.println("客户端 Socket 连接关闭");

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //客户端可能挂了 , 需要重启
        }
    }

    public static void sendToServer(Socket socket){

        try {

            //I. 获取用户控制台输入信息

            //1. 获取控制台输入流
            InputStream is = System.in;
            //2. 该输入流会阻塞 , 等待用户控制台输入
            BufferedReader br = new BufferedReader(new InputStreamReader(is));


            //II. 将用户输入信息上传到服务器

            //4. 获取客户端的输出流 , 用于向服务器端写出数据
            OutputStream os = socket.getOutputStream();
            //5. 创建打印流 , 用于向服务器端写出字符
            PrintStream ps = new PrintStream(os);



            //III. 从服务器获取信息 , 这里循环读取数据, 接收到 服务器端的 quit 字符串才退出

            //1. 获取服务器端输入流
            InputStream isFromServer = socket.getInputStream();
            //2. 将输入流转为 BufferedReader
            BufferedReader brFromServer = new BufferedReader(new InputStreamReader(isFromServer));

            //3. 循环控制变量 , 退出时设置为 false
            boolean isReadFromServer = true;
            while (isReadFromServer){

                //4. 阻塞命令行 , 等待用户输入一行数据, 并存入 string 对象中
                String string = br.readLine();
                //5. 通过打印流 , 将该字符串传输给服务器端
                ps.println(string);

                //6. 阻塞控制台 , 从服务器读取一行数据
                String stringFromServer = brFromServer.readLine();
                //7. 根据服务器返回的数据进行不同操作
                if("quit".equals(stringFromServer)){
                    //停止循环
                    isReadFromServer = false;
                }else{
                    System.out.println(stringFromServer);
                }
            }

            //IV. 释放资源
            br.close();
            ps.close();
            brFromServer.close();



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


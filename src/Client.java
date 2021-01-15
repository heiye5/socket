import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            //创建一个流套接字并将其连接到指定主机上的指定端口号
            Socket socket=new Socket("localhost",8888);

            //读取服务器端数据
            InputStream is=socket.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader in=new BufferedReader(isr);

            String serverMessage=in.readLine();
            System.out.println("服务器端说："+serverMessage);
            Scanner sc = new Scanner(System.in);
            while(true) {
                //向服务器端发送数据
                System.out.println("请输入你要发送的消息：");
                String message = sc.next();
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                PrintWriter out = new PrintWriter(osw);
                out.println(message);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

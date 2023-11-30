package git.JavaPyHealthSerch;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class home {
    public static void main(String[] args) {
        Scanner x=new Scanner(System.in);
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "git\\JavaPyHealthSerch\\getdata.py");
            Process process = pb.start();
            
            // 获取进程的输入流和输出流
            InputStream inputStream = process.getInputStream();
            OutputStream outputStream = process.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));

            System.out.println("请输入序号:");
            String setin=x.next();

            // 向Python程序发送输入
            writer.println(setin);
            writer.flush();
            
            // 读取输出
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            // 等待进程执行完成
            int exitCode = process.waitFor();
            System.out.println("Python程序执行完成,退出码:" + exitCode);

            x.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

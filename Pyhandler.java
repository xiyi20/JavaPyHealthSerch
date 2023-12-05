import java.io.*;

class Pyhandler {
    public Pyhandler(){}
    public String getdata(String sendin){
        try {
            ProcessBuilder pb;
            int code=MainPro.pycode;
            if (code==0) pb=new ProcessBuilder("python","git\\JavaPyHealthSerch\\getdata.py");
            else if(code==1) pb=new ProcessBuilder("python","getdata.py");
            else pb=new ProcessBuilder("python","E:\\workContact\\JavaPyHealthSerch\\getdata.py");
            Process process = pb.start();
            // 获取进程的输入流和输出流
            InputStream inputStream = process.getInputStream();
            OutputStream outputStream = process.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"gbk"));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));
 
            writer.println(sendin);
            writer.flush();
            
            // 读取python的输出
            String line;String res="";
            int exitCode = process.waitFor();
            int flag=1;
            while ((line = reader.readLine())!=null) {
                if(flag%2==0)res+=line+"\n\n";
                else res+=line+"\n";
                flag++;
            }
            if (res.isEmpty()) res="没有符合条件的结果";

            if (exitCode!=0)System.out.println("Python程序执行异常,退出码:"+exitCode);
            return res;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "好像有问题";
    }
}

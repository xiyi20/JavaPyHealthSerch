java和python的梦幻联动
=
介绍：一个基于javaGui和python爬虫的病情自主诊断程序  
核心代码：  
```
ProcessBuilder pb = new ProcessBuilder("python", "git\\JavaPyHealthSerch\\getdata.py");
Process process = pb.start();
// 获取进程的输入流和输出流
InputStream inputStream = process.getInputStream();
OutputStream outputStream = process.getOutputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"gbk"));
PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));
```

package com.util;
import java.io.File;  
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileInputStream;  
import java.io.FileWriter;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.util.Dao;
  
public class cin_txt {  
	public static void main(String args[]) {  
		
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
  
            //读入TXT文件  
            String pathname = "beijing.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径  
            File filename = new File(pathname); // 要读取以上路径的input.txt文件  
            InputStreamReader reader = new InputStreamReader(  
                    new FileInputStream(filename)); // 建立一个输入流对象reader  
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            String line = "";  
            line = br.readLine();  
            while (line != null) {  
                line = br.readLine(); // 一次读入一行数据  
                if(line != null) {
                //String regEx = "(?=[\\s\\S]*?)(\\[smiley=[0-9]+\\])(?=[\\s\\S]*?)";
        		//String regEx ="data-value='([0-9]+)'([\\s\\S]*?)title='([\\u4e00-\\u9fa5_a-zA-Z0-9]+)'";
                String regEx ="data-value='([0-9]+)'([\\s\\S]*?)title='([\\S]+)'";	
        		//String str = "adfasdf[smiley=4]kk [smiley=1]   mko[smiley=2],sdfaasdfa fd";
        		//String str = "<div data-dopost='T' data-type='brand' data-value='1085' id='brand-1085' data-brandtype='0' title='Q加' class='optionList-item  '>Q加</div>";
        		Pattern pat = Pattern.compile(regEx);
        		Matcher mat = pat.matcher(line);
        		while(mat.find()){
        			Dao.add(mat.group(1),mat.group(3));
        		}
                }
            }  
            br.close();
            System.out.println("插入成功");
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  
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
		
		try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw  
  
            //����TXT�ļ�  
            String pathname = "beijing.txt"; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��  
            File filename = new File(pathname); // Ҫ��ȡ����·����input.txt�ļ�  
            InputStreamReader reader = new InputStreamReader(  
                    new FileInputStream(filename)); // ����һ������������reader  
            BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
            String line = "";  
            line = br.readLine();  
            while (line != null) {  
                line = br.readLine(); // һ�ζ���һ������  
                if(line != null) {
                //String regEx = "(?=[\\s\\S]*?)(\\[smiley=[0-9]+\\])(?=[\\s\\S]*?)";
        		//String regEx ="data-value='([0-9]+)'([\\s\\S]*?)title='([\\u4e00-\\u9fa5_a-zA-Z0-9]+)'";
                String regEx ="data-value='([0-9]+)'([\\s\\S]*?)title='([\\S]+)'";	
        		//String str = "adfasdf[smiley=4]kk [smiley=1]   mko[smiley=2],sdfaasdfa fd";
        		//String str = "<div data-dopost='T' data-type='brand' data-value='1085' id='brand-1085' data-brandtype='0' title='Q��' class='optionList-item  '>Q��</div>";
        		Pattern pat = Pattern.compile(regEx);
        		Matcher mat = pat.matcher(line);
        		while(mat.find()){
        			Dao.add(mat.group(1),mat.group(3));
        		}
                }
            }  
            br.close();
            System.out.println("����ɹ�");
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  
package Movie.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * @author User
 * 영화 리스트 클래스
 *
 */
public class MovieSelect extends JFrame{

        public MovieSelect() throws ParseException, Exception{
            

            setTitle("영화 리스트");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 500);
            setVisible(true);
            
            this.setLayout(new GridLayout(10,1));              

           
            JSONParser jsonparser = new JSONParser();
            JSONObject jsonobject = (JSONObject)jsonparser.parse(readUrl());
            JSONObject json =  (JSONObject) jsonobject.get("boxOfficeResult");
            JSONArray array = (JSONArray)json.get("dailyBoxOfficeList");

                for (int i = 0 ; i < array.size(); i++) {
                    JSONObject entity = (JSONObject)array.get(i);
                    String movieNm = (String) entity.get("movieNm");
                    add(new JButton(i+1 + " 위 : " + movieNm));
                }          
                
                setVisible(true);
                
                new JButton().addActionListener(new ActionListener() { // 날짜 선택으로
     				@Override
     				public void actionPerformed(ActionEvent A) {
     						new DateSelect ();
     				}
     		});
                
        }
                
       /**
        * 
        * @return
        * @throws Exception
        */
       private static String readUrl() throws Exception {
           BufferedReader reader = null;
           try {
               URL url = new URL(
                       "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/"
                       + "searchDailyBoxOfficeList.json"
                       + "?key=ba3e3e72c5f3f9412f8a0ee248c2514e"
                       + "&targetDt=20201116");
               reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
               StringBuffer buffer = new StringBuffer();
               String str;

               while ((str = reader.readLine()) != null) {
               buffer.append(str);
               }

               return buffer.toString();
               } finally {
               if (reader != null)
               reader.close();
               }
       }
       
       
public static void main(String[] args){

        try {
			new MovieSelect();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}


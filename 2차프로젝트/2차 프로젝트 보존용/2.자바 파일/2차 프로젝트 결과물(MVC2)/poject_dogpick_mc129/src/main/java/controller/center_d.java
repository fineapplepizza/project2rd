package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import model.centerDAO;
import model.centerDTO;

@WebServlet("/center_d")
public class center_d extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JsonArray jarray = new JsonArray(); //json 媛앹껜瑜� �떞湲곗쐞�븳 Jarray 媛앹껜 �깮�꽦
		JsonObject json = new JsonObject(); // json 媛앹껜濡� �뜲�씠�꽣瑜� 諛쏄린�쐞�빐 json 媛앹껜 �깮�꽦
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out= response.getWriter(); //�븘�썐 媛앹껜!! �궡蹂대궪 媛앹껜瑜� 諛쏆븘�삤湲� �쟾�뿉!! �씤肄붾뵫�쓣 �빐以섏빞 �궡蹂대궪 媛앹껜�뿉 �쟻�슜�씠 �릺�꽌 �씤肄붾뵫�씠 �븞源⑥쭊�떎!!!!!
		
		
		centerDAO c_dao = new centerDAO(); //DB�� �뿰寃고빐�꽌 DB �뿉�엳�뒗 媛믪쓣 媛��졇�삱 DAO媛앹껜 �깮�꽦
		ArrayList<centerDTO> center_map = new ArrayList<centerDTO>();
		center_map = c_dao.getCenter_map(); //dao 瑜� �넻�빐 DB�뿉 �엳�뒗 媛믪쓣 ArrayList �쑝濡� ���옣
		
		//ArrayList�뿉 �엳�뒗 媛믪쓣 �븯�굹�븯�굹 �떞�븘以� 蹂��닔 �깮�꽦
		String C_Do=null; 
		String C_SiGoon=null; 
		String C_Name=null; 
		String C_Tel=null; 
		String C_Addr=null; 
		
		for(int i=0; i<center_map.size();i++) {
			
			//ArrayList�뿉 �엳�뒗 媛믪쓣 �븯�굹�븯�굹 �떞�븘以�
			C_Do = center_map.get(i).getC_Do();
			C_SiGoon = center_map.get(i).getC_SiGoon();
			C_Name = center_map.get(i).getC_Name();
			C_Tel = center_map.get(i).getC_Tel();
			C_Addr= center_map.get(i).getC_Addr();
			
			//�쐞�뿉�꽌 �떞�븘以� 蹂��닔瑜� 媛곴컖 �떎瑜� �궎 媛믪쑝濡� json 媛앹껜�뿉 ���옣
			json.addProperty("C_do", C_Do);
			json.addProperty("C_SiGoon", C_SiGoon);
			json.addProperty("C_Name", C_Name);
			json.addProperty("C_Tel", C_Tel);
			json.addProperty("C_Addr", C_Addr);
			
			//媛곴린 �떎瑜� �궎媛믪쑝濡� ���옣�맂 媛앹껜瑜� Jarray �뿉 ���옣
			jarray.add(json);
			
			//�깉濡쒖슫 媛믪쓣 �떞�븘二쇨린 �쐞�빐 媛앹껜 珥덇린�솕
			json= new JsonObject();
		}
		
		System.out.println(jarray);
		out.print(jarray);
	}

}
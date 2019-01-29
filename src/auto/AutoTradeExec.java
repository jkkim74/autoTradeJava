package auto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AutoTradeExec
 */
@WebServlet(
		urlPatterns = { "/AutoTradeExec" }, 
		initParams = { 
				@WebInitParam(name = "fileName", value = "fileName", description = "fileName")
		})
public class AutoTradeExec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoTradeExec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String fileName = "cmd";//request.getParameter("fileName");
        System.out.println("fileName : " + fileName);
         
        if(fileName !=null && !fileName.isEmpty()){
              
            // 파라미터로 받은 이름을 조건으로 실행할 프로그램을 선택, 아무것도 입력하지 않을 경우 계산기가 실행 됨.
            String directory = "C://Windows//System32//calc.exe";
             
            if(fileName.equals("계산기")){
                directory = "C://Windows//System32//calc.exe";
            }else if(fileName.equals("메모장")){
                directory = "C://Windows//System32//notepad.exe";
            }else if(fileName.equals("그림판")){
                directory = "C://Windows//System32//mspaint.exe";
            }else if(fileName.equals("cmd")) {
            	directory = "C://Users//jkkim//Desktop//auto.bat";
            }else if(fileName.equals("autoTrade")) {
            	 directory = "D://ProgramData//python.exe";
            }
             
            // 실제로 파일을 실행하는 구간------------------------------------
            Runtime rt = Runtime.getRuntime();
            System.out.println("directory: " + directory);
            Process p;
             
            try {
                p = rt.exec(directory);
                p.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 실제로 파일을 실행하는 구간------------------------------------
             
        }
         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
              
            // �Ķ���ͷ� ���� �̸��� �������� ������ ���α׷��� ����, �ƹ��͵� �Է����� ���� ��� ���Ⱑ ���� ��.
            String directory = "C://Windows//System32//calc.exe";
             
            if(fileName.equals("����")){
                directory = "C://Windows//System32//calc.exe";
            }else if(fileName.equals("�޸���")){
                directory = "C://Windows//System32//notepad.exe";
            }else if(fileName.equals("�׸���")){
                directory = "C://Windows//System32//mspaint.exe";
            }else if(fileName.equals("cmd")) {
            	directory = "C://Users//jkkim//Desktop//auto.bat";
            }else if(fileName.equals("autoTrade")) {
            	 directory = "D://ProgramData//python.exe";
            }
             
            // ������ ������ �����ϴ� ����------------------------------------
            Runtime rt = Runtime.getRuntime();
            System.out.println("directory: " + directory);
            Process p;
             
            try {
                p = rt.exec(directory);
                p.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // ������ ������ �����ϴ� ����------------------------------------
             
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

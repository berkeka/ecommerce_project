package final_project.utl;

import javax.servlet.http.HttpSession;

public class SessionController {
	public static boolean sessionExists(HttpSession s) {
		if(s.getAttribute("user") == null) {
			return false;
		}
		return true;
	}
}

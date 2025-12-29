import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/start")
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("playerName");
        if (name == null || name.trim().isEmpty()) {
            name = "Mark Hoffman";
        }

        HttpSession session = req.getSession();
        session.setAttribute("playerName", name);
        session.setAttribute("gamesPlayed", 0);

        resp.sendRedirect(req.getContextPath() + "/game?step=start");
    }
}

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
        HttpSession session = req.getSession();

        if (name == null || name.trim().isEmpty() || !name.matches("^\\p{L}+([ -]\\p{L}+)*$")) {
            session.setAttribute("errorMessage", "Player name is invalid");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }

        session.setAttribute("playerName", name);
        session.setAttribute("gamesPlayed", 0);
        session.setAttribute("errorMessage", "");

        resp.sendRedirect(req.getContextPath() + "/game?step=start");
    }
}

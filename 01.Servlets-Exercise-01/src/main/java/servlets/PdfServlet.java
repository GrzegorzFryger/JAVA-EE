package servlets;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.ScheduleRepayments;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


@WebServlet("/download")
public class PdfServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        List<ScheduleRepayments> a = (List<ScheduleRepayments>) session.getAttribute("schedule");

        resp.setContentType("application/pdf");
        resp.setHeader("Content-Type", "application/x-www-form-urlencoded");
        resp.setHeader("Content-disposition", "attachment; filename='" +
                "harmongoram.pdf'");

        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            ServletOutputStream servletOutputStream = resp.getOutputStream();
            PdfWriter writer = PdfWriter.getInstance(document, servletOutputStream);
            document.open();
            document.add((new Paragraph("Hermongoram splaty kredytu")));
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(new float[]{3, 4, 4, 3, 4});

            table.addCell("Numer raty");
            table.addCell("Kwota kapitalu");
            table.addCell("Kwota odsetek");
            table.addCell("Stale opląty");
            table.addCell("Laczna rata ");


            for (ScheduleRepayments typ : a) {
                table.addCell((Integer.toString(typ.getInstalmentNumber())));
                table.addCell(Double.toString(typ.getAmountCapital()));
                table.addCell(Double.toString(typ.getAmountInterest()));
                table.addCell(Double.toString(typ.getFixedFees()));
                table.addCell(Double.toString(typ.getTotalAmountInstallmentl()));
            }
            out.writeTo(servletOutputStream);
            document.add(table);
            document.close();

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

}

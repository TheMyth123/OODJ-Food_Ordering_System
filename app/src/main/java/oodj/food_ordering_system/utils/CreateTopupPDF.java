package oodj.food_ordering_system.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;

import oodj.food_ordering_system.models.Credit;
import oodj.food_ordering_system.models.Customer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;

public class CreateTopupPDF {

    public static void createPDF(String creditID) {
        Credit credit = UserHandling.getTopUpByID(creditID);
        String requestDate = credit.getDate().toString();
        String amount = String.valueOf(credit.getAmount());

        Customer customer = UserHandling.getCustomerByID(credit.getCustomerID());
        String customerName = customer.getName();
        String customerID = customer.getID();
        String contactNumber = customer.getContactnumber();
        String email = customer.getEmail();
        String balance = String.valueOf(customer.getBalance());

        String finalAmount = String.valueOf(Double.parseDouble(balance) + Double.parseDouble(amount));
        String acceptedDate = LocalDate.now().toString();

        String filePath = "app/src/main/resources/topupPDF/" + creditID + ".pdf";
        Document document = new Document(PageSize.A4, 36, 36, 54, 54);
        
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            FontFactory.registerDirectories();

            Font logoFont = FontFactory.getFont("Comic Sans MS", 28, Font.BOLD, BaseColor.DARK_GRAY);
            Paragraph logoHeader = new Paragraph("Food Connect", logoFont);
            logoHeader.setAlignment(Element.ALIGN_CENTER);
            logoHeader.setSpacingAfter(5f);
            document.add(logoHeader);

            Font subtitleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.NORMAL, BaseColor.DARK_GRAY);
            Paragraph subtitle = new Paragraph("Official Top-Up Receipt", subtitleFont);
            subtitle.setAlignment(Element.ALIGN_CENTER);
            subtitle.setSpacingAfter(10f);
            document.add(subtitle);

            LineSeparator ls = new LineSeparator();
            ls.setLineColor(BaseColor.LIGHT_GRAY);
            document.add(new Chunk(ls));
            document.add(Chunk.NEWLINE);

            Font sectionHeaderFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
            Paragraph customerSection = new Paragraph("Customer Details", sectionHeaderFont);
            customerSection.setAlignment(Element.ALIGN_LEFT);
            customerSection.setSpacingBefore(10f);
            customerSection.setSpacingAfter(10f);
            document.add(customerSection);

            PdfPTable customerTable = new PdfPTable(2);
            customerTable.setWidthPercentage(100);
            customerTable.setSpacingBefore(10f);
            customerTable.setSpacingAfter(20f);
            customerTable.setWidths(new float[]{45, 55});

            Font tableHeaderFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
            Font tableContentFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.DARK_GRAY);

            addTableRow(customerTable, "Customer Name:", customerName, tableHeaderFont, tableContentFont);
            addTableRow(customerTable, "Customer ID:", customerID, tableHeaderFont, tableContentFont);
            addTableRow(customerTable, "Contact Number:", contactNumber, tableHeaderFont, tableContentFont);
            addTableRow(customerTable, "Email:", email, tableHeaderFont, tableContentFont);

            document.add(customerTable);

            Paragraph operationSection = new Paragraph("Operation Details", sectionHeaderFont);
            operationSection.setAlignment(Element.ALIGN_LEFT);
            operationSection.setSpacingBefore(10f);
            operationSection.setSpacingAfter(10f);
            document.add(operationSection);

            PdfPTable operationTable = new PdfPTable(2);
            operationTable.setWidthPercentage(100);
            operationTable.setSpacingBefore(10f);
            operationTable.setSpacingAfter(20f);
            operationTable.setWidths(new float[]{45, 55});

            addTableRow(operationTable, "Top-up Request Date:", requestDate, tableHeaderFont, tableContentFont);
            addTableRow(operationTable, "Top-up Request Accepted Date:", acceptedDate, tableHeaderFont, tableContentFont);
            addTableRow(operationTable, "Credit ID:", creditID, tableHeaderFont, tableContentFont);
            addTableRow(operationTable, "Initial Amount:", balance, tableHeaderFont, tableContentFont);
            addTableRow(operationTable, "Top-up Amount:", amount, tableHeaderFont, tableContentFont);
            addTableRow(operationTable, "Final Amount:", finalAmount, tableHeaderFont, tableContentFont);

            document.add(operationTable);

            document.add(new Chunk(ls));
            document.add(Chunk.NEWLINE);

            Font additionalInfoFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.DARK_GRAY);
            Paragraph additionalInfo = new Paragraph(
                "This is a computer-generated receipt and does not require a signature.\n" +
                "Please contact admin for any enquiries.",
                additionalInfoFont);
            additionalInfo.setAlignment(Element.ALIGN_CENTER);
            additionalInfo.setSpacingBefore(10f);
            additionalInfo.setSpacingAfter(10f);
            document.add(additionalInfo);

            Font footerFont = new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC, BaseColor.GRAY);
            Paragraph footer = new Paragraph("Thank you for using Food Connect!", footerFont);
            footer.setAlignment(Element.ALIGN_CENTER);
            footer.setSpacingBefore(10f);
            document.add(footer);

            addPageBorder(writer, document);

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void addTableRow(PdfPTable table, String headerText, String contentText, Font headerFont, Font contentFont) {
        PdfPCell headerCell = new PdfPCell(new Phrase(headerText, headerFont));
        headerCell.setBackgroundColor(BaseColor.DARK_GRAY);
        headerCell.setBorder(Rectangle.NO_BORDER);
        headerCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        headerCell.setPadding(8f);
        table.addCell(headerCell);

        PdfPCell contentCell = new PdfPCell(new Phrase(contentText, contentFont));
        contentCell.setBorder(Rectangle.NO_BORDER);
        contentCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        contentCell.setPadding(8f);
        table.addCell(contentCell);
    }

    private static void addPageBorder(PdfWriter writer, Document document) {
        PdfContentByte canvas = writer.getDirectContent();
        Rectangle rect = new Rectangle(document.getPageSize());
        rect.setLeft(document.leftMargin() / 2);
        rect.setRight(document.getPageSize().getWidth() - document.rightMargin() / 2);
        rect.setTop(document.getPageSize().getHeight() - document.topMargin() / 2);
        rect.setBottom(document.bottomMargin() / 2);
        rect.setBorder(Rectangle.BOX);
        rect.setBorderWidth(2);
        rect.setBorderColor(BaseColor.LIGHT_GRAY);
        canvas.rectangle(rect);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Export Demo ===");

        ExportRequest reqReport = new ExportRequest("Weekly Report", SampleData.longBody());
        Exporter pdf = new PdfExporter();
        Exporter csv = new CsvExporter();
        Exporter json = new JsonExporter();

        System.out.println("PDF: " + describe(pdf.export(reqReport)));
        System.out.println("CSV: " + describe(csv.export(reqReport)));
        System.out.println("JSON: " + describe(json.export(reqReport)));
    }

    private static String describe(ExportResult result) {
        if (!result.success) {
            return "ERROR: " + result.error;
        }
        return "OK bytes=" + result.bytes.length;
    }
}

public class ExportResult {
    public final String contentType;
    public final byte[] bytes;
    public final boolean success;
    public final String error;

    public ExportResult(String contentType, byte[] bytes) {
        this.contentType = contentType;
        this.bytes = bytes;
        this.success = true;
        this.error = null;
    }

    private ExportResult(String error) {
        this.contentType = null;
        this.bytes = new byte[0];
        this.success = false;
        this.error = error;
    }

    public static ExportResult failure(String error) {
        return new ExportResult(error);
    }
}

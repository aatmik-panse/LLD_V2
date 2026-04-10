public abstract class Exporter {


    public final ExportResult export(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("ExportRequest must not be null");
        }
        if (req.title == null) {
            throw new IllegalArgumentException("title must not be null");
        }

        ExportResult result = doExport(req);

        if (result == null) {
            throw new IllegalStateException("doExport must not return null");
        }
        return result;
    }

    protected abstract ExportResult doExport(ExportRequest req);
}

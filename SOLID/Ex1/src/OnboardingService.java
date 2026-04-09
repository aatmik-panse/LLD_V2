import java.util.*;

public class OnboardingService {
    private final FakeDb db;

    // This is Dependency Injection , helps in switching the database easily without changing the code. + in testing also 
    public OnboardingService(FakeDb db) { this.db = db; }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        // Parsing the raw input
        ParsingService parsingService = new ParsingService();
        Map<String,String> kv = parsingService.parse(raw);


        // Validation the input
        ValadationService valadationService = new ValadationService();
        List<String> errors = valadationService.validate(kv);


        // Generating the ID

        IdGenerationService idGenerationService = new IdGenerationService();
        String id = idGenerationService.generateId(db.count());


        StudentRecord sr = new StudentRecord(id,
                                kv.get("name"), 
                                kv.get("email"),
                                kv.get("phone"),
                                kv.get("program"));
        // Saving the record to the database
        
        SaveStudentData ssd = new SaveStudentData(db);
        ssd.save(sr);
        // Printing the confirmation

        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + db.count());
        System.out.println("CONFIRMATION:");
        System.out.println(sr);
    }
}



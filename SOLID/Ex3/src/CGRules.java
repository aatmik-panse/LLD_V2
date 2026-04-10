
public class CGRules implements IEligibilityRule{
    @Override
    public String check(StudentProfile student) {
        if (student.cgr < 8.0) {
            return "NOT_ELIGIBLE";
        }
        return "ELIGIBLE";
    }

    @Override
    public String reason() {
        return "CGR below 8.0";
    }
}

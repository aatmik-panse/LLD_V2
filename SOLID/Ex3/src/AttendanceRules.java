
public class AttendanceRules implements IEligibilityRule{
    @Override
    public String check(StudentProfile student) {
        if (student.attendancePct < 75) {
            return "NOT_ELIGIBLE";
        }
        return "ELIGIBLE";
    }

    @Override
    public String reason() {
        return "attendance below 75";
    }
}

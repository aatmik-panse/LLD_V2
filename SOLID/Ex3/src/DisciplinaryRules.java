
public class DisciplinaryRules implements IEligibilityRule{
    @Override
    public String check(StudentProfile student) {
        if (student.disciplinaryFlag != LegacyFlags.NONE) {
            return "NOT_ELIGIBLE";
        }
        return "ELIGIBLE";
    }

    @Override
    public String reason() {
        return "disciplinary flag present";
    }
}

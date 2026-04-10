
public class CreditsRules implements IEligibilityRule{
    @Override
    public String check(StudentProfile student) {
        if (student.earnedCredits < 20) {
            return "NOT_ELIGIBLE";
        }
        return "ELIGIBLE";
    }

    @Override
    public String reason() {
        return "credits below 20";
    }
}
public interface IEligibilityRule {
    String check(StudentProfile student);
    String reason();
}

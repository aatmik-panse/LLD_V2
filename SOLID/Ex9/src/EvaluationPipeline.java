public class EvaluationPipeline {
    private final PlagiarismCheck plagiarismCheck;
    private final Grader grader;
    private final ReportOutput reportOutput;
    private final Rubric rubric;

    public EvaluationPipeline(PlagiarismCheck plagiarismCheck, Grader grader,
                              ReportOutput reportOutput, Rubric rubric) {
        this.plagiarismCheck = plagiarismCheck;
        this.grader = grader;
        this.reportOutput = reportOutput;
        this.rubric = rubric;
    }

    public void evaluate(Submission sub) {
        int plag = plagiarismCheck.check(sub);
        System.out.println("PlagiarismScore=" + plag);

        int code = grader.grade(sub, rubric);
        System.out.println("CodeScore=" + code);

        String reportName = reportOutput.write(sub, plag, code);
        System.out.println("Report written: " + reportName);

        int total = plag + code;
        String result = (total >= 90) ? "PASS" : "FAIL";
        System.out.println("FINAL: " + result + " (total=" + total + ")");
    }
}

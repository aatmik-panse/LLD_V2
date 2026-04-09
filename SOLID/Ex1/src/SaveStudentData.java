public class SaveStudentData {
    private IStudentDB db;

    public SaveStudentData(IStudentDB db){ this.db=db; }
    public void save(StudentRecord studentRecord){ db.save(studentRecord); }
    public int count(){ return db.count(); }
}



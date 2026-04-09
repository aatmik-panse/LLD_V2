public class IdGenerationService{
    public String generateId(int currentCount){
        return IdUtil.nextStudentId(currentCount);
    }
}

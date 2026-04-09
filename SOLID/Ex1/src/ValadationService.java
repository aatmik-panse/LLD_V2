import java.util.*;
public class ValadationService{
    public List<String> validate(Map<String,String> kv){
        List<String> errors = new ArrayList<>();
        if (kv.get("name").isEmpty()) errors.add("name is required");
        if (kv.get("email").isEmpty()) errors.add("email is required");
        if (kv.get("phone").isEmpty()) errors.add("phone is required");
        if (kv.get("program").isEmpty()) errors.add("program is required");

        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            return errors;
        }

        return errors;
    }
} 

package seminar05.calculator;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<String> logs = new ArrayList<>();
    public void addLog(String message){
        logs.add(message);
    }
    public List<String> getLogs(){
        return logs;
    }
}

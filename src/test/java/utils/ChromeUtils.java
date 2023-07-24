package utils;
import java.util.Optional;

public class ChromeUtils {
    public static void destroyChrome() {

        //TODO killall /opt/google/chrome/chrome - убить все хромы от
        ProcessHandle.allProcesses()
                .filter(process -> {
                    Optional<String> cmd = process.info().command();
                    return cmd.isPresent() && cmd.get().equals("/opt/google/chrome/chrome");
                }).map(ProcessHandle::destroy);
    }
}

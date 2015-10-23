import com.notepad.controller.NPFontController;
import com.notepad.controller.NPMainController;
import com.notepad.model.functional.NPDocumentModel;
import com.notepad.view.NPFontFrame;
import com.notepad.view.NPMainFrame;

public class NPMainClass {
    public static void main(String[] args) {
        NPMainFrame mainFrame = new NPMainFrame();
        NPDocumentModel document = new NPDocumentModel();

        new NPMainController(mainFrame, document);
    }
}

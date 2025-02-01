import entity.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import org.hibernate.Session;

public class MainFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colUpdate;
    public TableColumn colDelete;
    public Button btn;

    public void initialize() {
        HibernateUtil.openSession();
    }


    public void saveOnAction(ActionEvent actionEvent) {

        Student student = new Student(Long.parseLong(txtId.getText()),
                txtName.getText(),
                txtAddress.getText());

        if(btn.getText().equals("Save Student")) {
         try(Session session = HibernateUtil.openSession()){
             session.save(student);
             loardAll();
             new Alert(Alert.AlertType.INFORMATION, "Student Saved").show();
            }
        }else {
            try(Session session = HibernateUtil.openSession()){
                session.save(student);
                loardAll();
                new Alert(Alert.AlertType.INFORMATION, "Student Saved").show();
            }
        }
    }

    private void loardAll() {
    }
}

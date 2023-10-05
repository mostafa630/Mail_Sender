module com.example.mailsender {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;


    opens com.example.mailsender to javafx.fxml;
    exports com.example.mailsender;
}
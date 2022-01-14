module dictionary.dictionarygui {
    requires javafx.controls;
    requires javafx.fxml;
    requires dictionary.wordsstorage;
    requires dicitonary.examwords;

    opens dictionary.dictionarygui to javafx.fxml;
    exports dictionary.dictionarygui;
}
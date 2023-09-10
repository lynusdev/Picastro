import imp.*; // Alles aus IMP Unterordner
import javafx.fxml.*; // FXML Definitionen
import javafx.scene.control.*; // Jedes Control-Element
import javafx.scene.layout.*; // Alle Layout-Definitionen
import javafx.event.*; // Button und Menu-Events
import javafx.stage.*; // Dateiöffnen / Speichern-Dialog
import java.io.File; // Dateihandling
import javafx.scene.control.Alert.AlertType;

public class Controller {

    @FXML
    private HBox hauptbereich;

    @FXML
    private Label lDateiname;

    @FXML
    private Slider slZoom;

    @FXML
    private PictureViewer viewer;

    // Eigene Attribute

    private FileChooser dateidialog;
    private Pixeloperationen algo1;
    private Mehrpixeloperationen algo2;
    private GeometrischeBildoperationen algo3;

    public void initialize() {
        dateidialog = new FileChooser();
        dateidialog.setInitialDirectory(new File("images"));
        algo1= new Pixeloperationen();
        algo2 = new Mehrpixeloperationen();
        algo3 = new GeometrischeBildoperationen();
        slZoom.valueProperty()
        .addListener((observable, oldValue, newValue) -> zoom());
    }

    void zoom() {
        double zoom = slZoom.getValue();
        viewer.setZoom(zoom);
    }

    @FXML
    void bUndo(ActionEvent event) {
        viewer.back();
    }

    @FXML
    void mAbout(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Author - Linus Jung");
        alert.setContentText("30.04.22");
        alert.showAndWait();
    }

    @FXML
    void mInvert(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo1.invertiere(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }
    
    @FXML
    void mBlur(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo2.weichzeichnen(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mGreyscaleAverage(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo1.graustufenDurchschnitt(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mGreyscaleMax(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo1.graustufenMax(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mGreyscaleMin(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo1.graustufenMin(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mGreyscaleNatural(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo1.graustufenNatuerlich(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mMirrorHorizontal(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo3.spiegleHorizontal(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mMirrorVertical(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo3.spiegleVertikal(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mOnlyBlue(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo1.nurBlaukanal(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mOnlyGreen(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo1.nurGruenkanal(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mOnlyRed(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo1.nurRotkanal(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mOpen(ActionEvent event) {
        File file = dateidialog.showOpenDialog(null);
        if (file != null) {
            Picture neuesBild = new Picture(file.getAbsolutePath());
            viewer.setImage(neuesBild, true);
            lDateiname.setText(file.getAbsolutePath());
        }
    }

    @FXML
    void mQuit(ActionEvent event) {
        Stage stage = (Stage) hauptbereich.getScene().getWindow();
        stage.close();
    }

    @FXML
    void mRelief(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo2.relief(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mRotateLeft(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo3.DreheLinks(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mRotateRight(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo3.dreheRechts(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mSave(ActionEvent event) {
        File file = dateidialog.showSaveDialog(null);
        if (file != null) {
            Picture aktuellesBild = viewer.getImage();
            aktuellesBild.save(file.getAbsolutePath());
            lDateiname.setText(file.getAbsolutePath());
        }

    }

    @FXML
    void mSharpen(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo2.schaerfen(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mSwitchGreenBlue(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo1.tauscheGruenBlau(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mSwitchRedBlue(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo1.tauscheRotBlau(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mSwitchRedGreen(ActionEvent event) {
        Picture aktuellesBild = viewer.getImage();
        Picture neuesBild = algo1.tauscheRotGruen(aktuellesBild);
        viewer.setImage(neuesBild, true);
    }

    @FXML
    void mUndo(ActionEvent event) {
        viewer.back();
    }

}
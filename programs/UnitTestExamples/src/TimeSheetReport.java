import java.io.IOException;
import java.nio.file.Path;

// Diese Klasse will Zeiterfassungseinträge "verarbeiten"
// Diese Klasse möchte sich nicht darum kümmern, wo diese
// zu verarbeitenden Daten eigentlich herkommen (Data Source).
public class TimeSheetReport {

  public static void main(String[] args) throws IOException {
    var source = new TimeSheetDataFileSource(Path.of("time-sheet-data", "data001.csv"));
    int[] record = null;
    for (record = source.nextRecord(); record != null; record = source.nextRecord()) {
      System.out.printf("Tag: %02d Ankunft: %02d:%02d Feierabend: %02d:%02d\n",
              record[0], record[1], record[2], record[3], record[4]);
    }

  }

}

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class TimeSheetDataFileSource {

  private final Path path;
  private final Scanner scanner;

  public TimeSheetDataFileSource(Path path) throws IOException {
    this.path = path;
    this.scanner = new Scanner(path);
  }

  public int[] nextRecord() {
    while (this.scanner.hasNextLine()) {
      // Lies eine Zeile und entferne voranstehende und nachfolgende Leerzeichen.
      String line = this.scanner.nextLine().trim();
      // Überspringe leere Zeilen.
      if (line.isBlank()) continue;
      // Trenne die Zeilen anhand des Zeichens ; auf. Dadurch entstehen Felder.
      String[] fields = line.split(";");
      // Jedes Feld wird nun in einen Integer konvertiert.
      int[] record = new int[fields.length];
      for (int i = 0; i < record.length; i++) {
        record[i] = Integer.parseInt(fields[i].trim());
      }
      return record;
    }
    return null;
  }

}

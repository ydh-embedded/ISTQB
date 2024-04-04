import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TimeSheetDataFakeSource {

  private static final ArrayList<int[]> fakeRecords = new ArrayList<>(List.of(
          new int[]{1, 10, 15, 17, 30},
          new int[]{2, 9, 10, 16, 45},
          new int[]{6, 7, 35, 15, 55}
  ));

  // Diese Variable speichert die aktuelle Position in der FakeData List.
  private int recordIndex = 0;

  public TimeSheetDataFakeSource(Path path) {

  }

  public int[] nextRecord() {
    // Wenn keine weiteren Fake Daten vorhanden, gib null zurück.
    if (this.recordIndex >= fakeRecords.size()) return null;
    // Nimm den aktuellen Fake Record und gib ihn zurück.
    // Erhöhe gleichzeitig den Index.
    int[] record = fakeRecords.get(this.recordIndex);
    this.recordIndex++;
    return record;
  }

}

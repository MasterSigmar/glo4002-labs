package labs;

public class Clinic extends BaseClinic {

  public Clinic() {}

  public Clinic(TriageType triageType) {
    TriageType = triageType;
  }

  public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {

    if (isGravityTooLow(gravity)) return;

    switch (TriageType) {
      case FIFO:
        PushBack(name, visibleSymptom);
        break;

      case GRAVITY:
        if (isHighPriority(gravity)) {
          PushFront(name, visibleSymptom);
        } else {
          PushBack(name, visibleSymptom);
        }
        break;
    }
  }
}

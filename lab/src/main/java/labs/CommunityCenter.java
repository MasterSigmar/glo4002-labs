package labs;

public class CommunityCenter extends BaseClinic {

  public CommunityCenter() {}

  public CommunityCenter(TriageType triageType) {
    TriageType = triageType;
  }

  public void triagePatient(String name, int gravity) {

    if (isGravityTooLow(gravity)) return;

    switch (TriageType) {
      case FIFO:
        MedicPatientNamesPushBack(name);
        break;

      case GRAVITY:
        if (isHighPriority(gravity)) {
          MedicPatientNamesPushFront(name);
        } else {
          MedicPatientNamesPushBack(name);
        }
        break;
    }
  }
}

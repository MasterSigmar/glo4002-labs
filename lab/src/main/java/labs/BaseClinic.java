package labs;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseClinic {

  private TriageType _triageType;
  private static final int _triageThreshold = 5;

  private List<String> _medicPatientNames = new ArrayList<String>();
  private List<String> _radiologyPatientNames = new ArrayList<String>();

  public BaseClinic() {
    _triageType = TriageType.FIFO;
  }

  public BaseClinic(TriageType triageType) {
    _triageType = triageType;
  }

  public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {

    if (isGravityTooLow(gravity)) return;

    switch (_triageType) {
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

  private void PushBack(String name, VisibleSymptom visibleSymptom) {
    MedicPatientNamesPushBack(name);
    if (isRadiologyPatient(visibleSymptom)) RadiologyPatientNamesPushBack(name);
  }

  private void PushFront(String name, VisibleSymptom visibleSymptom) {
    MedicPatientNamesPushFront(name);
    if (isRadiologyPatient(visibleSymptom)) RadiologyPatientNamesPushFront(name);
  }

  public List<String> get_medicPatientNames() {
    return _medicPatientNames;
  }

  public String getFirstMedicPatientName() {
    return _medicPatientNames.get(0);
  }

  public String getLastMedicPatientName() {
    int indexOfLastItem = _medicPatientNames.size() - 1;
    return _medicPatientNames.get(indexOfLastItem);
  }

  public List<String> get_radiologyPatientNames() {
    return _radiologyPatientNames;
  }

  public String getFirstRadiologyPatientName() {
    return _radiologyPatientNames.get(0);
  }

  public String getLastRadiologyPatientName() {
    int indexOfLastItem = _radiologyPatientNames.size() - 1;
    return _radiologyPatientNames.get(indexOfLastItem);
  }

  private void MedicPatientNamesPushBack(String name) {
    _medicPatientNames.add(name);
  }

  private void MedicPatientNamesPushFront(String name) {
    _medicPatientNames.add(0, name);
  }

  private void RadiologyPatientNamesPushBack(String name) {
    _radiologyPatientNames.add(name);
  }

  private void RadiologyPatientNamesPushFront(String name) {
    _radiologyPatientNames.add(0, name);
  }

  private boolean isGravityTooLow(int gravity) {
    return gravity == 1;
  }

  private boolean isRadiologyPatient(VisibleSymptom visibleSymptom) {
    return visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN;
  }

  private boolean isHighPriority(int gravity) {
    return gravity > _triageThreshold;
  }
}

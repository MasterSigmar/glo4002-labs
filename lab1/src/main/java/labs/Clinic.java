package labs;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
  private TriageType _triageType;
  private static final int _triageThreshold = 5;

  private List<String> _medicPatientNames = new ArrayList<String>();
  private List<String> _radiologyPatientNames = new ArrayList<String>();

  public Clinic() {
    _triageType = TriageType.FIFO;
  }

  public Clinic(TriageType triageType) {
    _triageType = triageType;
  }

  public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {

    switch (_triageType) {
      case FIFO:
        triagePatientFifo(name, visibleSymptom);
        break;

      case GRAVITY:
        triagePatientGravity(name, gravity, visibleSymptom);
        break;
    }
  }

  private void triagePatientFifo(String name, VisibleSymptom visibleSymptom) {
    MedicPatientNamesPushBack(name);

    if (visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN)
      RadiologyPatientNamesPushBack(name);
  }

  private void triagePatientGravity(String name, int gravity, VisibleSymptom visibleSymptom) {
    if (gravity > _triageThreshold) MedicPatientNamesPushFront(name);
    else MedicPatientNamesPushBack(name);

    if (visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN)
      RadiologyPatientNamesPushBack(name);
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

  public void MedicPatientNamesPushBack(String name) {
    _medicPatientNames.add(name);
  }

  public void MedicPatientNamesPushFront(String name) {
    _medicPatientNames.add(0, name);
  }

  public void RadiologyPatientNamesPushBack(String name) {
    _radiologyPatientNames.add(name);
  }

  public void RadiologyPatientNamesPushFront(String name) {
    _radiologyPatientNames.add(0, name);
  }
}

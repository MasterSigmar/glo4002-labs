package labs;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseClinic {

  protected TriageType TriageType = labs.TriageType.FIFO;

  private static final int _triageThreshold = 5;
  private List<String> _medicPatientNames = new ArrayList<String>();
  private List<String> _radiologyPatientNames = new ArrayList<String>();

  protected List<String> get_medicPatientNames() {
    return _medicPatientNames;
  }

  protected String getFirstMedicPatientName() {
    return _medicPatientNames.get(0);
  }

  protected String getLastMedicPatientName() {
    int indexOfLastItem = _medicPatientNames.size() - 1;
    return _medicPatientNames.get(indexOfLastItem);
  }

  protected List<String> get_radiologyPatientNames() {
    return _radiologyPatientNames;
  }

  protected String getFirstRadiologyPatientName() {
    return _radiologyPatientNames.get(0);
  }

  protected String getLastRadiologyPatientName() {
    int indexOfLastItem = _radiologyPatientNames.size() - 1;
    return _radiologyPatientNames.get(indexOfLastItem);
  }

  protected boolean isInMedicList(String name){
    return _medicPatientNames.contains(name);
  }

  protected boolean isInRadiologyList(String name){
    return _radiologyPatientNames.contains(name);
  }

  protected void MedicPatientNamesPushBack(String name) {
    _medicPatientNames.add(name);
  }

  protected void MedicPatientNamesPushFront(String name) {
    _medicPatientNames.add(0, name);
  }

  private void RadiologyPatientNamesPushBack(String name) {
    _radiologyPatientNames.add(name);
  }

  private void RadiologyPatientNamesPushFront(String name) {
    _radiologyPatientNames.add(0, name);
  }

  protected void PushBack(String name, VisibleSymptom visibleSymptom) {
    MedicPatientNamesPushBack(name);
    if (isRadiologyPatient(visibleSymptom)) RadiologyPatientNamesPushBack(name);
  }

  protected void PushFront(String name, VisibleSymptom visibleSymptom) {
    MedicPatientNamesPushFront(name);
    if (isRadiologyPatient(visibleSymptom)) RadiologyPatientNamesPushFront(name);
  }

  protected boolean isGravityTooLow(int gravity) {
    return gravity == 1;
  }

  private boolean isRadiologyPatient(VisibleSymptom visibleSymptom) {
    return visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN;
  }

  protected boolean isHighPriority(int gravity) {
    return gravity > _triageThreshold;
  }
}

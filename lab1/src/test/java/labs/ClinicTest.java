package labs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ClinicTest {
  private String _defaultName = "default";
  private int _defaultGravity = 3;
  private VisibleSymptom _defaultVisibleSymptom = VisibleSymptom.MIGRAINE;

  @Test
  void triagePatient_GivenPatientHasMigraine_WhenCalled_ShouldAddPatientAtEndOfMedicList() {
    // Initialize
    Clinic clinic = new Clinic();
    String expected = _defaultName;

    // Act
    clinic.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
    String actual = clinic.getLastMedicPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void triagePatient_GivenPatientHasMigraine_WhenCalled_ShouldNotAddPatientToRadiology() {
    // Initialize
    Clinic clinic = new Clinic();

    // Act
    clinic.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);

    // Assert
    assertFalse(clinic.get_radiologyPatientNames().contains(_defaultName));
  }

  @Test
  void
      triagePatient_GivenPatientHasMigraineAlreadyInList_WhenCalled_ShouldAddNewPatientAtEndOfMedicList() {
    // Initialize
    Clinic clinic = new Clinic();
    clinic.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
    String newPatient = "newPatient";
    String expected = newPatient;

    // Act
    clinic.triagePatient(newPatient, _defaultGravity, VisibleSymptom.FLU);
    String actual = clinic.getLastMedicPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void
      triagePatient_GivenPatientHasMigraineAlreadyInList_WhenCalled_ShouldNotAddNewPatientToRadiology() {
    // Initialize
    Clinic clinic = new Clinic();
    clinic.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
    String newPatient = "newPatient";

    // Act
    clinic.triagePatient(newPatient, _defaultGravity, VisibleSymptom.FLU);

    // Assert
    assertFalse(clinic.get_radiologyPatientNames().contains(_defaultName));
  }

  @Test
  void triagePatient_GivenPatientHasSprain_WhenCalled_ShouldAddPatientAtEndOfMedicList() {
    // Initialize
    Clinic clinic = new Clinic();
    String expected = _defaultName;

    // Act
    clinic.triagePatient(_defaultName, _defaultGravity, VisibleSymptom.SPRAIN);
    String actual = clinic.getLastMedicPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void triagePatient_GivenPatientHasSprain_WhenCalled_ShouldAddPatientAtEndOfRadiologyList() {
    // Initialize
    Clinic clinic = new Clinic();
    String expected = _defaultName;

    // Act
    clinic.triagePatient(_defaultName, _defaultGravity, VisibleSymptom.SPRAIN);
    String actual = clinic.getLastMedicPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void triagePatient_GivenPatientHasBrokenBone_WhenCalled_ShouldAddPatientAtEndOfMedicList() {
    // Initialize
    Clinic clinic = new Clinic();
    String expected = _defaultName;

    // Act
    clinic.triagePatient(_defaultName, _defaultGravity, VisibleSymptom.BROKEN_BONE);
    String actual = clinic.getLastMedicPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void triagePatient_GivenPatientHasBrokenBone_WhenCalled_ShouldAddPatientAtEndOfRadiologyList() {
    // Initialize
    Clinic clinic = new Clinic();
    String expected = _defaultName;

    // Act
    clinic.triagePatient(_defaultName, _defaultGravity, VisibleSymptom.BROKEN_BONE);
    String actual = clinic.getLastMedicPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void
      triagePatient_GivenPatientHasMigraineAlreadyInList_WhenCalled_ShouldAddNewPatientWithSprainAtEndOfMedicAndRadiologyList() {
    // Initialize
    Clinic clinic = new Clinic();
    clinic.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
    String newPatient = "newPatient";
    String expected = newPatient;

    // Act
    clinic.triagePatient(newPatient, _defaultGravity, VisibleSymptom.SPRAIN);

    // Assert
    assertEquals(expected, clinic.getLastMedicPatientName());
    assertEquals(expected, clinic.getLastRadiologyPatientName());
  }

  @Test
  void
      triagePatient_GivenPatientHasMigraineAlreadyInList_WhenCalled_ShouldAddNewPatientWithBrokenBoneAtEndOfMedicAndRadiologyList() {
    // Initialize
    Clinic clinic = new Clinic();
    clinic.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
    String newPatient = "newPatient";
    String expected = newPatient;

    // Act
    clinic.triagePatient(newPatient, _defaultGravity, VisibleSymptom.BROKEN_BONE);

    // Assert
    assertEquals(expected, clinic.getLastMedicPatientName());
    assertEquals(expected, clinic.getLastRadiologyPatientName());
  }

  @Test
  void
      triagePatient_GivenPatientWithLowGravityAlreadyPresentInMedicList_WhenNewPatientWithHighGravity_ShouldAddNewPatientAtFrontOfMedicList() {
    // Initialize
    Clinic clinic = new Clinic(TriageType.GRAVITY);
    clinic.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);

    String newPatientName = "newPatientName";
    int newPatientGravity = 7;
    String expected = newPatientName;

    // Act
    clinic.triagePatient(newPatientName, newPatientGravity, _defaultVisibleSymptom);
    String actual = clinic.getFirstMedicPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void
      triagePatient_GivenPatientWithLowGravityAlreadyPresentInRadiologyList_WhenNewPatientWithHighGravity_ShouldAddNewPatientAtFrontOfRadiologyList() {
    // Initialize
    Clinic clinic = new Clinic(TriageType.GRAVITY);
    clinic.triagePatient(_defaultName, _defaultGravity, VisibleSymptom.BROKEN_BONE);

    String newPatientName = "newPatientName";
    int newPatientGravity = 7;
    String expected = newPatientName;

    // Act
    clinic.triagePatient(newPatientName, newPatientGravity, VisibleSymptom.BROKEN_BONE);
    String actual = clinic.get_radiologyPatientNames().get(0);

    // Assert
    assertEquals(expected, actual);
  }
}

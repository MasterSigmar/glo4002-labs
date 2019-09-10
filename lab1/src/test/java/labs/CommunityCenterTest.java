package labs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CommunityCenterTest {
  private String _defaultName = "default";
  private int _defaultGravity = 3;
  private VisibleSymptom _defaultVisibleSymptom = VisibleSymptom.MIGRAINE;

  @Test
  void triagePatient_GivenPatientHasMigraine_WhenCalled_ShouldAddPatientAtEndOfMedicList() {
    // Initialize
    CommunityCenter communityCenter = new CommunityCenter();
    String expected = _defaultName;

    // Act
    communityCenter.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
    String actual = communityCenter.getLastMedicPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void triagePatient_GivenPatientHasMigraine_WhenCalled_ShouldNotAddPatientToRadiology() {
    // Initialize
    CommunityCenter communityCenter = new CommunityCenter();

    // Act
    communityCenter.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);

    // Assert
    assertFalse(communityCenter.get_radiologyPatientNames().contains(_defaultName));
  }

  @Test
  void
      triagePatient_GivenPatientHasMigraineAlreadyInList_WhenCalled_ShouldAddNewPatientAtEndOfMedicList() {
    // Initialize
    CommunityCenter communityCenter = new CommunityCenter();
    communityCenter.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
    String newPatient = "newPatient";
    String expected = newPatient;

    // Act
    communityCenter.triagePatient(newPatient, _defaultGravity, VisibleSymptom.FLU);
    String actual = communityCenter.getLastMedicPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void
      triagePatient_GivenPatientHasMigraineAlreadyInList_WhenCalled_ShouldNotAddNewPatientToRadiology() {
    // Initialize
    CommunityCenter communityCenter = new CommunityCenter();
    communityCenter.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
    String newPatient = "newPatient";

    // Act
    communityCenter.triagePatient(newPatient, _defaultGravity, VisibleSymptom.FLU);

    // Assert
    assertFalse(communityCenter.get_radiologyPatientNames().contains(_defaultName));
  }

  @Test
  void triagePatient_GivenPatientHasSprain_WhenCalled_ShouldAddPatientAtEndOfMedicList() {
    // Initialize
    CommunityCenter communityCenter = new CommunityCenter();
    String expected = _defaultName;

    // Act
    communityCenter.triagePatient(_defaultName, _defaultGravity, VisibleSymptom.SPRAIN);
    String actual = communityCenter.getLastMedicPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void triagePatient_GivenPatientHasSprain_WhenCalled_ShouldAddPatientAtEndOfRadiologyList() {
    // Initialize
    CommunityCenter communityCenter = new CommunityCenter();
    String expected = _defaultName;

    // Act
    communityCenter.triagePatient(_defaultName, _defaultGravity, VisibleSymptom.SPRAIN);
    String actual = communityCenter.getLastMedicPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void triagePatient_GivenPatientHasBrokenBone_WhenCalled_ShouldAddPatientAtEndOfMedicList() {
    // Initialize
    CommunityCenter communityCenter = new CommunityCenter();
    String expected = _defaultName;

    // Act
    communityCenter.triagePatient(_defaultName, _defaultGravity, VisibleSymptom.BROKEN_BONE);
    String actual = communityCenter.getLastMedicPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void triagePatient_GivenPatientHasBrokenBone_WhenCalled_ShouldAddPatientAtEndOfRadiologyList() {
    // Initialize
    CommunityCenter communityCenter = new CommunityCenter();
    String expected = _defaultName;

    // Act
    communityCenter.triagePatient(_defaultName, _defaultGravity, VisibleSymptom.BROKEN_BONE);
    String actual = communityCenter.getLastMedicPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void
      triagePatient_GivenPatientHasMigraineAlreadyInList_WhenCalled_ShouldAddNewPatientWithSprainAtEndOfMedicAndRadiologyList() {
    // Initialize
    CommunityCenter communityCenter = new CommunityCenter();
    communityCenter.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
    String newPatient = "newPatient";
    String expected = newPatient;

    // Act
    communityCenter.triagePatient(newPatient, _defaultGravity, VisibleSymptom.SPRAIN);

    // Assert
    assertEquals(expected, communityCenter.getLastMedicPatientName());
    assertEquals(expected, communityCenter.getLastRadiologyPatientName());
  }

  @Test
  void
      triagePatient_GivenPatientHasMigraineAlreadyInList_WhenCalled_ShouldAddNewPatientWithBrokenBoneAtEndOfMedicAndRadiologyList() {
    // Initialize
    CommunityCenter communityCenter = new CommunityCenter();
    communityCenter.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
    String newPatient = "newPatient";
    String expected = newPatient;

    // Act
    communityCenter.triagePatient(newPatient, _defaultGravity, VisibleSymptom.BROKEN_BONE);

    // Assert
    assertEquals(expected, communityCenter.getLastMedicPatientName());
    assertEquals(expected, communityCenter.getLastRadiologyPatientName());
  }

  @Test
  void
      triagePatient_GivenPatientWithLowGravityAlreadyPresentInMedicList_WhenNewPatientWithHighGravity_ShouldAddNewPatientAtFrontOfMedicList() {
    // Initialize
    CommunityCenter communityCenter = new CommunityCenter(TriageType.GRAVITY);
    communityCenter.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);

    String newPatientName = "newPatientName";
    int newPatientGravity = 7;
    String expected = newPatientName;

    // Act
    communityCenter.triagePatient(newPatientName, newPatientGravity, _defaultVisibleSymptom);
    String actual = communityCenter.getFirstMedicPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void
      triagePatient_GivenPatientWithLowGravityAlreadyPresentInRadiologyList_WhenNewPatientWithHighGravity_ShouldAddNewPatientAtFrontOfRadiologyList() {
    // Initialize
    CommunityCenter communityCenter = new CommunityCenter(TriageType.GRAVITY);
    communityCenter.triagePatient(_defaultName, _defaultGravity, VisibleSymptom.BROKEN_BONE);

    String newPatientName = "newPatientName";
    int newPatientGravity = 7;
    String expected = newPatientName;

    // Act
    communityCenter.triagePatient(newPatientName, newPatientGravity, VisibleSymptom.BROKEN_BONE);
    String actual = communityCenter.getFirstRadiologyPatientName();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void
      triagePatient_GivenDefaultPatientAlreadyInList_WhenNewPatientGravityIs1_ShouldNotAddToLists() {
    // Initialize
    CommunityCenter communityCenter = new CommunityCenter();
    communityCenter.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);

    String newPatientName = "newPatientName";
    int newPatientGravity = 1;

    // Act
    communityCenter.triagePatient(newPatientName, newPatientGravity, _defaultVisibleSymptom);

    // Assert
    assertFalse(communityCenter.get_medicPatientNames().contains(newPatientName));
    assertFalse(communityCenter.get_radiologyPatientNames().contains(newPatientName));
  }
}

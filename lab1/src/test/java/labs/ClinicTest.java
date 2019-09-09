package labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClinicTest {
    private Clinic _clinic;
    private String _defaultName = "default";
    private int _defaultGravity = 3;
    private VisibleSymptom _defaultVisibleSymptom = VisibleSymptom.MIGRAINE;

    @BeforeEach
    void setUp() {
        _clinic = new Clinic();
    }

    @Test
    void triagePatient_GivenPatientHasMigraine_WhenCalled_ShouldAddPatientAtEndOfMedicList() {
        // Initialize
        String expected = _defaultName;

        // Act
        _clinic.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
        String actual = _clinic.getLastMedicPatientName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void triagePatient_GivenPatientHasMigraine_WhenCalled_ShouldNotAddPatientToRadiology() {
        // Initialize

        // Act
        _clinic.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);

        // Assert
        assertFalse(_clinic.getRadiologyPatientNames().contains(_defaultName));
    }

    @Test
    void triagePatient_GivenPatientHasMigraineAlreadyInList_WhenCalled_ShouldAddNewPatientAtEndOfMedicList() {
        // Initialize
        _clinic.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
        String newPatient = "newPatient";
        String expected = newPatient;

        // Act
        _clinic.triagePatient(newPatient, _defaultGravity, VisibleSymptom.FLU);
        String actual = _clinic.getLastMedicPatientName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void triagePatient_GivenPatientHasMigraineAlreadyInList_WhenCalled_ShouldNotAddNewPatientToRadiology() {
        // Initialize
        _clinic.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
        String newPatient = "newPatient";

        // Act
        _clinic.triagePatient(newPatient, _defaultGravity, VisibleSymptom.FLU);

        // Assert
        assertFalse(_clinic.getRadiologyPatientNames().contains(_defaultName));
    }

    @Test
    void triagePatient_GivenPatientHasSprain_WhenCalled_ShouldAddPatientAtEndOfMedicList() {
        // Initialize
        String expected = _defaultName;

        // Act
        _clinic.triagePatient(_defaultName, _defaultGravity, VisibleSymptom.SPRAIN);
        String actual = _clinic.getLastMedicPatientName();

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    void triagePatient_GivenPatientHasSprain_WhenCalled_ShouldAddPatientAtEndOfRadiologyList() {
        // Initialize
        String expected = _defaultName;

        // Act
        _clinic.triagePatient(_defaultName, _defaultGravity, VisibleSymptom.SPRAIN);
        String actual = _clinic.getLastMedicPatientName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void triagePatient_GivenPatientHasBrokenBone_WhenCalled_ShouldAddPatientAtEndOfMedicList() {
        // Initialize
        String expected = _defaultName;

        // Act
        _clinic.triagePatient(_defaultName, _defaultGravity, VisibleSymptom.BROKEN_BONE);
        String actual = _clinic.getLastMedicPatientName();

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    void triagePatient_GivenPatientHasBrokenBone_WhenCalled_ShouldAddPatientAtEndOfRadiologyList() {
        // Initialize
        String expected = _defaultName;

        // Act
        _clinic.triagePatient(_defaultName, _defaultGravity, VisibleSymptom.BROKEN_BONE);
        String actual = _clinic.getLastMedicPatientName();

        // Assert
        assertEquals(expected, actual);
    }



    @Test
    void triagePatient_GivenPatientHasMigraineAlreadyInList_WhenCalled_ShouldAddNewPatientWithSprainAtEndOfMedicAndRadiologyList() {
        // Initialize
        _clinic.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
        String newPatient = "newPatient";
        String expected = newPatient;

        // Act
        _clinic.triagePatient(newPatient, _defaultGravity, VisibleSymptom.SPRAIN);

        // Assert
        assertEquals(expected, _clinic.getLastMedicPatientName());
        assertEquals(expected, _clinic.getLastRadiologyPatientName());
    }

    @Test
    void triagePatient_GivenPatientHasMigraineAlreadyInList_WhenCalled_ShouldAddNewPatientWithBrokenBoneAtEndOfMedicAndRadiologyList() {
        // Initialize
        _clinic.triagePatient(_defaultName, _defaultGravity, _defaultVisibleSymptom);
        String newPatient = "newPatient";
        String expected = newPatient;

        // Act
        _clinic.triagePatient(newPatient, _defaultGravity, VisibleSymptom.BROKEN_BONE);

        // Assert
        assertEquals(expected, _clinic.getLastMedicPatientName());
        assertEquals(expected, _clinic.getLastRadiologyPatientName());
    }
}
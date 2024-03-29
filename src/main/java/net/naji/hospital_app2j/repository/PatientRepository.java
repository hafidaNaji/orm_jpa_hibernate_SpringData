package net.naji.hospital_app2j.repository;

import net.naji.hospital_app2j.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    public List<Patient> findByMalade(boolean m);
    List<Patient> findByNomContains(String name);

    List<Patient> findByNomContainsAndMalade(String name,boolean b);



}

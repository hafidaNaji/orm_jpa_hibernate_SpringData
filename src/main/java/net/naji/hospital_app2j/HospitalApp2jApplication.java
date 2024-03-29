package net.naji.hospital_app2j;

import net.naji.hospital_app2j.entities.Patient;
import net.naji.hospital_app2j.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HospitalApp2jApplication {

    public static void main(String[] args) {

        SpringApplication.run(HospitalApp2jApplication.class, args);
    }

    @Bean
    public CommandLineRunner start (PatientRepository patientRepository){
                return args -> {
                    Patient p1=new Patient();//NoArgsConstructor
                    p1.setNom("Mohamed");
                    p1.setPrenom("Youssfi");
                    p1.setScore(100);
                    p1.setMalade(false);
                    p1.setDateNaissance(new Date());

                    Patient p2=new Patient(null,"Yassine","Mohamed",new Date(),120,true);//AllArgsConstructor

                    Patient p3=Patient.builder()
                            .nom("Imane")
                            .prenom("Salma")
                            .dateNaissance(new Date())
                            .malade(true)
                            .score(20)
                            .build();

                    Patient p4=Patient.builder()
                            .nom("Imane")
                            .prenom("Fatine")
                            .dateNaissance(new Date())
                            .malade(true)
                            .score(30)
                            .build();

                    Patient p5=Patient.builder()
                            .nom("fatin")
                            .prenom("Salma")
                            .dateNaissance(new Date())
                            .malade(false)
                            .score(40)
                            .build();

                    patientRepository.save(p1);
                    patientRepository.save(p2);
                    patientRepository.save(p3);
                    patientRepository.save(p4);
                    patientRepository.save(p5);

                    List<Patient>patients =patientRepository.findAll();
                    patients.forEach(p -> {
                        System.out.println(p.toString());
                    });


                    System.out.println("*****************************");
                    Patient patient=patientRepository.findById(2L).orElse(null);
                    if (patient!=null){
                        System.out.println(patient.toString());
                    }else{
                        System.out.println("Patient no exist");
                    }

                    System.out.println("*******************************");
                   patient.setScore(500);
                    patientRepository.save(patient);
                    System.out.println(patient.toString());

                    System.out.println("*********************************");
                    patientRepository.deleteById(1L);

                    System.out.println("**********************************");
                   List<Patient>byMalade= patientRepository.findByMalade(true);

                   byMalade.forEach(p->{
                       System.out.println(p.toString());
                   });

                    System.out.println("***********************************");

                    List<Patient> patients3= patientRepository.findByNomContains("h");
                    patients3.forEach(p->{
                        System.out.println(p.toString());
                    });
                    System.out.println("***********************************");

                    List<Patient> patients4= patientRepository.findByNomContainsAndMalade("s",true);
                    patients4.forEach(p->{
                        System.out.println(p.toString());
                    });




        };
    }

}

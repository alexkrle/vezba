package rs.ac.uns.ftn.eo.students;
//Proba
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication  // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class StudentsApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(StudentsApplication.class, args);
    }
}
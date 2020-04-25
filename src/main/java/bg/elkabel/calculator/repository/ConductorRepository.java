/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.elkabel.calculator.repository;

import bg.elkabel.calculator.entity.Conductor;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Kalin
 */
public interface ConductorRepository extends JpaRepository<Conductor, Long> {

	
	Conductor findOneByName(String name);
        @Query("SELECT c.name from Conductor AS c")
	public Stream<String> getAllNames();
        
	
}

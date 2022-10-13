package be.condorcet.api3projet;

import be.condorcet.api3projet.entities.Cours;

import be.condorcet.api3projet.repositories.CoursRepository;
import be.condorcet.api3projet.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/cours")
public class GestCours {
    @Autowired
    private CoursRepository coursRepository;

    @RequestMapping("/tous")
    public String affTous(Map<String, Object> model) {
        System.out.println("recherche cours");
        try {
            Collection<Cours> lco = coursRepository.findAll();
            model.put("mesCours", lco);
        } catch (Exception e) {
            System.out.println("====erreur lors de la recherche====");
            model.put("error", e.getMessage());
            return "error";
        }
        return "affichagetousCours";
    }

    @RequestMapping("/create")
    public String create(@RequestParam String code, @RequestParam String intitule, Map<String, Object> model){
        System.out.println("création d'un cours");
        Cours co = new Cours(code, intitule);
        try{
            coursRepository.save(co);
            System.out.println(co);
            Collection<Cours> lco = coursRepository.findAll();
            model.put("nouvcours", co);
            model.put("mesCours", lco);
        } catch (Exception e){
            System.out.println("====erreur lors de la création====");
            model.put("error", e.getMessage());
            return "error";
        }
        return "nouveauCours";
    }
}

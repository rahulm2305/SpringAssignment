
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/valid")
public class ValidUser {
	@RequestMapping(value="/{id}/{name}", method=RequestMethod.GET)
	public String validateUser(@PathVariable int id, @PathVariable String name) {
		if(id == 18 && name.equals("Rahul")) {
			return "Welcome Rahul!";
		}
		return "Invalid User";
	}
}
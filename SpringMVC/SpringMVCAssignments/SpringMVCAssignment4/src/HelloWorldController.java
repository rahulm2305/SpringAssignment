
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  

@Controller  
public class HelloWorldController {
	 List<InsuranceDomain> list=new ArrayList<InsuranceDomain>();  
	 
	 
	
	@RequestMapping("/add")  
    public String showform(Model m){  
        m.addAttribute("command",new InsuranceDomain());
        return("add");  
    }  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("Ins") InsuranceDomain Ins,Model m){  
        
        System.out.println(Ins.getId()+" "+Ins.getName()+" "+Ins.getType()+" "+Ins.getDept()+" "+Ins.getAmount());
       
           list.add(Ins);
           m.addAttribute("message","Details Added in list");
           return "file";
        
    }  
      
    @RequestMapping("/view")  
    public String view(Model m){  
        
       
      
        m.addAttribute("list",list);
        
        for(InsuranceDomain I:list)
        System.out.println(I.id+" "+I.name+" "+I.dept+" "+I.type+" "+I.amount);
        return "view";  
    }  
    public int getListSize() { 
    	return list.size(); 
    	}
    
}  



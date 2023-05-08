package by;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentHibernate studentInf;

    @GetMapping
    public String getAll(Model model) {
        List<Student> students = studentInf.getAll();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model) {
        Student student = studentInf.getById(id);
        model.addAttribute("student", student);
        return "student";
    }

    @PostMapping
    public String create(@ModelAttribute("student") Student student) {
        studentInf.save(student);
        return "redirect:/students";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable int id, @ModelAttribute("student") Student student) {
        student.setId(id);
        studentInf.update(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        studentInf.delete(id);
        return "redirect:/students";
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student.controller;

import Student.model.studentModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASOS
 */
@Controller
@RequestMapping("/students")
public class studentController {

    List<studentModel> student = new ArrayList<studentModel>();
    
    //tüm kayıtları getirme
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<studentModel> getAllStudents() {
        return student;
    }
    
   /* @RequestMapping(value = "/addStudent",method = RequestMethod.GET)
    @ResponseBody
    public String addStudent() {
        student.add(new studentModel(1,"Mehmet Yılmaz",45.5));
        return "Student Added";
    }*/
        
    
    /*
        [
            {
                "id": 1,
                "name": "Mehmet Yılmaz",
                "grade": 45.5
            }
        ]
    ****************************************************************************
    */
    //kayıt ekleme
    @RequestMapping(value = "/addStudent",   //path
                    method = RequestMethod.POST,  //method            
                    consumes = MediaType.APPLICATION_JSON_VALUE , //kabul aldığı tip
                    produces = MediaType.TEXT_PLAIN_VALUE) // return ettiği tip
                    /*
                        Content-Type:application/json;charset=UTF-8  //gönderdiği tip
                        //Accept:application/json;charset=UTF-8  //kabul aldığı tip
                    */
    @ResponseBody
    public String addStudent(@RequestBody studentModel model) {
        student.add(model);
        return "Student Added"; //return json olarak verilmesi daha mantıklı
    }
    
    
    //tek kayıt getirme*********************************************************
    @RequestMapping(value = "/{id}",
                    method = RequestMethod.GET, 
                    consumes = MediaType.ALL_VALUE , 
                    produces = MediaType.APPLICATION_JSON_VALUE) //PRODUCES bos bırakılabilir
    @ResponseBody
    public studentModel getStudent(@PathVariable("id") String id){
        for(studentModel o : student){
            if(o.getId()==Integer.parseInt(id))
                return o;
        }
        return null;
    }
   
    //silme*********************************************************************
    @RequestMapping(value = "/{id}",
                    method = RequestMethod.DELETE, 
                    consumes = MediaType.ALL_VALUE) 
    @ResponseBody
    public String deleteStudent(@PathVariable("id") String id){
    studentModel sm = null;    
        for(studentModel o : student){
            if(o.getId()==Integer.parseInt(id))
                sm=o;
        }
        if (sm!=null) {
            student.remove(sm);
            return "Student Deleted";
        }else{
            return "Student Deleted Error";
        }    
    }
    
    
    //kayıt güncelleme**********************************************************
    @RequestMapping(value = "/update/{id}",   //path
                    method = RequestMethod.PUT,  //method            
                    consumes = MediaType.APPLICATION_JSON_VALUE , //kabul aldığı tip
                    produces = MediaType.TEXT_PLAIN_VALUE) // return ettiği tip
                    /*
                        Content-Type:application/json;charset=UTF-8  //gönderdiği tip
                        //Accept:application/json;charset=UTF-8  //kabul aldığı tip
                    */
    @ResponseBody
    public String updateStudent(@PathVariable("id") String id, @RequestBody studentModel model) {
        studentModel sm = null;  
        int ix = 0;
        for (int i = 0; i < student.size(); i++) {
            studentModel item = student.get(i);
            if (item.getId() == Integer.parseInt(id)) {
                ix = i;
                sm=item;
            }
        }
 
        if (sm!=null) {
            student.get(ix).setName(model.getName());
            student.get(ix).setGrade(model.getGrade());
            return "Student Updated";
        }else{
            return "Student Updated Error";
        }     
    }
    


}

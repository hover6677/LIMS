/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testexamples;

import com.db.mongodb.TemplateDAO;
import com.document.template.TemplateKeyEnum;
import java.util.Arrays;
import java.util.Date;
import org.bson.Document;

/**
 *
 * @author admin1
 */
public class LIMSTest {
    
    public static void main(String args[]) {
        
        Document templateDoc = new Document();
        templateDoc.append(TemplateKeyEnum.Active.toString(),1);
        templateDoc.append(TemplateKeyEnum.Count.toString(),3);
        templateDoc.append(TemplateKeyEnum.DateTime.toString(),new Date());
        templateDoc.append(TemplateKeyEnum.TID.toString(),"template1");
        templateDoc.append(TemplateKeyEnum.Tags.toString(),Arrays.asList("v3.2", "v3.0", "v2.6"));
        templateDoc.append(TemplateKeyEnum.Type.toString(),"R");
        templateDoc.append(TemplateKeyEnum.User.toString(),"admin");
        
        if(TemplateDAO.connTempDAO())
        {
            TemplateDAO.setTemplateCollection();
            
            if(TemplateDAO.addOrUpdateTemp(templateDoc))
            {
                TemplateDAO.closeDBConn();
            }
            
        }
        
    }
}

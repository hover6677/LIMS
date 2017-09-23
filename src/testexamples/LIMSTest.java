/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testexamples;

import com.db.mongodb.SampleDAO;
import com.db.mongodb.TemplateDAO;
import com.document.enumeration.SampleKeyEnum;
import com.document.enumeration.TemplateKeyEnum;
import com.document.enumeration.UnitEnum;
import java.util.Arrays;
import java.util.Date;
import org.bson.Document;

/**
 *
 * @author admin1
 */
public class LIMSTest {

    public static void main(String args[]) {
        //testTemplateDAO();
        testSampleDAO();

    }

    private static void testSampleDAO() {
        Document templateDoc = new Document();
        templateDoc.append(SampleKeyEnum.Active.toString(), 1);
        templateDoc.append(SampleKeyEnum.DateTime.toString(), new Date());
        templateDoc.append(SampleKeyEnum.SID.toString(), "CocaCola");
        templateDoc.append(SampleKeyEnum.Quanity.toString(), -23.5);
        templateDoc.append(SampleKeyEnum.Unit.toString(), UnitEnum.mg.toString());
        templateDoc.append(SampleKeyEnum.User.toString(), "hover");

        Document objR = new Document();
        objR.append("temperature","-53");
        objR.append("color","Red");
        
        Document objS = new Document();
        objS.append("C1",20);
        objS.append("Level3",30.5);

        templateDoc.append(SampleKeyEnum.Receive.toString(),objR);
        //templateDoc.append(SampleKeyEnum.Storage.toString(),objS);

        if (SampleDAO.connSampleDAO()) {
            SampleDAO.setSampleCollection();

            if (SampleDAO.addOrUpdateSample(templateDoc)) {
                SampleDAO.closeDBConn();
            }

        }
    }

    private static void testTemplateDAO() {
        Document templateDoc = new Document();
        templateDoc.append(TemplateKeyEnum.Active.toString(), 1);
        templateDoc.append(TemplateKeyEnum.Count.toString(), 3);
        templateDoc.append(TemplateKeyEnum.DateTime.toString(), new Date());
        templateDoc.append(TemplateKeyEnum.TID.toString(), "template1");
        templateDoc.append(TemplateKeyEnum.Tags.toString(), Arrays.asList("v3.2", "v3.0", "v2.6"));
        templateDoc.append(TemplateKeyEnum.Type.toString(), "Receive");
        templateDoc.append(TemplateKeyEnum.User.toString(), "admin");

        if (TemplateDAO.connTempDAO()) {
            TemplateDAO.setTemplateCollection();

            if (TemplateDAO.addOrUpdateTemp(templateDoc)) {
                TemplateDAO.closeDBConn();
            }

        }
    }
}

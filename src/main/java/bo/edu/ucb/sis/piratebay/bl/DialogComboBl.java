package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.DialogComboDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DialogComboBl {
    private DialogComboDao dialogComboDao;

    @Autowired
    public DialogComboBl (DialogComboDao dialogComboDao) {
        this.dialogComboDao=dialogComboDao;
    }

    public Integer updateAllGiven(Integer comboData,Integer orderId,Integer productId){
        return this.dialogComboDao.updateCombo(comboData,orderId,productId);
    }
}

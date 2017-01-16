package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.frames;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class MyComboBoxModel extends AbstractListModel
    implements ComboBoxModel {
    public static Object NONE = "none"; 
    List values = new ArrayList();
    List selected = new ArrayList();

    public MyComboBoxModel(Object[] values) {
    	this.values.add(NONE);
        for (Object object : values) {
            this.values.add(object);
        }
    }

    @Override
    public int getSize() {
        return values.size();
    }

    @Override
    public Object getElementAt(int index) {
        return values.get(index);
    }
    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem == null || anItem == NONE) {
            if (selected.isEmpty()) return;
            selected.clear();
        } else {
            boolean removed = selected.remove(anItem);
            if (!removed) {
                selected.add(anItem);
            }
        }
        fireContentsChanged(this, -1, -1);
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

}
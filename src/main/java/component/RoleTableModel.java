/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import domain.Role;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mihailo
 */
public class RoleTableModel extends AbstractTableModel{
    private List<Role> roles;
    private final String[] columnNames = {
        "ID", 
        "First name", 
        "Last name", 
        "Role name"
    };
    private final Class[] columnClasses = {
        Integer.class,
        String.class,
        String.class,
        String.class,
        String.class
    };
    
    public RoleTableModel(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public int getRowCount() {
        if (roles == null) 
            return 0;
         else 
            return roles.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Role role = roles.get(rowIndex);
        
        switch(columnIndex) {
            case 0: return role.getActor().getActorID();
            case 1: return role.getActor().getFirstName();
            case 2: return role.getActor().getLastName();
            case 3: return role.getRoleName();
            default: return "N/A";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Role role = roles.get(rowIndex);
        
            switch(columnIndex) {
            case 3:
                role.setRoleName((String) aValue);
                break;
            }
        
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
    }
    
    
    
    public Role getRoleAt(int row) {
        return roles.get(row);
    }
    
    public List<Role> getAll() {
        return roles;
    }
    
    public void removeAll() {
        roles = null;
    }
}

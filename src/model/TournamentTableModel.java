/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domain.Tournament;
import java.sql.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gazi
 */
public class TournamentTableModel extends AbstractTableModel{
    
    List<Tournament> tournaments;

    public TournamentTableModel(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }
  
    @Override
    public int getRowCount() {
        return tournaments.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tournament tournament = tournaments.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tournament.getTournamentID();
            case 1:
                return tournament.getTournamentName();
            case 2:
                return tournament.getLeague();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Tournament Name";
            case 2:
                return "League";
            default:
                return super.getColumnName(column);
        }
    }
    
    
    
}

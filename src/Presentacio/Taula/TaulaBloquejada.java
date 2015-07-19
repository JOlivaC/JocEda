package Presentacio.Taula;

import javax.swing.JTable;

public class TaulaBloquejada extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean[] editableRows;
	public TaulaBloquejada(){
		editableRows = null;
	}
	public TaulaBloquejada(boolean[] editableRows){
		super();
		this.editableRows = editableRows;
	}
	
	 public boolean isCellEditable(int row, int column) { 
		 if (editableRows != null)
		 return editableRows[column]; 
		 else return true;
	 };
	 
	 public void SetEditableRows(boolean[] editableRows){
		 this.editableRows = editableRows;
	 }
}

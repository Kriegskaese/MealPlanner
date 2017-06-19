package model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableGenerator {

	private Vector<String> columnNames = new Vector<String>();
	private Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
	private TableModel tableModel;
	private Profile activeProfile = Application.getInstance().getActiveProfile();

	public TableGenerator() {
		columnNames = addColumnNames();
		rows = addRows();
		tableModel = new DefaultTableModel(rows, columnNames);
	}

	public TableModel getTableModel() {
		return tableModel;
	}

	private Vector<String> addColumnNames() {
		return activeProfile.getIngredientsColumnNames();
	}

	private Vector<Vector<Object>> addRows() {
		for (Ingredient ingredient : activeProfile.getIngredients()) {
			Vector<Object> row = new Vector<Object>();

			int nColumns = activeProfile.getIngredientsColumnNames().size();
			
			for (int i = 0; i < nColumns; i++) {
				row.add(ingredient.getPropertyValue(i));
			}

			rows.add(row);
		}

		return rows;
	}

}

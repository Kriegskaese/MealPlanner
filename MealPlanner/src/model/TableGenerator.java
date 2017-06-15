package model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableGenerator {
	
	private Vector<String> columnNames = new Vector<String>();
	private Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
	private TableModel tableModel;
	
	public TableGenerator() {
		columnNames = addColumnNames();
		rows = addRows();
		tableModel = new DefaultTableModel(rows, columnNames);
	}
	
	public TableModel getTableModel() {
		return tableModel;
	}
	
	private Vector<String> addColumnNames() {
		// Any ingredient can be used, because they all have the same column names anyway.
		Ingredient anyIngredient = Application.getInstance().getActiveProfile().getIngredients().get(0);

		for (FoodProperty property : anyIngredient.getProperties()) {
			columnNames.add(property.getName());
		}

		return columnNames;
	}

	private Vector<Vector<Object>> addRows() {
		for (Ingredient ingredient : Application.getInstance().getActiveProfile().getIngredients()) {
			Vector<Object> row = new Vector<Object>();

			for (FoodProperty property : ingredient.getProperties()) {
				row.add(property.getValue());
			}

			rows.add(row);
		}

		return rows;
	}

}

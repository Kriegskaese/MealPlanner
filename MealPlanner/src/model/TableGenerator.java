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
		return Application.getInstance().getActiveProfile().getIngredientsColumnNames();
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

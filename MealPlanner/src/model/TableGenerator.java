package model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableGenerator {

	private Vector<String> columnNames = new Vector<String>();
	private Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
	private TableModel tableModel;
	private Profile activeProfile = Application.getInstance().getActiveProfile();

	//***************************** Constructor(s) *****************************

	public TableGenerator() {
		columnNames = new Vector<String>(Ingredient.getNutrientNames());
		rows = addRows();
		tableModel = new DefaultTableModel(rows, columnNames);
	}

	//*********************** Internal Helper Method(s) ************************

	private Vector<Vector<Object>> addRows() {

		for (Ingredient ingredient : activeProfile.getIngredients()) {
			Vector<Object> row = new Vector<Object>();

			for (String nutrientName : Ingredient.getNutrientNames()) {
				float content = ingredient.getNutrientValue(nutrientName);
				row.add(content);
			}

			rows.add(row);
		}

		return rows;
	}

	//************************ Getter(s) and Setter(s) *************************

	public TableModel getTableModel() {
		return tableModel;
	}

}

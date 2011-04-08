package org.vaadin.kanban.web;

import java.util.List;

import org.vaadin.kanban.domain.Card;
import org.vaadin.kanban.domain.StateColumn;
import org.vaadin.navigator.Navigator;

import com.vaadin.Application;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class KanbanBoard extends CustomComponent implements Navigator.View {

    private AbsoluteLayout mainLayout;
    private GridLayout grid;

    /**
     * The constructor should first build the main layout, set the composition
     * root and then do any custom initialization.
     * 
     * The constructor will not be automatically regenerated by the visual
     * editor.
     */
    public KanbanBoard() {
        buildMainLayout();
        setCompositionRoot(mainLayout);

    }

    private AbsoluteLayout buildMainLayout() {
        mainLayout = new AbsoluteLayout();
        setWidth("100.0%");
        setHeight("100.0%");

        grid = new GridLayout();
        grid.setSizeFull();
        grid.setImmediate(true);
        grid.setMargin(true);
        grid.setSpacing(true);
        mainLayout.addComponent(grid, "top:0.0px;left:0.0px;");

        return mainLayout;
    }

    @Override
    public void init(Navigator navigator, Application application) {
        // nothing to do
    }

    @Override
    public void navigateTo(String requestedDataId) {
        List<StateColumn> columns = StateColumn.findAllStateColumns();

        grid.removeAllComponents();
        if (columns.size() < 1) {
            return;
        }
        grid.setColumns(columns.size());
        grid.setRows(3);
        for (int i = 0; i < columns.size(); ++i) {
            StateColumn stateColumn = columns.get(i);
            grid.addComponent(new Label(stateColumn.getName()), i, 0);

            VerticalLayout layout = new VerticalLayout();
            layout.setSizeFull();
            for (Card card : Card.findCardsByStateColumn(stateColumn)
                    .getResultList()) {
                layout.addComponent(new Label(card.getDescription()));
            }

            grid.addComponent(layout, i, 1);
            grid.addComponent(
                    new Label("Definition of done "
                            + stateColumn.getDefinitionOfDone()), i, 2);
        }
    }

    @Override
    public String getWarningForNavigatingFrom() {
        return null;
    }
}

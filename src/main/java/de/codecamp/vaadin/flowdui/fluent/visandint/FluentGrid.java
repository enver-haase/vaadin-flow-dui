package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.grid.CellFocusEvent;
import com.vaadin.flow.component.grid.ColumnReorderEvent;
import com.vaadin.flow.component.grid.ColumnResizeEvent;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridSortOrder;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.ItemClickEvent;
import com.vaadin.flow.component.grid.ItemDoubleClickEvent;
import com.vaadin.flow.component.grid.dnd.GridDragEndEvent;
import com.vaadin.flow.component.grid.dnd.GridDragStartEvent;
import com.vaadin.flow.component.grid.dnd.GridDropEvent;
import com.vaadin.flow.component.grid.dnd.GridDropMode;
import com.vaadin.flow.data.event.SortEvent;
import com.vaadin.flow.data.selection.SelectionListener;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentFocusable;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;
import de.codecamp.vaadin.flowdui.fluent.FluentHasThemeVariants;


public class FluentGrid<ITEM>
  extends FluentComponent<Grid<ITEM>, FluentGrid<ITEM>>
  implements
    FluentHasSize<Grid<ITEM>, FluentGrid<ITEM>>,
    FluentFocusable<Grid<ITEM>, FluentGrid<ITEM>>,
    FluentHasStyle<Grid<ITEM>, FluentGrid<ITEM>>,
    FluentHasTheme<Grid<ITEM>, FluentGrid<ITEM>>,
    FluentHasThemeVariants<Grid<ITEM>, FluentGrid<ITEM>, GridVariant>
{

  public FluentGrid()
  {
    super(new Grid<>());
  }

  public FluentGrid(Grid<ITEM> component)
  {
    super(component);
  }


  public FluentGrid<ITEM> pageSize(int pageSize)
  {
    get().setPageSize(pageSize);
    return this;
  }

  public FluentGrid<ITEM> columnReorderingAllowed(boolean columnReorderingAllowed)
  {
    get().setColumnReorderingAllowed(columnReorderingAllowed);
    return this;
  }

  public FluentGrid<ITEM> detailsVisibleOnClick(boolean detailsVisibleOnClick)
  {
    get().setDetailsVisibleOnClick(detailsVisibleOnClick);
    return this;
  }

  public FluentGrid<ITEM> multiSort(boolean multiSort)
  {
    get().setMultiSort(multiSort);
    return this;
  }

  public FluentGrid<ITEM> allRowsVisible(boolean allRowsVisible)
  {
    get().setAllRowsVisible(allRowsVisible);
    return this;
  }

  public FluentGrid<ITEM> verticalScrollingEnabled(boolean enabled)
  {
    get().setVerticalScrollingEnabled(enabled);
    return this;
  }

  public FluentGrid<ITEM> dropMode(GridDropMode dropMode)
  {
    get().setDropMode(dropMode);
    return this;
  }

  public FluentGrid<ITEM> rowsDraggable(boolean rowsDraggable)
  {
    get().setRowsDraggable(rowsDraggable);
    return this;
  }

  public FluentGrid<ITEM> onCellFocus(ComponentEventListener<CellFocusEvent<ITEM>> listener)
  {
    get().addCellFocusListener(listener);
    return this;
  }

  public FluentGrid<ITEM> onColumnReorder(ComponentEventListener<ColumnReorderEvent<ITEM>> listener)
  {
    get().addColumnReorderListener(listener);
    return this;
  }

  public FluentGrid<ITEM> onColumnResize(ComponentEventListener<ColumnResizeEvent<ITEM>> listener)
  {
    get().addColumnResizeListener(listener);
    return this;
  }

  public FluentGrid<ITEM> onDragStart(ComponentEventListener<GridDragStartEvent<ITEM>> listener)
  {
    get().addDragStartListener(listener);
    return this;
  }

  public FluentGrid<ITEM> onDragEnd(ComponentEventListener<GridDragEndEvent<ITEM>> listener)
  {
    get().addDragEndListener(listener);
    return this;
  }

  public FluentGrid<ITEM> onDrop(ComponentEventListener<GridDropEvent<ITEM>> listener)
  {
    get().addDropListener(listener);
    return this;
  }

  public FluentGrid<ITEM> onItemClick(ComponentEventListener<ItemClickEvent<ITEM>> listener)
  {
    get().addItemClickListener(listener);
    return this;
  }

  public FluentGrid<ITEM> onDoubleItemClick(
      ComponentEventListener<ItemDoubleClickEvent<ITEM>> listener)
  {
    get().addItemDoubleClickListener(listener);
    return this;
  }

  public FluentGrid<ITEM> onSelection(SelectionListener<Grid<ITEM>, ITEM> listener)
  {
    get().addSelectionListener(listener);
    return this;
  }

  public FluentGrid<ITEM> onSort(
      ComponentEventListener<SortEvent<Grid<ITEM>, GridSortOrder<ITEM>>> listener)
  {
    get().addSortListener(listener);
    return this;
  }


  @Override
  public FluentGrid<ITEM> addThemeVariants(GridVariant... variants)
  {
    get().addThemeVariants(variants);
    return this;
  }

  @Override
  public FluentGrid<ITEM> removeThemeVariants(GridVariant... variants)
  {
    get().removeThemeVariants(variants);
    return this;
  }

  public FluentGrid<ITEM> noBorder(boolean enabled)
  {
    return themeVariant(GridVariant.LUMO_NO_BORDER, enabled);
  }

  public FluentGrid<ITEM> rowBorders(boolean enabled)
  {
    return themeVariant(GridVariant.LUMO_NO_ROW_BORDERS, enabled);
  }

  public FluentGrid<ITEM> columnBorders(boolean enabled)
  {
    return themeVariant(GridVariant.LUMO_COLUMN_BORDERS, enabled);
  }

  public FluentGrid<ITEM> rowStripes(boolean enabled)
  {
    return themeVariant(GridVariant.LUMO_ROW_STRIPES, enabled);
  }

  public FluentGrid<ITEM> compact(boolean enabled)
  {
    return themeVariant(GridVariant.LUMO_COMPACT, enabled);
  }

  public FluentGrid<ITEM> wrapCellContent(boolean enabled)
  {
    return themeVariant(GridVariant.LUMO_WRAP_CELL_CONTENT, enabled);
  }

}

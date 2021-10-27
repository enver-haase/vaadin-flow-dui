package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.dnd.GridDropMode;

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

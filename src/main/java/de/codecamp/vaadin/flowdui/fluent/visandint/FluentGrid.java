package de.codecamp.vaadin.flowdui.fluent.visandint;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.dnd.GridDropMode;

import de.codecamp.vaadin.flowdui.fluent.FluentComponent;
import de.codecamp.vaadin.flowdui.fluent.FluentFocusable;
import de.codecamp.vaadin.flowdui.fluent.FluentHasSize;
import de.codecamp.vaadin.flowdui.fluent.FluentHasStyle;
import de.codecamp.vaadin.flowdui.fluent.FluentHasTheme;


public class FluentGrid<ITEM>
  extends FluentComponent<Grid<ITEM>, FluentGrid<ITEM>>
  implements
    FluentHasStyle<Grid<ITEM>, FluentGrid<ITEM>>,
    FluentHasSize<Grid<ITEM>, FluentGrid<ITEM>>,
    FluentFocusable<Grid<ITEM>, FluentGrid<ITEM>>,
    FluentHasTheme<Grid<ITEM>, FluentGrid<ITEM>>
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
    getComponent().setPageSize(pageSize);
    return this;
  }

  public FluentGrid<ITEM> columnReorderingAllowed(boolean columnReorderingAllowed)
  {
    getComponent().setColumnReorderingAllowed(columnReorderingAllowed);
    return this;
  }

  public FluentGrid<ITEM> detailsVisibleOnClick(boolean detailsVisibleOnClick)
  {
    getComponent().setDetailsVisibleOnClick(detailsVisibleOnClick);
    return this;
  }

  public FluentGrid<ITEM> multiSort(boolean multiSort)
  {
    getComponent().setMultiSort(multiSort);
    return this;
  }

  public FluentGrid<ITEM> heightByRows(boolean heightByRows)
  {
    getComponent().setHeightByRows(heightByRows);
    return this;
  }

  public FluentGrid<ITEM> verticalScrollingEnabled(boolean enabled)
  {
    getComponent().setVerticalScrollingEnabled(enabled);
    return this;
  }

  public FluentGrid<ITEM> dropMode(GridDropMode dropMode)
  {
    getComponent().setDropMode(dropMode);
    return this;
  }

  public FluentGrid<ITEM> rowsDraggable(boolean rowsDraggable)
  {
    getComponent().setRowsDraggable(rowsDraggable);
    return this;
  }


  public FluentGrid<ITEM> themeVariants(GridVariant... variants)
  {
    getComponent().removeThemeVariants(GridVariant.values());
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentGrid<ITEM> addThemeVariants(GridVariant... variants)
  {
    getComponent().addThemeVariants(variants);
    return this;
  }

  public FluentGrid<ITEM> removeThemeVariants(GridVariant... variants)
  {
    getComponent().removeThemeVariants(variants);
    return this;
  }

}

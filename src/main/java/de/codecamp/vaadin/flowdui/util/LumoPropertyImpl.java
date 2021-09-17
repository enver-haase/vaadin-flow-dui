package de.codecamp.vaadin.flowdui.util;

class LumoPropertyImpl
  implements
    LumoProperty
{

  private String name;


  LumoPropertyImpl(String name)
  {
    this.name = name;
  }


  @Override
  public String property()
  {
    return name;
  }

}

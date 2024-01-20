module func {
  exports func.method to ui, main;
  exports func.instances.admin to ui;
  exports func.instances.user to ui;
  exports func.instances.operator to ui;
  requires transitive dbase;
}

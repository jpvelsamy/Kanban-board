// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.vaadin.kanban.domain;

import java.lang.String;

privileged aspect StateColumn_Roo_ToString {
    
    public String StateColumn.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Editor: ").append(getEditor()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("WorkInProgressLimit: ").append(getWorkInProgressLimit()).append(", ");
        sb.append("SortOrder: ").append(getSortOrder()).append(", ");
        sb.append("DefinitionOfDone: ").append(getDefinitionOfDone());
        return sb.toString();
    }
    
}

package todo;

import jakarta.persistence.*;

@Entity
@Table(name = "todo_items")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=255)
    private String description;

    @Column(nullable=false)
    private boolean completed = false;

    public TodoItem() {}
    public TodoItem(String description) { this.description = description; }

    public Long getId() { return id; }
    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean c) { this.completed = c; }

    @Override
    public String toString() {
        return "[" + id + "] " + description + (completed ? " (done)" : "");
    }
}

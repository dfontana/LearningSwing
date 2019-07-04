# MouseToGraph

A simple program designed as a way to better understand the creation of Java-based GUIs. The app itself creates a visual graph data structure base on where the user clicks. The tolerance for creating an edge is adjustable in realtime.

The projects main intents were for an introduction into Java GUIs. Basic JPanel and JFrames were introduced. Graphics, paintComponents, and mouseListeners were other major learning curves for this project. As of now it is considered complete, as its purpose has been served.

<h5>Future ideas, however, remain:</h5>

- [ ] Add splash screen with prompt asking for a window size and giving instructions.
  - Let user pick from a list. Do common HD sizes from 480p to 1440p.
- [ ] Add option to right click a node to delete it.
  - Meaning you need to track what node to add next and since every node is an int that shouldn't be too hard.
  - Just set it on deletion/adding.
- [ ] Add option to determine if there is a path from one node to another?
  - Would mean adding a label, "Path from" and a JTextField
  - Another label "to", another JTextField - Another label "exists?" and a button "Find"
  - Finally, a label <TRUE/FALSE> to the bottom strip of the window.

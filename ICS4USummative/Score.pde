// Amrew
class Score {
  private String name;
  private int score;

  /*Score constructor
   pre: none
   post: none */
  Score() {
    name = "";
    score = 0;
  }

  /*score constructor with parameters
   pre: none
   post: none */
  Score(String name, int score) {
    this.name = name;
    this.score = score;
  }

  /*accessor for name
   pre: none
   post: none */
  String getPlayerName() {
    return name;
  }

  /*accessor for score
   pre: none
   post: none */
  int getScore() {
    return score;
  }

  /*mutator for name
   pre: none
   post: none */
  void setPlayerName(String name) {
    this.name = name;
  }

  /*mutator for score
   pre: none
   post: none */
  void setScore(int score) {
    this.score = score;
  }

  /*sets all house walls from the map to in-game obstacles
   pre: none
   post: none */
  String toString() {
    if (this.score == 1) {
      return this.name+"\t"+this.score+" second";
    } else {
      return this.name+"\t"+this.score+" seconds";
    }
  }
}

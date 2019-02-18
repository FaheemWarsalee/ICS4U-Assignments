// Amrew

class Stats {
  int atk;
  int hp;
  PImage img;

  /*Stats constructor base
   pre: none
   post: none */
  Stats() {
    atk = 100;
    hp = 100;
  }

  /*stats construcot with parameters
   pre: none
   post: none */
  Stats(int atk, int hp, PImage img) {
    this.atk = atk;
    this.hp = hp;
    this.img = img;
  }

  /*accessor for attack
   pre: none
   post: returns the attack integer */
  int getAtk() {
    return atk;
  }

  /*accessor for hp
   pre: none
   post: returns the hp  integer*/
  int getHp() {
    return hp;
  }

  /*mutator for attack
   pre: atk is positive
   post: none */
  void setAtk(int atk) {
    this.atk = atk;
  }

  /*mutator for hp
   pre: hp is positive
   post: none */
  void setHp(int hp) {
    this.hp = hp;
  }

  /*shows the attack and health bar
   pre: none
   post: none */
  void show() {
    image(img, 700, -30, 370, 250);
    textSize(13);
    fill(255);
    text("ATTACK: " + atk, 858, 27);
    fill(0);
    text("HEALTH: " + hp, 858, 90);
  }
}

package net.sourceforge.mochadoom.gamelogic;

import net.sourceforge.mochadoom.daycycle.Kronos;
import net.sourceforge.mochadoom.defines.StateNum;


public interface IMonster {

  /**
   * Devuelve verdadero si el mounstro es Vampiro
   * @return
   */
  boolean isVampire();

  /**
   * Devuelve verdadero si es hombre lobo
   * @return
   */
  boolean isWerewolf();

  /**
   * Devuelve verdadero si es hybrido
   * @return
   */
  boolean isHybrid();

  /**
   * Devuelve verdadero si es leecher
   * @return
   */
  boolean isLeecher();
  
  /**
   * Devuelve verdadero si es Ghoul
   * @return boolean
   */
  boolean isGhoul();

  /**
   * Getter para los flags de contaminacion
   * @return flags de contaminacion
   */
  int getContaminatedFlags();

  /**
   * Devuelve verdadero si el mounstro esta contaminado
   * @return boolean
   */
  boolean isContaminated();

  /**
   * Contamina el mounstro con un tipo de contaminacion
   * @param newContamination
   */
  void contaminate(int newContamination);

  /**
   * Devuelve el tiempo vivo del mounstro
   * @return tiempo vivo
   */
  int getTimeAlive();

  /**
   * Seter para el multiplicador del mounstro, mayor a 0
   * @param value
   */
  void setSpeedMult(int value);

  void checkSkin(Kronos kronos);

  /**
   * Devuelve el multiplicador de velocidad del monster
   * @return multiplicador
   */
  int getSpeedMult();

  /**
   * Calcula el multiplicador de la velocidad, dependiendo de la hora del dia
   * @param kronos
   * @return multiplicador
   */
  float getSpeedMultWithTime(Kronos kronos);
  
  /**
   * Calcula cuanto daño hace la plata.
   * @return multiplicador
   */
  float getSilverDamageMultiplier();
  
  /**
   * Devuelve verdadero si es resistente
   */
  boolean isResistant();
  
  /**
   * Calcula cuanto daño hacen las armas regulares
   * @return multiplicador
   */
  float getRegularDamageMultiplier();
  
  /**
   * Calcula cuanto daño hacen las armas no regulares:
   * Chainsaw, Holy Water
   * @return multiplicador
   */
  float getNonRegularDamageMultiplier();
  
  /**
   * @return true if it can contaminate other monsters.
   */
  boolean canContaminate();
  
  /**
   * @return true if it can fly.
   */
  boolean canFly();
  
}

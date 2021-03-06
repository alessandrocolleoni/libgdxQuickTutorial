package com.example.game.factory;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.example.game.entities.Enemy;
import com.example.game.entities.EnemyStats;
import com.example.game.entities.Player;

public class EnemyFactory {

	private ArrayList<EnemyStats> enemies;
	private EnemyFactory () {}
	
	/**
	 * Instantiate enemyFactory
	 * 
	 * @return EnemyFactory instance
	 */
	public static EnemyFactory instantiate() {
		return new Json().fromJson(EnemyFactory.class, Gdx.files.internal( "gameData/enemies.json"));
	}
	
	/**
	 * 
	 * Create an enemy to an (x,y) position 
	 * 
	 * @param id - stats id
	 * @param x - x position
	 * @param y - y position
	 * @param player - needed by enemy constructor
	 * @return
	 */
	public Enemy createEnemy(int id, float x, float y, Player player) {

		EnemyStats stats = enemies.get(id);
		// create an enemy with stats
		Enemy e = new Enemy(x, y, player, stats.ap, stats.hp);
		return e;
	}

}

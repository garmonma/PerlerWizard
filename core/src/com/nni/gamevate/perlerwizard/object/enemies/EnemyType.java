package com.nni.gamevate.perlerwizard.object.enemies;
public enum EnemyType{
		GoblinInitiate(3, 1.0),
		MountedLance(12, 1.5),
		Dragon(25, 2.5);
		
		private final double health;
		private final double attackSpeed;
		
		EnemyType(double health, double attackSpeed){
			this.health = health;
			this.attackSpeed = attackSpeed;
		}
		
		public double getHealth(){
			return health;
		}
		
		public double getAttackSpeed(){
			return attackSpeed;
		}
	}
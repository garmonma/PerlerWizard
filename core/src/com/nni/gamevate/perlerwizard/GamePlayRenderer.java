package com.nni.gamevate.perlerwizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.controllers.GamePlayController;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.network.gamedata.MatchResult;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.hero.BattleMage;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.hero.Knight;
import com.nni.gamevate.perlerwizard.object.hero.Wizard;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.defense.EnergyShield;
import com.nni.gamevate.perlerwizard.utils.GamePlayInputHandler;
import com.nni.gamevate.perlerwizard.utils.UIElement;
import com.nni.gamevate.perlerwizard.utils.ViewportUtils;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class GamePlayRenderer {

	private GamePlayController controller;
	private NetworkController networkController;
	private OrthographicCamera camera;
	private OrthographicCamera hudCamera;
	private Viewport viewport;
	private Viewport hudViewport;

	private ShapeRenderer shapeRenderer;
	private SpriteBatch batch;
	
	private BitmapFont font;
	private GamePlayInputHandler _inputHandler;
	
	private Hero _hero;
	
	private AssetManager assetManager;
	
	private Texture energyShieldBox;
	private Texture reflectBox;
	
	//Network Instances;
	private MatchResult matchResult;
	
	private boolean matchRendering;

	public GamePlayRenderer(GamePlayController controller, NetworkController networkController, SpriteBatch batch, AssetManager assetManager) {
		this.controller = controller;
		this.networkController = networkController;
		this.batch = batch;
		this.assetManager = assetManager;
		
		init();
	}
	
	private void init(){
		camera = new OrthographicCamera();

		_inputHandler = new GamePlayInputHandler(controller, camera);
		Gdx.input.setInputProcessor(_inputHandler.getSkillBarProcessor());

		viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);

		shapeRenderer = new ShapeRenderer();
		
		energyShieldBox = assetManager.get(AssetDescriptors.ENERGY_SHIELD_BOX);
		reflectBox = assetManager.get(AssetDescriptors.REFLECT_SKILL_BOX);
		
		batch = new SpriteBatch();
		//_batch.setProjectionMatrix(_camera.combined);

		//FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/blocky_font.TTF"));
		//FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		//int scale = generator.scaleToFitSquare(40, 40, 10);
		//Gdx.app.log("Font Scale", "" + scale);
		
		//_font = generator.generateFont(parameter);

		//generator.dispose();
		
		matchResult = new MatchResult();
		matchResult.character_id = networkController.getCharacterID();
		
		matchRendering = true;
		
		_hero = controller.getHero();

	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shapeRenderer.setProjectionMatrix(camera.combined);
		if(controller.getEnemies().size == 0){
			//Game Over - You won 
			
			matchResult.experience = 15;
			matchResult.gold = 25;
			matchResult.health = 3;
			matchResult.node = 1;
			matchResult.storyMode = false;
			networkController.sendMatchResult(matchResult);
			//Gdx.app.log("Match Result", "Sent");
			
			//How do I transition back to the World Map Screen;
			
			matchRendering = false;
		}  else {	
			ViewportUtils.drawGrid(viewport, shapeRenderer);
			drawGameBounds();
			drawSkillSlots();
			drawDefenseCastBox();
			drawSigilButton();
			drawHeroUIComponents();
	
			drawHero();
			drawEnemies();
			drawSpells();
			
		
		}
	}

	public void resize(int width, int height) {
		viewport.update(width, height, true);
		// hudViewport.update(width, height, true);
		// ViewportUtils.debugPixelPerUnit(viewport);
	}

	private void drawSkillSlots(){
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.GRAY);

		shapeRenderer.rect(
				controller.getSkillSlotFive().getX(),
				controller.getSkillSlotFive().getY(),
				controller.getSkillSlotFive().getWidth(),
				controller.getSkillSlotFive().getHeight()
		);

		shapeRenderer.setColor(Color.GREEN);
		shapeRenderer.rect(
				controller.getSkillSlotFour().getX(),
				controller.getSkillSlotFour().getY(),
				controller.getSkillSlotFour().getWidth(),
				controller.getSkillSlotFour().getHeight()
		);
		shapeRenderer.setColor(Color.YELLOW);
		shapeRenderer.rect(
				controller.getSkillSlotThree().getX(),
				controller.getSkillSlotThree().getY(),
				controller.getSkillSlotThree().getWidth(),
				controller.getSkillSlotThree().getHeight()
		);
		shapeRenderer.setColor(Color.BLUE);
		shapeRenderer.rect(
				controller.getSkillSlotTwo().getX(),
				controller.getSkillSlotTwo().getY(),
				controller.getSkillSlotTwo().getWidth(),
				controller.getSkillSlotTwo().getHeight()
		);
		shapeRenderer.setColor(Color.RED);
		shapeRenderer.rect(
				controller.getSkillSlotOne().getX(),
				controller.getSkillSlotOne().getY(),
				controller.getSkillSlotOne().getWidth(),
				controller.getSkillSlotOne().getHeight()
		);

		shapeRenderer.end();
		/////////////////////////////////////////////////////////////////
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(Color.WHITE);
		switch(controller.getSelectedSkill()){	
		case 5:
			shapeRenderer.rect(
					controller.getSkillSlotFive().getX(),
					controller.getSkillSlotFive().getY(),
					controller.getSkillSlotFive().getWidth(),
					controller.getSkillSlotFive().getHeight()
			);
			break;
		case 4:
			shapeRenderer.rect(
					controller.getSkillSlotFour().getX(),
					controller.getSkillSlotFour().getY(),
					controller.getSkillSlotFour().getWidth(),
					controller.getSkillSlotFour().getHeight()
			);
			break;
		case 3:
			shapeRenderer.rect(
					controller.getSkillSlotThree().getX(),
					controller.getSkillSlotThree().getY(),
					controller.getSkillSlotThree().getWidth(),
					controller.getSkillSlotThree().getHeight()
			);
			break;
		case 2:
			shapeRenderer.rect(
					controller.getSkillSlotTwo().getX(),
					controller.getSkillSlotTwo().getY(),
					controller.getSkillSlotTwo().getWidth(),
					controller.getSkillSlotTwo().getHeight()
			);
			break;
		case 1:
			shapeRenderer.rect(
					controller.getSkillSlotOne().getX(),
					controller.getSkillSlotOne().getY(),
					controller.getSkillSlotOne().getWidth(),
					controller.getSkillSlotOne().getHeight()
			);
			break;
			
		}
		
		shapeRenderer.end();
	}

	private void drawSigilButton() {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.CHARTREUSE);

		shapeRenderer.rect(
				controller.getSigilButton().getX(),
				controller.getSigilButton().getY(),
				controller.getSigilButton().getWidth(),
				controller.getSigilButton().getHeight()
		);

		shapeRenderer.end();
	}
	
	private void drawDefenseCastBox(){
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.GRAY);

		shapeRenderer.rect(
				controller.getDefenseCastBox().getX(),
				controller.getDefenseCastBox().getY(),
				controller.getDefenseCastBox().getWidth(),
				controller.getDefenseCastBox().getHeight()
		);

		shapeRenderer.end();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		if(_hero instanceof Wizard)
			batch.draw(energyShieldBox, 
					controller.getDefenseCastBox().getX(),
					controller.getDefenseCastBox().getY(),
					controller.getDefenseCastBox().getWidth(),
					controller.getDefenseCastBox().getHeight()
			);
		
		if(_hero instanceof BattleMage || _hero instanceof Knight){
			batch.draw(reflectBox, 
					controller.getDefenseCastBox().getX(),
					controller.getDefenseCastBox().getY(),
					controller.getDefenseCastBox().getWidth(),
					controller.getDefenseCastBox().getHeight()
			);
		}
		
		
		batch.end();
	}
	
	private void drawHeroUIComponents() {	
		UIElement node = controller.getHealthNode();
		float healthBarWidth = controller.getHero().getCurrentHealthPct() * node.getWidth() / 100;
		
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(Color.GREEN);
		shapeRenderer.rect(node.getX(), node.getY(), node.getWidth(), node.getHeight());
		shapeRenderer.end();
		
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.GREEN);
		shapeRenderer.rect(node.getX(), node.getY(), healthBarWidth, node.getHeight());
		shapeRenderer.end();
	}

	private void drawHero() {
		// Drawing hero
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(Color.BLUE);

		shapeRenderer.rect(controller.getHero().getX(), controller.getHero().getY(), 
				controller.getHero().getWidth(), controller.getHero().getHeight());

		shapeRenderer.end();
	}

	private void drawEnemies() {
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(Color.RED);
		
		for (Enemy enemy : controller.getEnemies()) {
			shapeRenderer.rect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());

		}

		shapeRenderer.end();
	}

	private void drawGameBounds() {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.SLATE);

		shapeRenderer.rectLine(controller.getLeftWall().getX(), controller.getLeftWall().getY(), controller.getLeftWall().getX(),
				controller.getLeftWall().getY() + controller.getLeftWall().getHeight(), controller.getLeftWall().getWidth());

		shapeRenderer.rectLine(controller.getRightWall().getX(), controller.getRightWall().getY(),
				controller.getRightWall().getX(), controller.getRightWall().getY() + controller.getRightWall().getHeight(),
				controller.getRightWall().getWidth());

		shapeRenderer.rectLine(controller.getUpperWall().getX(), controller.getUpperWall().getY(),
				controller.getUpperWall().getX() + controller.getUpperWall().getWidth(), controller.getUpperWall().getY(),
				controller.getUpperWall().getHeight());

		shapeRenderer.end();
	}

	private void drawSpells() {
		shapeRenderer.begin(ShapeType.Line);

		for (Skill skill : controller.getSkills()) {
			shapeRenderer.setColor(Color.WHITE);
			
			if( skill instanceof EnergyShield){
				shapeRenderer.rect(skill.getX(), 
						skill.getY(), 
						skill.getWidth(),
						skill.getHeight());
			} else {
				shapeRenderer.ellipse(skill.getX(), 
							skill.getY(), 
							skill.getWidth(),
							skill.getHeight());
			}
		}

		shapeRenderer.end();
	}
	
	
	private void drawWizardUI(){
		
	}
	
	private void drawBattleMageUI(){
			
	}
	
	private void drawKnightUI(){
		
	}
	
	public boolean isMatchRendering(){
		return matchRendering;
	}
}
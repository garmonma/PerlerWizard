package com.nni.gamevate.perlerwizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
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

	private GamePlayController _controller;
	private NetworkController _networkController;
	private OrthographicCamera _camera;
	private OrthographicCamera _hudCamera;
	private Viewport _viewport;
	private Viewport _hudViewport;

	private ShapeRenderer _shapeRenderer;
	private SpriteBatch _batch;
	
	private BitmapFont _font;
	private GamePlayInputHandler _inputHandler;
	
	private Hero _hero;
	
	private AssetManager _assetManager;
	
	private Texture _energyShieldBox;
	private Texture _reflectBox;
	
	//Network Instances;
	private MatchResult _matchResult;
	
	private boolean _matchRendering;

	public GamePlayRenderer(GamePlayController controller, NetworkController networkController, SpriteBatch batch, AssetManager assetManager) {
		_controller = controller;
		_networkController = networkController;
		_batch = batch;
		_assetManager = assetManager;
		
		init();
	}
	
	private void init(){
		_camera = new OrthographicCamera();

		_inputHandler = new GamePlayInputHandler(_controller, _camera);
		Gdx.input.setInputProcessor(_inputHandler.getSkillBarProcessor());

		_viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, _camera);

		_shapeRenderer = new ShapeRenderer();
		
		_energyShieldBox = _assetManager.get(AssetDescriptors.ENERGY_SHIELD_BOX);
		_reflectBox = _assetManager.get(AssetDescriptors.REFLECT_SKILL_BOX);
		
		_batch = new SpriteBatch();
		//_batch.setProjectionMatrix(_camera.combined);

		//FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/blocky_font.TTF"));
		//FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		//int scale = generator.scaleToFitSquare(40, 40, 10);
		//Gdx.app.log("Font Scale", "" + scale);
		
		//_font = generator.generateFont(parameter);

		//generator.dispose();
		
		_matchResult = new MatchResult();
		_matchResult.character_id = _networkController.getCharacterID();
		
		_matchRendering = true;
		
		_hero = _controller.getHero();

	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		_shapeRenderer.setProjectionMatrix(_camera.combined);
		if(_controller.getEnemies().size == 0){
			//Game Over - You won 
			
			_matchResult.experience = 15;
			_matchResult.gold = 25;
			_matchResult.health = 3;
			_matchResult.node = 1;
			_matchResult.storyMode = false;
			_networkController.sendMatchResult(_matchResult);
			//Gdx.app.log("Match Result", "Sent");
			
			//How do I transition back to the World Map Screen;
			
			_matchRendering = false;
		}  else {	
			ViewportUtils.drawGrid(_viewport, _shapeRenderer);
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
		_viewport.update(width, height, true);
		// hudViewport.update(width, height, true);
		// ViewportUtils.debugPixelPerUnit(viewport);
	}

	private void drawSkillSlots(){
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.GRAY);

		_shapeRenderer.rect(
				_controller.getSkillSlotFive().getX(),
				_controller.getSkillSlotFive().getY(),
				_controller.getSkillSlotFive().getWidth(),
				_controller.getSkillSlotFive().getHeight()
		);

		_shapeRenderer.setColor(Color.GREEN);
		_shapeRenderer.rect(
				_controller.getSkillSlotFour().getX(),
				_controller.getSkillSlotFour().getY(),
				_controller.getSkillSlotFour().getWidth(),
				_controller.getSkillSlotFour().getHeight()
		);
		_shapeRenderer.setColor(Color.YELLOW);
		_shapeRenderer.rect(
				_controller.getSkillSlotThree().getX(),
				_controller.getSkillSlotThree().getY(),
				_controller.getSkillSlotThree().getWidth(),
				_controller.getSkillSlotThree().getHeight()
		);
		_shapeRenderer.setColor(Color.BLUE);
		_shapeRenderer.rect(
				_controller.getSkillSlotTwo().getX(),
				_controller.getSkillSlotTwo().getY(),
				_controller.getSkillSlotTwo().getWidth(),
				_controller.getSkillSlotTwo().getHeight()
		);
		_shapeRenderer.setColor(Color.RED);
		_shapeRenderer.rect(
				_controller.getSkillSlotOne().getX(),
				_controller.getSkillSlotOne().getY(),
				_controller.getSkillSlotOne().getWidth(),
				_controller.getSkillSlotOne().getHeight()
		);

		_shapeRenderer.end();
		/////////////////////////////////////////////////////////////////
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(Color.WHITE);
		switch(_controller.getSelectedSkill()){	
		case 5:
			_shapeRenderer.rect(
					_controller.getSkillSlotFive().getX(),
					_controller.getSkillSlotFive().getY(),
					_controller.getSkillSlotFive().getWidth(),
					_controller.getSkillSlotFive().getHeight()
			);
			break;
		case 4:
			_shapeRenderer.rect(
					_controller.getSkillSlotFour().getX(),
					_controller.getSkillSlotFour().getY(),
					_controller.getSkillSlotFour().getWidth(),
					_controller.getSkillSlotFour().getHeight()
			);
			break;
		case 3:
			_shapeRenderer.rect(
					_controller.getSkillSlotThree().getX(),
					_controller.getSkillSlotThree().getY(),
					_controller.getSkillSlotThree().getWidth(),
					_controller.getSkillSlotThree().getHeight()
			);
			break;
		case 2:
			_shapeRenderer.rect(
					_controller.getSkillSlotTwo().getX(),
					_controller.getSkillSlotTwo().getY(),
					_controller.getSkillSlotTwo().getWidth(),
					_controller.getSkillSlotTwo().getHeight()
			);
			break;
		case 1:
			_shapeRenderer.rect(
					_controller.getSkillSlotOne().getX(),
					_controller.getSkillSlotOne().getY(),
					_controller.getSkillSlotOne().getWidth(),
					_controller.getSkillSlotOne().getHeight()
			);
			break;
			
		}
		
		_shapeRenderer.end();
	}

	private void drawSigilButton() {
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.CHARTREUSE);

		_shapeRenderer.rect(
				_controller.getSigilButton().getX(),
				_controller.getSigilButton().getY(),
				_controller.getSigilButton().getWidth(),
				_controller.getSigilButton().getHeight()
		);

		_shapeRenderer.end();
	}
	
	private void drawDefenseCastBox(){
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.GRAY);

		_shapeRenderer.rect(
				_controller.getDefenseCastBox().getX(),
				_controller.getDefenseCastBox().getY(),
				_controller.getDefenseCastBox().getWidth(),
				_controller.getDefenseCastBox().getHeight()
		);

		_shapeRenderer.end();
		
		_batch.setProjectionMatrix(_camera.combined);
		_batch.begin();
		
		if(_hero instanceof Wizard)
			_batch.draw(_energyShieldBox, 
					_controller.getDefenseCastBox().getX(),
					_controller.getDefenseCastBox().getY(),
					_controller.getDefenseCastBox().getWidth(),
					_controller.getDefenseCastBox().getHeight()
			);
		
		if(_hero instanceof BattleMage || _hero instanceof Knight){
			_batch.draw(_reflectBox, 
					_controller.getDefenseCastBox().getX(),
					_controller.getDefenseCastBox().getY(),
					_controller.getDefenseCastBox().getWidth(),
					_controller.getDefenseCastBox().getHeight()
			);
		}
		
		
		_batch.end();
	}
	
	private void drawHeroUIComponents() {	
		UIElement node = _controller.getHealthNode();
		float healthBarWidth = _controller.getHero().getCurrentHealthPct() * node.getWidth() / 100;
		
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(Color.GREEN);
		_shapeRenderer.rect(node.getX(), node.getY(), node.getWidth(), node.getHeight());
		_shapeRenderer.end();
		
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.GREEN);
		_shapeRenderer.rect(node.getX(), node.getY(), healthBarWidth, node.getHeight());
		_shapeRenderer.end();
	}

	private void drawHero() {
		// Drawing hero
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(Color.BLUE);

		_shapeRenderer.rect(_controller.getHero().getX(), _controller.getHero().getY(), 
				_controller.getHero().getWidth(), _controller.getHero().getHeight());

		_shapeRenderer.end();
	}

	private void drawEnemies() {
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(Color.RED);
		
		for (Enemy enemy : _controller.getEnemies()) {
			_shapeRenderer.rect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());

		}

		_shapeRenderer.end();
	}

	private void drawGameBounds() {
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.SLATE);

		_shapeRenderer.rectLine(_controller.getLeftWall().getX(), _controller.getLeftWall().getY(), _controller.getLeftWall().getX(),
				_controller.getLeftWall().getY() + _controller.getLeftWall().getHeight(), _controller.getLeftWall().getWidth());

		_shapeRenderer.rectLine(_controller.getRightWall().getX(), _controller.getRightWall().getY(),
				_controller.getRightWall().getX(), _controller.getRightWall().getY() + _controller.getRightWall().getHeight(),
				_controller.getRightWall().getWidth());

		_shapeRenderer.rectLine(_controller.getUpperWall().getX(), _controller.getUpperWall().getY(),
				_controller.getUpperWall().getX() + _controller.getUpperWall().getWidth(), _controller.getUpperWall().getY(),
				_controller.getUpperWall().getHeight());

		_shapeRenderer.end();
	}

	private void drawSpells() {
		_shapeRenderer.begin(ShapeType.Line);

		for (Skill skill : _controller.getSkills()) {
			_shapeRenderer.setColor(Color.WHITE);
			
			if( skill instanceof EnergyShield){
				_shapeRenderer.rect(skill.getX(), 
						skill.getY(), 
						skill.getWidth(),
						skill.getHeight());
			} else {
				_shapeRenderer.ellipse(skill.getX(), 
							skill.getY(), 
							skill.getWidth(),
							skill.getHeight());
			}
		}

		_shapeRenderer.end();
	}
	
	
	private void drawWizardUI(){
		
	}
	
	private void drawBattleMageUI(){
			
	}
	
	private void drawKnightUI(){
		
	}
	
	public boolean isMatchRendering(){
		return _matchRendering;
	}
}
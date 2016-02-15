package com.eogames.john.level;

import com.badlogic.gdx.assets.AssetManager;
import com.eogames.john.camera.LevelCamera;
import com.eogames.john.map.JohnMapRenderer;
import com.eogames.john.utils.CameraUtils;

/**
 * This class is the base class for every levels. You cannot create a level without extending
 * this class.
 */
public abstract class BaseLevel {
  protected AssetManager assetManager;
  protected JohnMapRenderer renderer;
  protected LevelCamera camera;

  public BaseLevel(AssetManager assetManager) {
    this.assetManager = assetManager;
  }

  protected void setCamera(float startingLevelY) {
    camera = new LevelCamera();
    camera.setToOrtho(false, CameraUtils.VIEWPORTWIDTH, CameraUtils.VIEWPORTHEIGHT);
    camera.position.set(CameraUtils.VIEWPORTWIDTH / 2, startingLevelY, 0);
    camera.update();
  }

  protected abstract void loadLevel();

  /**
   * You have to call this super method at the end of the level render() implementation.
   */
  public void render() {
    camera.update();
    renderer.setView(camera);
    renderer.render();
  }
}

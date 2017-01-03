package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by harit on 10/20/2016.
 */
public class WorldRenderer {
    DemoGame demoGame;
    World world;
    SpriteBatch batch;
    float elapsedTime;
    private BitmapFont font;
    private BitmapFont button;
    private BitmapFont healt;
    private BitmapFont point;
    Array<Rectangle> stickmanArray;
    Array<Swordman> swordmanArray;
    Array<Swordman> swordmanOverlapArray;
    Array<Zombie> zombieOverlapArray;
    Array<Zombie> zombieArray;
    Array<Skeleton> skeletonOverlapArray;
    Array<Skeleton> skeletonArray;
    Array<Golem> golemArray;
    Array<Golem> golemOverlapArray;
    Array<Lancer> lancerArray;
    Array<Lancer> lancerOverlapArray;
    Array<Gunner> gunnerArray;
    Array<Gunner> gunnerOverlapArray;
    Array<Robot> robotArray;
    Array<Robot> robotOverlapArray;
    int GameTime;
    int money;
    int timer;
    int hp;
    Array<Rectangle> stickman;
    Rectangle pos;
    int zombieTime;
    int skeletonTime;
    int golemTime;
    Texture background;
    Texture win;
    Texture lose;
    ShapeRenderer shapeRenderer;
    OrthographicCamera camera;
    int RUN = 0;
    int ATTACK = 1;
    int DIE =3;
    Texture Chareacter_Selected;


    WorldRenderer(DemoGame demoGame, World world) {
        camera = new OrthographicCamera();
        shapeRenderer = new ShapeRenderer();
        stickman = new Array<Rectangle>();
        //zombie = new Array<Rectangle>();
        zombieArray = new Array<Zombie>();
        swordmanArray = new Array<Swordman>();
        swordmanOverlapArray = new Array<Swordman>();
        zombieOverlapArray = new Array<Zombie>();
        lancerArray = new Array<Lancer>();
        lancerOverlapArray = new Array<Lancer>();
        gunnerArray = new Array<Gunner>();
        gunnerOverlapArray = new Array<Gunner>();
        skeletonArray = new Array<Skeleton>();
        skeletonOverlapArray = new Array<Skeleton>();
        robotArray = new Array<Robot>();
        robotOverlapArray = new Array<Robot>();
        golemArray = new Array<Golem>();
        golemOverlapArray = new Array<Golem>();
        this.demoGame = demoGame;
        batch = demoGame.batch;
        this.world = world;
        font = new BitmapFont();
        healt = new BitmapFont();
        button = new BitmapFont();
        button.setColor(Color.RED);
        point = new BitmapFont();
        point.setColor(Color.RED);
        healt.setColor(Color.RED);
        font.getData().setScale(2);
        healt.getData().setScale(2);
        stickmanArray = new Array<Rectangle>();
        // ZombieArray = new Array<Rectangle>();
        hp=1000;
        money = 0;
        timer = 0;
        zombieTime = 0;
        skeletonTime =0;
        golemTime = 0;
        GameTime = 0;
        background = new Texture("BG (2).png");
        win = new Texture("win&lose/win.png");
        lose = new Texture("win&lose/lose.png");
        Chareacter_Selected = new Texture("Chracter_selected.png");
    }


    public void returnSwordman(Swordman rc) {
        swordmanOverlapArray.add(rc);
    }

    public void returnZombie(Zombie rc) {
        zombieOverlapArray.add(rc);
    }

    public void returnSkeleton(Skeleton rc){
        skeletonOverlapArray.add(rc);
    }

    public void returnLancer(Lancer rc) {
        lancerOverlapArray.add(rc);
    }

    public void returnGunner(Gunner rc){;
        gunnerOverlapArray.add(rc);
    }

     public void returnRobot(Robot rc)
     {
         robotOverlapArray.add(rc);
     }

     public void returnGolem(Golem rc)
     {
         golemOverlapArray.add(rc);
     }

    public void render(float delta, int status) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        pos = world.getStickman().getPosition();
        batch.begin();
        //batch.draw(world.getStickman().Status(status).getKeyFrame(elapsedTime, true), pos.x, pos.y);
        batch.draw(background, 0, 0);
        batch.draw(Chareacter_Selected,100,50);
        button.draw(batch, "Q                      W                      E                      R", 100, 148);
        point.draw(batch,"50                    100                    150                  200", 100, 64);
        healt.draw(batch,"Healt : "+hp,215,690);
        for (Swordman swordman : swordmanArray) {
            returnSwordman(swordman);
            batch.draw(swordman.getSwordmanAnimation().getKeyFrame(elapsedTime, true), swordman.getRectangle().x, swordman.getRectangle().y, 128, 128);
        }

        for (Zombie zombie : zombieArray) {
            returnZombie(zombie);
            batch.draw(zombie.getZombieAnimation().getKeyFrame(elapsedTime, true), zombie.getRectangle().x, zombie.getRectangle().y, 80, 110);
        }

        for (Golem golem : golemArray) {
            returnGolem(golem);
            batch.draw(golem.getGolemAnimation().getKeyFrame(elapsedTime, true), golem.getRectangle().x, golem.getRectangle().y, 150, 140);
        }

        for (Skeleton skeleton : skeletonArray) {
            returnSkeleton(skeleton);
            if(skeleton.getSkeletonAnimation() == skeleton.attackAnimation){
                batch.draw(skeleton.getSkeletonAnimation().getKeyFrame(elapsedTime, true), skeleton.getRectangle().x, skeleton.getRectangle().y, 120, 110);
            }else {
                batch.draw(skeleton.getSkeletonAnimation().getKeyFrame(elapsedTime, true), skeleton.getRectangle().x, skeleton.getRectangle().y, 80, 110);
            }
        }

        for (Lancer lancer : lancerArray) {
            returnLancer(lancer);
            if (lancer.getLancerAnimation() == lancer.attackAnimation) {
                batch.draw(lancer.getLancerAnimation().getKeyFrame(elapsedTime, true), lancer.getRectangle().x, lancer.getRectangle().y, 135, 135);
            } else {
                batch.draw(lancer.getLancerAnimation().getKeyFrame(elapsedTime, true), lancer.getRectangle().x, lancer.getRectangle().y, 100, 128);
            }
        }

        for (Gunner gunner : gunnerArray) {
            returnGunner(gunner);
            batch.draw(gunner.getGunnerAnimation().getKeyFrame(elapsedTime, true), gunner.getRectangle().x, gunner.getRectangle().y, 128, 128);
        }

        for (Robot robot : robotArray) {
            returnRobot(robot);
            batch.draw(robot.getRobotAnimation().getKeyFrame(elapsedTime, true), robot.getRectangle().x, robot.getRectangle().y, 128, 128);
        }
        font.draw(batch, "Money : " + money, 50, 690);
        if(GameTime >7100)
        {
            batch.draw(win, 360, 200);
        }
        if(hp<=0)
        {
            hp=0;
            batch.draw(lose,390,240);
        }
        batch.end();
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            if (money > 50) {
                spawnSwordman();
                money -= 50;
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            if (money > 100) {
                spawnGunner();
                money -= 100;
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
            if (money > 150) {
                spawnLancer();
                money -= 150;
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            if (money > 200) {
                spawnRobot();
                money -= 200;
            }
        }

        update();
    }

    private void update() {
        swordmanUpdate();
        swordmanOverlapUpdate();
        lancerUpdate();
        lancerOverlapUpdate();
        gunnerUpdate();
        gunnerOverlapUpdate();
        robotUpdate();
        robotOverlapUpdate();
        zombieUpdate();
        zombieOverlapUpdate();
        skeletonUpdate();
        skeletonOverlapUpdate();
        golemUpdate();
        golemOverlapUpdate();
        timeUpdate();
    }

    float distance1 = -500;
    float distance2 = 0;

    private void swordmanUpdate() {
        Iterator<Swordman> iter = swordmanArray.iterator();
        while (iter.hasNext()) {
            Swordman swordman = iter.next();
            try {
                for (int i = 0; i < 20; i++) {
                   if (swordman.getRectangle().overlaps(zombieOverlapArray.get(i).getRectangle())) {
                        swordman.getRectangle().x -= 120 * Gdx.graphics.getDeltaTime();
                        distance1 = swordman.getRectangle().x;
                        zombieOverlapArray.get(i).HP--;
                    }else
                        if(swordman.getRectangle().overlaps(skeletonOverlapArray.get(i).getRectangle())){
                            swordman.getRectangle().x -= 120 * Gdx.graphics.getDeltaTime();
                            distance1 = swordman.getRectangle().x;
                            skeletonOverlapArray.get(i).HP--;
                        }else
                        if(swordman.getRectangle().overlaps(golemOverlapArray.get(i).getRectangle())){
                            swordman.getRectangle().x -= 120 * Gdx.graphics.getDeltaTime();
                            distance1 = swordman.getRectangle().x;
                            golemOverlapArray.get(i).HP--;
                        }

                }
            } catch (IndexOutOfBoundsException s) {

            }
            swordman.getRectangle().x += 120 * Gdx.graphics.getDeltaTime();
            distance2 = swordman.getRectangle().x;
            if (distance2 - distance1 < 3) {
                swordman.changeAnimation(ATTACK);
            } else {
                swordman.changeAnimation(RUN);
            }
            distance1 = -500;
            if (swordman.getHP() < 0) {
                iter.remove();
            }
            if (swordman.getRectangle().x > 1280) {
                iter.remove();
            }
        }
    }

    float distanceLancer1 = -500;
    float distanceLancer2 = 0;

    private void lancerUpdate() {
        Iterator<Lancer> iter = lancerArray.iterator();
        while (iter.hasNext()) {
            Lancer lancer = iter.next();
            try {
                for (int i = 0; i < 20; i++) {
                    if (lancer.getRectangle().overlaps(zombieOverlapArray.get(i).getRectangle())) {
                        lancer.getRectangle().x -= 200 * Gdx.graphics.getDeltaTime();
                        lancer.HP--;
                        distanceLancer1 = lancer.getRectangle().x;
                        zombieOverlapArray.get(i).getRectangle().x += 100 * Gdx.graphics.getDeltaTime();
                        zombieOverlapArray.get(i).HP-=2;
                    }else
                        if (lancer.getRectangle().overlaps(skeletonOverlapArray.get(i).getRectangle())){
                            lancer.getRectangle().x -= 200 * Gdx.graphics.getDeltaTime();
                            lancer.HP--;
                            distanceLancer1 = lancer.getRectangle().x;
                            skeletonOverlapArray.get(i).getRectangle().x += 100 * Gdx.graphics.getDeltaTime();
                            skeletonOverlapArray.get(i).HP-=2;
                    }
                        else
                        if (lancer.getRectangle().overlaps(golemOverlapArray.get(i).getRectangle())){
                            lancer.getRectangle().x -= 200 * Gdx.graphics.getDeltaTime();
                            lancer.HP-=2;
                            distanceLancer1 = lancer.getRectangle().x;
                            golemOverlapArray.get(i).getRectangle().x += 80 * Gdx.graphics.getDeltaTime();
                            golemOverlapArray.get(i).HP-=2;
                        }
                }
            } catch (IndexOutOfBoundsException s) {

            }
            lancer.getRectangle().x += 200 * Gdx.graphics.getDeltaTime();
            distanceLancer2 = lancer.getRectangle().x;
            if (distanceLancer2 - distanceLancer1 < 10) {
                lancer.changeAnimation(ATTACK);
            } else {
                lancer.changeAnimation(RUN);
            }
            distanceLancer1 = -500;
            if (lancer.getHP() < 0) {
                iter.remove();
            }
            if (lancer.getRectangle().x > 1280) {
                iter.remove();
            }
        }
    }

    float distanceGunner1 = -500;
    float distanceGunner2 = 0;

    private void gunnerUpdate() {
        Iterator<Gunner> iter_gunner = gunnerArray.iterator();
        while (iter_gunner.hasNext()) {
            Gunner gunner = iter_gunner.next();
            try {
                for (int i = 0; i < 20; i++) {
                    if (gunner.getRectangle().overlaps(zombieOverlapArray.get(i).getRectangle())) {
                        gunner.getRectangle().x -= 100 * Gdx.graphics.getDeltaTime();
                        gunner.HP--;
                        distanceGunner1 = gunner.getRectangle().x;
                        zombieOverlapArray.get(i).getRectangle().x += 100 * Gdx.graphics.getDeltaTime();
                        zombieOverlapArray.get(i).HP-=3;
                    }else
                    if (gunner.getRectangle().overlaps(skeletonOverlapArray.get(i).getRectangle())){
                        gunner.getRectangle().x -= 100 * Gdx.graphics.getDeltaTime();
                        gunner.HP--;
                        distanceGunner1 = gunner.getRectangle().x;
                        skeletonOverlapArray.get(i).getRectangle().x += 100 * Gdx.graphics.getDeltaTime();
                        skeletonOverlapArray.get(i).HP-=3;
                    }else
                    if (gunner.getRectangle().overlaps(golemOverlapArray.get(i).getRectangle())){
                        gunner.getRectangle().x -= 100 * Gdx.graphics.getDeltaTime();
                        gunner.HP-=2;
                        distanceGunner1 = gunner.getRectangle().x;
                        golemOverlapArray.get(i).getRectangle().x += 80 * Gdx.graphics.getDeltaTime();
                        golemOverlapArray.get(i).HP-=3;
                    }
                }
            } catch (IndexOutOfBoundsException s) {

            }
            gunner.getRectangle().x += 100 * Gdx.graphics.getDeltaTime();
            distanceGunner2 = gunner.getRectangle().x;
            if (distanceGunner2 - distanceGunner1 < 10) {
                gunner.changeAnimation(ATTACK);
            } else {
                gunner.changeAnimation(RUN);
            }
            distanceGunner1 = -500;
            if (gunner.getHP() < 0) {
                iter_gunner.remove();
            }
            if (gunner.getRectangle().x > 1280) {
                iter_gunner.remove();
            }
        }
    }

    float distanceRobot1 = -500;
    float distanceRobot2 = 0;

    private void robotUpdate() {
        Iterator<Robot> iter_robot = robotArray.iterator();
        while (iter_robot.hasNext()) {
            Robot robot = iter_robot.next();
            try {
                for (int i = 0; i < 20; i++) {
                    if (robot.getRectangle().overlaps(zombieOverlapArray.get(i).getRectangle())) {
                        robot.getRectangle().x -= 100 * Gdx.graphics.getDeltaTime();
                        robot.HP--;
                        distanceRobot1 = robot.getRectangle().x;
                        zombieOverlapArray.get(i).getRectangle().x += 100 * Gdx.graphics.getDeltaTime();
                        zombieOverlapArray.get(i).HP-=4;
                    }else
                    if (robot.getRectangle().overlaps(skeletonOverlapArray.get(i).getRectangle())){
                        robot.getRectangle().x -= 100 * Gdx.graphics.getDeltaTime();
                        robot.HP--;
                        distanceRobot1 = robot.getRectangle().x;
                        skeletonOverlapArray.get(i).getRectangle().x += 100 * Gdx.graphics.getDeltaTime();
                        skeletonOverlapArray.get(i).HP-=4;
                    }else
                    if (robot.getRectangle().overlaps(golemOverlapArray.get(i).getRectangle())){
                        robot.getRectangle().x -= 100 * Gdx.graphics.getDeltaTime();
                        robot.HP-=2;
                        distanceRobot1 = robot.getRectangle().x;
                        golemOverlapArray.get(i).getRectangle().x += 80 * Gdx.graphics.getDeltaTime();
                        golemOverlapArray.get(i).HP-=4;
                    }
                }
            } catch (IndexOutOfBoundsException s) {

            }
            robot.getRectangle().x += 100 * Gdx.graphics.getDeltaTime();
            distanceRobot2 = robot.getRectangle().x;
            if (distanceRobot2 - distanceRobot1 < 10) {
                robot.changeAnimation(ATTACK);
            } else {
                robot.changeAnimation(RUN);
            }
            distanceRobot1 = -500;
            if (robot.getHP() < 0) {
                iter_robot.remove();
            }
            if (robot.getRectangle().x > 1280) {
                iter_robot.remove();
            }
        }
    }

    private void swordmanOverlapUpdate() {
        Iterator<Swordman> iter_swordOverlap = swordmanOverlapArray.iterator();
        while (iter_swordOverlap.hasNext()) {
            Swordman swordmanOverlap = iter_swordOverlap.next();
            // System.out.println("Overlap = "+swordmanOverlap.getHP());
            if (swordmanOverlap.getHP() < 0) {
                iter_swordOverlap.remove();
            }
        }
    }

    private void lancerOverlapUpdate() {
        Iterator<Lancer> iter_lancerOverlap = lancerOverlapArray.iterator();
        while (iter_lancerOverlap.hasNext()) {
            Lancer lancerOverlap = iter_lancerOverlap.next();
            if (lancerOverlap.getHP() < 0) {
                iter_lancerOverlap.remove();
            }
        }
    }

    private void gunnerOverlapUpdate() {
        Iterator<Gunner> iter_gunnerOverlap = gunnerOverlapArray.iterator();
        while (iter_gunnerOverlap.hasNext()) {
            Gunner gunnerOverlap = iter_gunnerOverlap.next();
            // System.out.println("Overlap = "+swordmanOverlap.getHP());
            if (gunnerOverlap.getHP() < 0) {
                iter_gunnerOverlap.remove();
            }
        }
    }

    private void robotOverlapUpdate() {
        Iterator<Robot> iter_robotOverlap = robotOverlapArray.iterator();
        while (iter_robotOverlap.hasNext()) {
            Robot robotOverlap = iter_robotOverlap.next();
            // System.out.println("Overlap = "+swordmanOverlap.getHP());
            if (robotOverlap.getHP() < 0) {
                iter_robotOverlap.remove();
            }
        }
    }

    private void zombieOverlapUpdate() {
        Iterator<Zombie> iter_zombieOverlap = zombieOverlapArray.iterator();
        while (iter_zombieOverlap.hasNext()) {
            Zombie zombieOverlap = iter_zombieOverlap.next();
            //System.out.println("Overlap = "+zombieOverlap.getHP());
            if (zombieOverlap.getHP() < 0) {
                iter_zombieOverlap.remove();
            }
            if (zombieOverlap.getRectangle().x < 0) {
                iter_zombieOverlap.remove();
            }
        }
    }

    private void skeletonOverlapUpdate() {
        Iterator<Skeleton> iter_skeletonOverlap = skeletonOverlapArray.iterator();
        while (iter_skeletonOverlap.hasNext()) {
            Skeleton skeletonOverlap = iter_skeletonOverlap.next();
            if (skeletonOverlap.getHP() < 0) {
                iter_skeletonOverlap.remove();
            }
            if (skeletonOverlap.getRectangle().x < 0) {
                iter_skeletonOverlap.remove();
            }
        }
    }

    private void golemOverlapUpdate() {
        Iterator<Golem> iter_golemOverlap = golemOverlapArray.iterator();
        while (iter_golemOverlap.hasNext()) {
            Golem golemOverlap = iter_golemOverlap.next();
            if (golemOverlap.getHP() < 0) {
                iter_golemOverlap.remove();
            }
            if (golemOverlap.getRectangle().x < 0) {
                iter_golemOverlap.remove();
            }
        }
    }

    private void zombieUpdate() {
        Iterator<Zombie> iter_zombie = zombieArray.iterator();
        while (iter_zombie.hasNext()) {
            Zombie zombie = iter_zombie.next();
            try {
                //for (int i = 0; i < swordmanOverlapArray.size; i++) {
                for (int i = 0; i < 20; i++) {
                    if (zombie.getRectangle().overlaps(swordmanOverlapArray.get(i).getRectangle())) {
                        zombie.getRectangle().x += 100 * Gdx.graphics.getDeltaTime();
                        swordmanOverlapArray.get(i).HP--;
                    }
                }
            } catch (IndexOutOfBoundsException s) {

            }

            zombie.getRectangle().x -= 100 * Gdx.graphics.getDeltaTime();

            if (zombie.getHP() < 0) {
                zombie.changeAnimation(DIE);
                zombie.getRectangle().x += 100 * Gdx.graphics.getDeltaTime();
                zombie.HP--;
                //iter_zombie.remove();
            }
            if (zombie.getHP() < -40){
                iter_zombie.remove();
            }

            if (zombie.getRectangle().x < 0) {
                hp-=100;
                iter_zombie.remove();
            }
        }
    }

    private void skeletonUpdate() {
        Iterator<Skeleton> iter_skeleton = skeletonArray.iterator();
        while (iter_skeleton.hasNext()) {
            Skeleton skeleton = iter_skeleton.next();
            try {
                //for (int i = 0; i < swordmanOverlapArray.size; i++) {
                for (int i = 0; i < 20; i++) {
                    if (skeleton.getRectangle().overlaps(swordmanOverlapArray.get(i).getRectangle())) {
                        skeleton.getRectangle().x += 100 * Gdx.graphics.getDeltaTime();
                        swordmanOverlapArray.get(i).HP--;
                    }
                }
            } catch (IndexOutOfBoundsException s) {

            }

            skeleton.getRectangle().x -= 100 * Gdx.graphics.getDeltaTime();

            if (skeleton.getHP() < 0) {
                skeleton.changeAnimation(DIE);
                skeleton.getRectangle().x += 100 * Gdx.graphics.getDeltaTime();
                skeleton.HP--;
            }

            if (skeleton.getHP() < -40){
                iter_skeleton.remove();
            }

            if (skeleton.getRectangle().x < 0) {
                hp-=200;
                iter_skeleton.remove();
            }
        }
    }

    int GomlemHP=0;

    private void golemUpdate() {
        Iterator<Golem> iter_golem = golemArray.iterator();
        while (iter_golem.hasNext()) {
            Golem golem = iter_golem.next();
            try {
                //for (int i = 0; i < swordmanOverlapArray.size; i++) {
                for (int i = 0; i < 20; i++) {
                    if (golem.getRectangle().overlaps(swordmanOverlapArray.get(i).getRectangle())) {
                        golem.getRectangle().x += 80 * Gdx.graphics.getDeltaTime();
                        swordmanOverlapArray.get(i).HP-=2;
                    }
                }
            } catch (IndexOutOfBoundsException s) {

            }

            golem.getRectangle().x -= 80 * Gdx.graphics.getDeltaTime();
            if (golem.getHP() < 0) {
                golem.changeAnimation(DIE);
                golem.getRectangle().x += 80 * Gdx.graphics.getDeltaTime();
                golem.HP--;
            }

            if (golem.getHP() < -40){
                iter_golem.remove();
            }

            if (golem.getRectangle().x < 0) {
                iter_golem.remove();
            }
        }
    }

    public void LV1()
    {
        if (zombieTime > 400) {
            spawnzombie();
            zombieTime = 0;
        }
    }

    public void LV2()
    {
        if (zombieTime > 400) {
            spawnzombie();
            zombieTime = 0;
        }

        if(skeletonTime >1000){
            spawnskeleton();
            skeletonTime= 0;
        }
    }

    public void LV3()
    {
        if (zombieTime > 400) {
            spawnzombie();
            zombieTime = 0;
        }

        if(skeletonTime >700){
            spawnskeleton();
            skeletonTime= 0;
        }
    }

    public void LV4()
    {
        if(golemTime == 0) {
            spawnGolem();
        }
        golemTime = 1;
    }

    private void timeUpdate() {
        timer++;
        GameTime++;
        if (timer > 6) {
            money++;
            timer = 0;
        }

       if(GameTime<=2000)
       {
           LV1();
       }
       if(GameTime>2500 && GameTime<=4000)
       {
           LV2();
       }
       if(GameTime > 4000 && GameTime <7000)
       {
           LV3();
       }
       if(GameTime > 7000)
       {

       }


        skeletonTime++;
        zombieTime++;
    }

    private void settingUnit(Rectangle rc){
        rc.x = -100;
        rc.y = 200;
        rc.width = 80;
        rc.height = 128;
    }

    private void settingEnemy(Rectangle rc){
        rc.x = 1500;
        rc.y = 202;
        rc.width = 80;
        rc.height = 128;
    }

    private void spawnSwordman() {
        Rectangle stickman = new Rectangle();
        settingUnit(stickman);
        Swordman swordman = new Swordman(stickman);
        swordmanArray.add(swordman);
    }

    private void spawnGunner() {
        Rectangle gunner = new Rectangle();
        settingUnit(gunner);
        gunner.width=80;
        Gunner gunner1 = new Gunner(gunner);
        gunnerArray.add(gunner1);
    }

    private void spawnLancer() {
        Rectangle lancer = new Rectangle();
        settingUnit(lancer);
        Lancer lancer1 = new Lancer(lancer);
        lancerArray.add(lancer1);
    }

    private void spawnRobot() {
        Rectangle robot = new Rectangle();
        settingUnit(robot);
        Robot robot1 = new Robot(robot);
        robotArray.add(robot1);
    }

    private void spawnzombie() {
        Rectangle zombie = new Rectangle();
        settingEnemy(zombie);
        Zombie zombie1 = new Zombie(zombie);
        zombieArray.add(zombie1);
    }

    private void spawnskeleton() {
        Rectangle skeleton = new Rectangle();
        settingEnemy(skeleton);
        Skeleton skeleton1 = new Skeleton(skeleton);
        skeletonArray.add(skeleton1);
    }

    private void spawnGolem(){
        Rectangle golem = new Rectangle();
        settingEnemy(golem);
        golem.width=120;
        Golem golem1 = new Golem(golem);
        golemArray.add(golem1);
    }

}

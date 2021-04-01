# Design-pattern

#### 介绍
设计模式代码

#### 使用说明

​	设计模式案例代码...更新中

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request



## 设计模式七大原则

1. 单一职责原则

   降低类的复杂度，提高可读性，可维护性，降低变更引起的风险

   + 如果一个类里一个方法对于不同对象需要执行的分支比较多或者改动大，可以进行**类分解**，只有逻辑足够简单，才可以违反单一职责原则
   + 如果类里面方法比较少，可以选择方法分解，而不用类分解

2. 接口隔离原则

   客户端不应该依赖不需要的接口，即一个类对另一个类的依赖应该建立在最小接口上，有必要可**拆分为多个接口**，按需实现，降低耦合

3. 依赖倒转原则

   接口依赖三种方式（接口传递，构造方法传递，setter方式传递）

   + 高层模块不应该依赖低层模块，二者都应该依赖其抽象
   + 抽象（接口或抽象类）不依赖细节（实现类），细节依赖抽象
   + 变量的声明类最好是接口或抽象类，变量引用和实际对象间存在一个缓冲层，便于扩展和优化
   + 继承时遵循里氏替换原则

4. 里氏替换原则

   + 引用基类的地方必须能透明的使用其子类的对象
   + 子类中尽量不重写父类的方法
   + 继承实际让两个类耦合性增强了，适当情况下可通过聚合、组合、依赖来解决问题

5. 开闭原则

   + 一个软件实体如类、模块、函数应该对**扩展开放（提供方），对修改关闭（使用方）**；用抽象构建框架，用实现扩展细节
   + 软件需要变化时，尽量通过扩展软件实体的行为来实现变化，而不通过修改原有代码
   
6. 迪米特法则

7. 组合/聚合复用原则



## 24种设计模式



### 0.工具类Utils

+ [完整代码](https://gitee.com/alexinv/design-pattern/blob/master/src/com/alex/designpattern/util/ConfigUtil.java)

```java
public static Object getBeanFromProp(String fileName, String key) {
    Object o = null;
    try {
        String className = getProperty(fileName, key);
        Class<?> clazz = Class.forName(className);
        o = clazz.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    } finally {
        return o;
    }
}

public static Object getBeanFromXml(String fileName, String key) {
    Object o = null;
    try {
        String className = getXmlConfig(fileName, key);
        Class<?> clazz = Class.forName(className);
        o = clazz.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    } finally {
        return o;
    }
}
```







### 1.工厂模式



#### 简单工厂模式

+ [图形创建](https://gitee.com/alexinv/design-pattern/tree/master/src/com/alex/designpattern/factory/simplefactory)

```java
public static Chart getChart(String charType){
    switch (charType.toLowerCase()) {
        case "histogram":
            return new Histogramchart();
        case "pin":
            return new Pinchart();
        case "line":
            return new Linechart();
        default:
            return null;
    }
}
```



#### 工厂方法

+ [Log](https://gitee.com/alexinv/design-pattern/tree/master/src/com/alex/designpattern/factory/log)

```java
public abstract class Logger {
    protected int currentLevel = LoggerLevel.INFO;
    /**
     * 输出日志
     * @param level 日志级别
     * @param logContent
     */
    abstract void writeLog(int level, String logContent);

    private void writeLogUnderCurrentLevel(int level, String logContent){
        if(level < currentLevel){
            return;
        }
        writeLog(level, logContent);
    }

    void info(String logContent){
        writeLog(LoggerLevel.INFO, logContent);
    }

    void warnning(String logContent){
        writeLog(LoggerLevel.WARNNING, logContent);
    }

    void error(String logContent){
        writeLog(LoggerLevel.ERROR, logContent);
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}
```

```java
public interface LoggerFactory {
    Logger createLogger();
    Logger createLogger(String param);
}
```

```java
// 日志级别
public interface LoggerLevel {
    public static final int INFO = 1;
    public static final int WARNNING = 2;
    public static final int ERROR = 3;
}
```



+ [图片阅读器](https://gitee.com/alexinv/design-pattern/tree/master/src/com/alex/designpattern/factory/picreader)

```java
public class JpgReader implements ImageReader{
    @Override
    public Pic read(String path) {
        return new JpgPic(path);
    }
}
```

```java
public class GifReader implements ImageReader{
    @Override
    public Pic read(String path) {
        return new GifPic(path);
    }
}
```



#### 抽象工厂

+ [skin](https://gitee.com/alexinv/design-pattern/tree/master/src/com/alex/designpattern/factory/skin)

<img src="D:\Coding\Java\设计模式\project\design-pattern\img\skin_uml.png" alt="skin_uml" style="zoom: 80%;" />



```java
public interface SkinFactory {
    Button createButton();
    TexField createTexField();
    ComboBox createComboBox();
}
```

```java
public interface Button {
    void click();
    void display();
}
```

```java
public interface TexField {
    void inputText(String text);
    void display();
}
```

```java
public class SpringSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SpringButton();
    }
    @Override
    public TexField createTexField() {
        return new SpringTxtField();
    }
    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
```

```java
public class SummerSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SummerButton();
    }
    @Override
    public TexField createTexField() {
        return new SummerTxtField();
    }
    @Override
    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}
```



[os](https://gitee.com/alexinv/design-pattern/tree/master/src/com/alex/designpattern/factory/os)

<img src="D:\Coding\Java\设计模式\project\design-pattern\img\os_uml.png" alt="os_uml" style="zoom:80%;" />



```java
public class Client {
    public static void main(String[] args) {
        Button button = new Linux().createButton();
        button.info();

        new Windows().createText().info();
        new Unix().createButton().info();
    }
}
```

```java
public interface Os {
    Button createButton();
    Text createText();
}
```

```java
public class Windows implements Os{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Text createText() {
        return new WindowsText();
    }
}
```





---



###  2.建造者模式

+ [game](https://gitee.com/alexinv/design-pattern/tree/master/src/com/alex/designpattern/builder/game)

```java
@NoArgsConstructor
@Getter and Setter
@ToString
public class Actor {
	private String type;
	private String sex;
	private String face;
	private String costume;
	private String hairstyle;
}
```



```java
/**
 * 抽象建造者
 */
public abstract class ActorBuilder {
	protected Actor actor = new Actor();
	public abstract void buildType();
	public abstract void buildSex();
	public abstract void buildFace();
	public abstract void buildCostume();
	public abstract void buildHairstyle();
	// 勾子方法
	public boolean isBareheaded(){
		return false;
	}
	protected Actor createActor(){
		return actor;
	}
}
```

```java
public class DevilBuilder extends ActorBuilder{
	@Override
	public void buildType() {
		actor.setType("devil");
	}
	@Override
	public void buildSex() {
		actor.setSex("male");
	}
	@Override
	public void buildFace() {
		actor.setFace("argly");
	}
	@Override
	public void buildCostume() {
		actor.setCostume("fe");
	}
	@Override
	public void buildHairstyle() {
		// actor.setHairstyle("bod");
	}
	@Override
	public boolean isBareheaded() {
		return true;
	}
}
```

```java
public Actor construct(ActorBuilder ab){
    ab.buildType();
    ab.buildSex();
    ab.buildFace();
    ab.buildCostume();
    if(!ab.isBareheaded()){
        ab.buildHairstyle();
    }
    return ab.createActor();
}
```



+ [computer]()

```java
@NoArgsConstructor
@Getter and Setter
@ToString
public class Actor {
	private String type;
	private String sex;
	private String face;
	private String costume;
	private String hairstyle;
}
```

```java
public abstract class ComputerBuilder {
	protected Computer computer = new Computer();
	public abstract void buildCpu();
	public abstract void buildMemory();
	public abstract void buildHardware();
	public abstract void buildMainBoard();
	public abstract void buildMonitor();
	public boolean isMonitor(){
		return true;
	}
	protected Computer create(){
		return computer;
	}
}
```

```java
public class Server extends ComputerBuilder{
	@Override
	public void buildCpu() {
		computer.setCpu("Intel");
	}
	@Override
	public void buildMemory() {
		computer.setMemory(128);
	}
	@Override
	public void buildHardware() {
		computer.setHardware(102400);
	}
	@Override
	public void buildMainBoard() {
		computer.setMainBoard("MSI");
	}
	@Override
	public void buildMonitor() {
	}
	@Override
	public boolean isMonitor() {
		return false;    // 钩子方法，不创建monitor
	}
}
```

```java
public Computer construct(ComputerBuilder cb){
    cb.buildCpu();
    cb.buildMemory();
    cb.buildHardware();
    cb.buildMainBoard();
    if(cb.isMonitor()){
        cb.buildMonitor();
    }
    return cb.create();
}
```





---





### 3.原型模式

[浅拷贝](https://gitee.com/alexinv/design-pattern/tree/master/src/com/alex/designpattern/Prototype/shallowcopy)

```java
@NoArgsConstructor
@Getter and Setter
@ToString
public class Student implements Cloneable{    // 实现Cloneable接口
	private String no;
	private String name;
	private int age;
	private List<String> classmate;

	@Override
	protected Student clone() throws CloneNotSupportedException {
		Student student = new Student();
		student.setNo(no);
		student.setName(name);
		student.setAge(age);
		List<String> newClassMate = new ArrayList<>(classmate);
		student.setClassmate(newClassMate);     // 引用类型不能直接clone()

		return student;
	}
}
```



[深拷贝](https://gitee.com/alexinv/design-pattern/tree/master/src/com/alex/designpattern/Prototype/weekreport)

```java
@NoArgsConstructor
@Getter and Setter
@ToString
public class WeeklyLog implements Serializable {    // 实现Serializable接口
	private String name;
	private String date;
	private String content;

	// 对象序列化实现  <推荐>
	public WeeklyLog deepClone(){
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			// 序列化
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);    // 把当前对象一对象流方式输出

			// 反序列化
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			WeeklyLog copyObj = (WeeklyLog) ois.readObject();
			return copyObj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(bis != null)
					bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(bos != null)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
```





### 4.单例模式



​										<font color=deeppink>update...</font>




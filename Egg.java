package ExamQuestions;
//Chicken lays chicken egg.

//Different bird type lays diff eggs, correspondingly.
//Hatch twice will throw exception.

interface Bird {
	public Egg<Bird> layEgg();
}

class Chicken implements Bird {
	@Override
	public Egg<Bird> layEgg() {
		System.out.println("Egg laid.");
		return new Egg<Bird>();
	}
}

public class Egg<Animal> {
	boolean isHatched = false;

	private Bird createBird() {
		if (this.isHatched) {
			throw new UnsupportedOperationException();// RuntimeException
		}

		return new Chicken();
	}

	public Bird hatch() {
		Bird bird = null;
		try {
			bird = createBird();
			System.out.println("Egg Hatched, wow it's a baby bird!!!");
			this.isHatched = true;
		} catch (UnsupportedOperationException e) {
			System.out.println("The same egg cannot be hatched twice.");
			;
		}
		return bird;
	}

	public static void main(String[] args) {
		Chicken chicken1 = new Chicken();
		Chicken chicken2 = new Chicken();
		Egg egg = chicken1.layEgg();
		Egg egg2 = chicken2.layEgg();
		Bird childChicken = egg.hatch();
		Bird childChicken2 = egg2.hatch();
		Bird childChicken3 = egg.hatch();

	}
}



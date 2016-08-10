package io.github.elytra.hallways;

@FunctionalInterface
public interface CellCallable<T> {
	public void call(VectorField<T> field, int x, int y);
}

package java_exercise;

public interface IShippableTask<E> {
    E execute() throws Exception;
}
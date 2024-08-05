## Readme <hr />
### Best Practices <hr />
1.1 Open Closed principle
* Class should be open for extension but closed for modification 
* Used in decorator pattern

### Decorator Pattern <hr />
* Attaches additional responsibilities to object dynamically.
* Flexible alternatives to subclassing for extending functionality.
* Decorators has same supertype as the objects they decorate
* Decorators can add behavior either before / after delegating to the object.
* Since type of decorator and supertype is same, so we can pass decorated object instead of actual object. But implementation should be coded to abstraction and not concrete type.
* Decorators have has-a relationship with type it decorates
* It uses interface for type matching, but uses composition for behavior

# Scala Collections
> If you’re coming to Scala from Java, the best thing you can do is forget about the Java collections classes and use the Scala collections classes as they’re intended to be used. As one author of this book has said, “Speaking from personal experience, when I first started working with Scala I tried to use Java collections classes in my Scala code, and all that did was slow down my progress.”

## The main Scala collections classes
**The main Scala collections classes you’ll use on a regular basis are:**

- [`ArrayBuffer`](https://docs.scala-lang.org/overviews/scala-book/arraybuffer-examples.html)
  - an indexed, mutable sequence
- [`List`](https://docs.scala-lang.org/overviews/scala-book/list-class.html)
  - a linear (linked list), immutable sequence
- [`Vector`](https://docs.scala-lang.org/overviews/scala-book/vector-class.html)
  - an indexed, immutable sequence
- [`Map`](https://docs.scala-lang.org/overviews/scala-book/map-class.html)
  - the base Map (key/value pairs) class
- [`Set`](https://docs.scala-lang.org/overviews/scala-book/set-class.html)
  - the base Set class

`Map` and `Set` come in both mutable and immutable versions.

Whenever we use the word immutable, it’s safe to assume that the class is intended for use in a functional programming (FP) style. With these classes you don’t modify the collection; you apply functional methods to the collection to create a new result. You’ll see what this means in the examples that follow.
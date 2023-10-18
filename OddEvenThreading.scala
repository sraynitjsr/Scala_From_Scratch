object OddEvenPrinter extends App {
  val lock = new Object()
  var number = 1
  val maxCount = 10
  
  val oddThread = new Thread(new Runnable {
    def run() {
      while (number <= maxCount) {
        lock.synchronized {
          if (number % 2 != 0) {
            println(s"Odd: $number")
            number += 1
            lock.notify()
          } else {
            lock.wait()
          }
        }
      }
    }
  })

  val evenThread = new Thread(new Runnable {
    def run() {
      while (number <= maxCount) {
        lock.synchronized {
          if (number % 2 == 0) {
            println(s"Even: $number")
            number += 1
            lock.notify()
          } else {
            lock.wait()
          }
        }
      }
    }
  })

  oddThread.start()
  evenThread.start()

  oddThread.join()
  evenThread.join()
}

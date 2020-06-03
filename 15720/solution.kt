fun main(args: Array<out String>) {
    val discountable = readLine()!!.split(" ").map { it.toInt() }.min()!!
    val burgers = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()
    val sideMenus = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()
    val drinks = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()

    println(burgers.sum() + sideMenus.sum() + drinks.sum())
    println(
        burgers.take(discountable).sum() * 9 / 10 + burgers.drop(discountable).sum() +
        sideMenus.take(discountable).sum() * 9 / 10 + sideMenus.drop(discountable).sum() +
        drinks.take(discountable).sum() * 9 / 10 + drinks.drop(discountable).sum()
    )
}
package dev.bluefalcon

actual object BlueFalcon : AbsBluetooth() {
    actual override val bluetooth: Bluetooth
        get() = getOrInitBluetooth()

    private var bluetoothRef: Bluetooth? = null

    actual fun init(bluetooth: Bluetooth) {
        if (bluetoothRef != null)
            throw IllegalStateException("Bluetooth already initialized")
        bluetoothRef = bluetooth
    }

    private fun getOrInitBluetooth(): Bluetooth {
        val bluetooth = bluetoothRef
        if (bluetooth == null) {

            BlueFalcon.initDefault()
            return bluetoothRef!!
        }
        return bluetooth
    }
}
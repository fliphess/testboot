TARGETS = mountkernfs.sh udev mountdevsubfs.sh resolvconf mountall.sh mountall-bootclean.sh networking mountnfs.sh mountnfs-bootclean.sh hwclock.sh urandom checkroot.sh hostname.sh bootlogd procps screen-cleanup stop-bootlogd-single bootmisc.sh kmod mtab.sh checkfs.sh checkroot-bootclean.sh udev-mtab
INTERACTIVE = udev checkroot.sh checkfs.sh
udev: mountkernfs.sh
mountdevsubfs.sh: mountkernfs.sh udev
resolvconf: mountall.sh mountall-bootclean.sh
mountall.sh: checkfs.sh checkroot-bootclean.sh
mountall-bootclean.sh: mountall.sh
networking: resolvconf mountkernfs.sh mountall.sh mountall-bootclean.sh urandom
mountnfs.sh: mountall.sh mountall-bootclean.sh networking
mountnfs-bootclean.sh: mountall.sh mountall-bootclean.sh mountnfs.sh
hwclock.sh: mountdevsubfs.sh bootlogd
urandom: mountall.sh mountall-bootclean.sh hwclock.sh
checkroot.sh: hwclock.sh mountdevsubfs.sh hostname.sh bootlogd
hostname.sh: bootlogd
bootlogd: mountdevsubfs.sh
procps: bootlogd mountkernfs.sh mountall.sh mountall-bootclean.sh udev
screen-cleanup: mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh
stop-bootlogd-single: mountall.sh mountall-bootclean.sh udev resolvconf networking mountnfs.sh mountnfs-bootclean.sh hwclock.sh mountkernfs.sh urandom mountdevsubfs.sh checkroot.sh hostname.sh bootlogd procps screen-cleanup bootmisc.sh kmod mtab.sh checkfs.sh checkroot-bootclean.sh udev-mtab
bootmisc.sh: mountnfs-bootclean.sh checkroot-bootclean.sh mountall.sh mountall-bootclean.sh mountnfs.sh udev
kmod: checkroot.sh
mtab.sh: checkroot.sh
checkfs.sh: checkroot.sh mtab.sh
checkroot-bootclean.sh: checkroot.sh
udev-mtab: udev mountall.sh mountall-bootclean.sh
